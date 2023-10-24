package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class App {
    private static int boardSize = 5;
    private static char[][] board;
    private static boolean[][] marked;

    private static String barco1;
    private static boolean barco1Tocado;
    private static String barco2;
    private static boolean barco2Tocado;
    private static String barco3;
    private static boolean barco3Tocado;
    private static boolean gameOver = false;

    private static Semaphore turno = new Semaphore(1);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digame el tamaño del tablero");
        boardSize = sc.nextInt();sc.nextLine();
        //inicializa el tablero normal y el tablero para saber la casilla que ha sido disparada y los inicializa
        board = new char[boardSize][boardSize];
        marked = new boolean[boardSize][boardSize];
        initializeBoard();

        sc.close();
        //aqui empieza un hilo para que el usuario pueda jugar
        Thread userThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);

            //mientras no pierda el juego le va pidiendo inputs para jugar
            while (!gameOver) {
                //intentamos conseguir el permiso
                while (!turno.tryAcquire()) {}
                if (gameOver) {
                    boolean entradaValida = true;
                    while (entradaValida) {
                        System.out.print("Introduce una letra y un número (ejemplo: A2): ");
                        String input = scanner.nextLine();
                        //Este if comprueba si el tamaño del string no es mayor que dos y si lo es vuelve para arriba
                        if (input.length() != 2) {
                            System.out.println("Entrada inválida. Debe ser una letra y un número.");
                            continue;
                        }
                        //aqui separa la letra del numero
                        char letter = input.charAt(0);
                        int number = Character.getNumericValue(input.charAt(1));
                        //este if mira si la letra y el numero esten dentro del tamaño del tablero y comprueba si le ha dado
                        if (letter >= 'A' && letter < 'A' + boardSize && number >= 1 && number <= boardSize) {
                            checkGuess(letter - 'A', number - 1);
                            entradaValida = false;
                        } else {
                            System.out.println("Entrada inválida. Letra entre A y E, número entre 1 y 5.");
                        }

                    }
                    turno.release();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            scanner.close();

        });
        //Aqui comienza el hilo de la ia
        Thread gameThread = new Thread(() -> {

            Random random = new Random();
            while (!gameOver) {
                while(!turno.tryAcquire()){}
                if (gameOver) {
                    int row, col;
                    do {
                        row = random.nextInt(boardSize);
                        col = random.nextInt(boardSize);
                    } while (marked[row][col]);
                    markCell(row, col);

                    turno.release();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        userThread.start();
        gameThread.start();

        try {
            userThread.join();
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin del juego.");
    }

    /**
     * Rellena los espacios en los array board y marked para que todo se quede limpio
     * y tambien pone aleatoriamente la posicion de los barcos
     */
    private static void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '~'; // Agua
                marked[i][j] = false;
            }
        }
        //aqui saca los random y mira si todos los barcos han sido rellenados
        boolean barcosRellenados = false;
        while (!barcosRellenados) {
            int targetRow = (new Random()).nextInt(boardSize);
            int targetCol = (new Random()).nextInt(boardSize);
            //aqui mira si los random ya son las coordenadas de un barco
            if (!barco1.equals(targetRow + "" + targetCol)) {
                if (!barco2.equals(targetRow + "" + targetCol)) {
                    if (!barco3.equals(targetRow + "" + targetCol)) {
                        //si es asi los van metiendo a los barcos
                        if (barco1.equals("")) {
                            barco1 = targetRow + "" + targetCol;
                        } else if (barco2.equals("")) {
                            barco2 = targetRow + "" + targetCol;
                        } else {
                            barco3 = targetRow + "" + targetCol;
                            barcosRellenados = true;
                        }
                    }
                }
            }
        }

    }

    /**
     * Este metodo mira a ver si la casilla seleccionada por los parametros row y col tiene un barco
     * @param row coordenada x
     * @param col coordenada y
     */
    private static void checkGuess(int row, int col) {
        String coordenadas = row + "" + col;
        if ((coordenadas.equals(barco1) && !barco1Tocado) ||
                (coordenadas.equals(barco2) && !barco2Tocado) ||
                (coordenadas.equals(barco3) && !barco3Tocado)) {//aqui comprueba si las coordenadas dadas coinciden con las del barco
            //si es asi se acaba la partida
            System.out.println("¡Tocado y hundido! Has ganado.");
            gameOver = true;
        } else if (marked[row][col]) {
            //si no lo es y esa posicion ya le habian dado, le muestra un mensaje
            System.out.println("Ya habías seleccionado esta posición. Prueba de nuevo.");
        } else {
            //si no lo es pues falla y marca la casilla en el array marked
            System.out.println("Agua. Inténtalo de nuevo.");
            marked[row][col] = true;
        }
    }

    /**
     * Este metodo hace lo mismo que checkGuess pero para la ia
     * @param row
     * @param col
     */
    private static void markCell(int row, int col) {
        if (row == targetRow && col == targetCol) {
            System.out.println("¡El enemigo te ha tocado!");
            gameOver = true;
        } else {
            System.out.println("El enemigo ha disparado a la posición " + (char) ('A' + row) + (col + 1) + " - Agua.");
            marked[row][col] = true;
        }
    }
}