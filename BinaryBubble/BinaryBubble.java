package BinaryBubble;

import java.util.ArrayList;
import java.util.List;

public class BinaryBubble {
    private List<Integer> sortedList = new ArrayList<>();
    private int repeatedNums = 0;

    public BinaryBubble(List<Integer> sortedList) {
        this.sortedList = sortedList;
    }

    // hozzáad egy elemet a listához ha az még nincs benne,
    // bináris keresést használva buborék rendezés elvégzése után
    public void addToList(List<Integer> list, int num) {
        bubbleSort(list);
        if (binarySearch(list, 0, list.size() - 1, num)) {
            sortedList.add(num);
        } else {
            repeatedNums++;
        }
    }

    public List<Integer> getList() {
        return sortedList;
    }

    // visszaadja az ismétlés miatt kihagyott számok darabszámát
    public int getRepeatedNumCount() {
        return repeatedNums;
    }

    // Buborék rendezés megvalósítása, lényege, hogy sorban
    // végig iterál a listán és addig cserélgeti az elemeket,
    // amíg meg nem találja a helyüket egy számszerint növekvő rendezéshez
    public void bubbleSort(List<Integer> unsortedList) {
        int n = unsortedList.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (unsortedList.get(j) > unsortedList.get(j + 1)) {
                    int temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j + 1));
                    unsortedList.set(j + 1, temp);
                }
    }

    // Bináris keresés implementációja, lényege, hogy
    // rekurzívan hívja magát és felezi a rendezett listában
    // értelmezett keresési tartományt amíg meg nem találja a keresett
    // értéket, vagy már nem tud tovább mit felezni
    public boolean binarySearch(List<Integer> list, int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == x)
                return false;

            if (list.get(mid) > x)
                return binarySearch(list, left, mid - 1, x);

            return binarySearch(list, mid + 1, right, x);
        }

        return true;
    }
}
