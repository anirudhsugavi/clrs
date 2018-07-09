package clrs.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Implements the <i><strong>Radix Sort</strong></i> Algorithm.
 * 
 * @author ani
 *
 */
public class RadixSort {

    /**
     * Sorts the array using the <i><strong>Radix Sort</strong></i> algorithm.
     * <p>
     * Elements are sorted by LSB to MSB using a little modified version of
     * <i>Counting Sort</i> using {@link #countingSortForRadixSort(int[], int)}.
     * </p>
     * 
     * @param array
     *            the array to sort
     * 
     * @see CountingSort#countingSort(int[], int)
     */
    public void radixSort(int[] array) {
        int max = getMax(array);

        for (int exp = 1; (max / exp > 0); exp *= 10) {
            countingSortForRadixSort(array, exp);
        }
    }

    /**
     * Implements a modified version of the <i>Counting Sort</i> to suit the needs
     * of <i>Radix Sort</i>.
     * 
     * @param array
     *            the array to sort
     * @param exp
     *            the exponent of 10
     * 
     * @see CountingSort#countingSort(int[], int)
     */
    private void countingSortForRadixSort(int[] array, int exp) {
        final int size = array.length;
        int[] count = new int[10];
        int[] sorted = new int[size];

        for (int i = 0; i < size; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            int sortedIndex = count[(array[i] / exp) % 10] - 1;
            sorted[sortedIndex] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < size; i++) {
            array[i] = sorted[i];
        }
    }

    /**
     * Finds the maximum element in the given array.
     * 
     * @param array
     *            the array
     * @return the maximum element in the array
     */
    private int getMax(int[] array) {
        int max = array[0];
        for (int a : array) {
            if (a > max) {
                max = a;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            a[i] = rand.nextInt(10002);
        }
        int[] copyOfA = a.clone();

        RadixSort rx = new RadixSort();
        rx.radixSort(a);
        Arrays.sort(copyOfA);

        System.out.println(Arrays.equals(a, copyOfA));
    }
}
