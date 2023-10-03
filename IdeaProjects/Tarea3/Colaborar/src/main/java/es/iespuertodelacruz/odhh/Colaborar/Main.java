package es.iespuertodelacruz.odhh.Colaborar;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String command = "java -jar /home/dam2/Escritorio/owenPGV/IdeaProyects/Tarea3 " + i*10 + " /home/dam2/Escritorio/";
            ProcessBuilder pb = new ProcessBuilder(command);
        }

    }
}