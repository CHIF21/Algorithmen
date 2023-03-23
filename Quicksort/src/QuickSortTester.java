import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSortTester {

    private int[] feld;

    public QuickSortTester(int[] feld) {
        this.feld = feld;
    }

    public int[] getFeld() {
        return feld;
    }

    public void quicksort(int[] feld, int li, int re) {
        if(re > li) {
            int i = partiton(li, re);
            quicksort(feld, li, i - 1);
            quicksort(feld, i + 1, re);
        }
    }

    private int partiton(int li, int re) {
        int p = feld[re];
        int i = li - 1;
        int k = re;
        do {
            do {
                i++;
            } while(feld[i] < p);

            do {
                k--;
            } while(k >= 0 && feld[k] > p);

            if(i < k) {
                int help = feld[i];
                feld[i] = feld[k];
                feld[k] = help;
            }
        } while(i < k);

        int help = feld[i];
        feld[i] = feld[re];
        feld[re] = help;
        quicksort(feld, li, i-1);
        quicksort(feld, i + 1, re);
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3, 7, 2, 9, 10, 4};
        QuickSortTester sort = new QuickSortTester(array);
        sort.quicksort(array, 0, array.length-1);
        System.out.println(Arrays.toString(sort.getFeld()));
    }
}
