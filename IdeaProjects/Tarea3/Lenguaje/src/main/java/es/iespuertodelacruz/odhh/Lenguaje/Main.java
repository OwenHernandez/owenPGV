package es.iespuertodelacruz.odhh.Lenguaje;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        String routeName = sc.nextLine();
        File file = new File(routeName);
        String fileStr = "";
        for (int i = 0; i < amount; i++) {
            String rndWord = "";
            int sizeWord = (int)(Math.random() * (11-5)+5);
            for (int j = 0; j < sizeWord; j++) {
                int rndNum = (int)(Math.random() * (123 - 97) + 97);
                String rndStr = (char)rndNum + "";
                rndWord += rndStr;
            }
            rndWord += "\n";
            fileStr += rndWord;
        }
        try(
                RandomAccessFile raf = new RandomAccessFile(file, "w");
                FileLock block = raf.getChannel().lock();
        ){
            raf.seek(raf.length());
            raf.writeChars(fileStr);
            block.release();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

