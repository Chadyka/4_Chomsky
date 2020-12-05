package BinaryBubble;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // inicializálunk egy listát amiben majd random számokat tárolunk
        // valamint egy BinaryBubble osztályú példányt ami megvalósítja
        // a buborék rendezést és bináris keresést
        List<Integer> nums = new ArrayList<>();
        BinaryBubble list = new BinaryBubble(nums);

        int randNumCount = 0;

        // hozzáadunk 100 random számot a listához
        for (int i = 0; i < 100; i++) {
            list.addToList(list.getList(), getRandomNumberInRange(-100, 100));
            randNumCount++;
        }

        // kiirjuk a kapott listát a console-ba
        StringBuilder sb = new StringBuilder();
        for (int el : list.getList()) {
            if (list.getList().get(list.getList().size() - 1) != el) {
                sb.append(el).append(", ");
            } else {
                sb.append(el);
            }
        }
        System.out.println(sb);
        System.out.println("Out of " + randNumCount + " random numbers, " + list.getRepeatedNumCount() + " were skipped due to being already present in list.");
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
