package Leet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Leet word = new Leet();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.equals(""))
                break;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                int finalI = i;
                word.getLeetChars().forEach((k, v) -> {
                    if (line.charAt(finalI) == k) {
                        sb.append(v.get(getRandomNumberInRange(0, 2)));
                    }
                });
            }
            System.out.println(sb);
        }
    }

    // visszaad egy random számot a paraméterben megadott
    // határértékek között
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
