/**
 * Counting sort implementation.
 */
package clrs.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Implements the <i><strong>Counting Sort</strong></i> algorithm.
 * 
 * @author ani
 *
 */
public class CountingSort {

    /**
     * Sorts the given array using the <i><strong>Counting Sort</strong></i>
     * algorithm.
     * <p>
     * First, creates an array {@code count} that holds the number of occurrences of
     * each element of {@code array}. Next, {@code count} is converted to a
     * <i>Prefix sum</i> array. Prefix sum array helps in determining the correct
     * sorted position of an element of {@code array}.
     * </p>
     * <p>
     * For example, the {@code count[5]} represents the position of
     * {@code array[count[5] - 1]} in the sorted array {@code sorted}.
     * </p>
     * <p>
     * A new sorted array is created by inserting each element of {@code array} by
     * calculating its appropriate position, using the logic explained above.
     * </p>
     * 
     * @param array
     *            the array to sort
     * @param k
     *            the maximum value that the array can contain
     * @return the sorted array
     */
    public int[] countingSort(int[] array, int k) {
        final int n = array.length;
        int[] sorted = new int[n];
        int[] count = new int[k + 1];

        // count number of occurrences of each element
        for (int i = 0; i < n; i++) {
            count[array[i]] = count[array[i]] + 1;
        }

        // create prefix sum array
        for (int i = 1; i <= k; i++) {
            count[i] = count[i - 1] + count[i];
        }

        // insert each element into its sorted position
        for (int i = n - 1; i >= 0; i--) {
            int sortedIndex = count[array[i]] - 1;
            sorted[sortedIndex] = array[i];
            count[array[i]] = count[array[i]] - 1;
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            a[i] = rand.nextInt(16);
        }
        CountingSort c = new CountingSort();
        int[] sortedA = c.countingSort(a, 15);
        int[] coppyOfA = a.clone();
        Arrays.sort(coppyOfA);
        System.out.println(Arrays.equals(coppyOfA, sortedA));
    }
}
