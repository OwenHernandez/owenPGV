package es.iespuertodelacruz.odhh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        for (Integer num: arrayList) {
            System.out.println(num);
        }
    }
}
