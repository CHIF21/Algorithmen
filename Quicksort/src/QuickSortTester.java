import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSortTester {

    public static int[] quicksort(int[] feld, int li, int re) {
        if(re > li) {
            int p = feld[re];
            int i = li - 1;
            int k = re;
            do {
                do {
                    i += 1;
                } while(feld[i] >= p);

                do {
                    k -= 1;
                } while(feld[k] <= p);

                if(i < k) {
                    int help = feld[i];
                    feld[i] = feld[k];
                    feld[k] = help;
                } else {
                    break;
                }

            } while(i >= k);

            int help = feld[i];
            feld[i] = feld[re];
            feld[re] = help;
            quicksort(feld, li, i-1);
            quicksort(feld, i + 1, re);
        }
        return feld;
    }

    public static void main(String[] args) {
        int[] feld = {8, 2, 4, 5, 3, 9, 1, 7, 7, 5};
        int[] result = QuickSortTester.quicksort(feld, 1, feld.length-1);
        System.out.println("Quicksort:");
        System.out.println(Arrays.toString(result));
    }
}
