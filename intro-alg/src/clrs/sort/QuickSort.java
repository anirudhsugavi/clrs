/**
 * Quick sort implementation.
 */
package clrs.sort;

import java.util.Arrays;

/**
 * Employs the <i>Quicksort</i> technique to sort a given array.
 * 
 * @author ani
 *
 */
public class QuickSort {

    /**
     * The crux of the algorithm; divides the array into two sub-arrays.
     * <p>
     * The last element is considered to be the pivot, or the reference point for
     * dividing the array. All the elements lesser than or equal to the pivot will
     * make the left sub-array, and all the elements greater than the pivot, the
     * right sub-array.
     * </p>
     * 
     * @param a
     *            the array
     * @param low
     *            start index
     * @param high
     *            end index
     * @return the final index of the {@code pivot}
     */
    public int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);
            }
        }
        swap(a, ++i, high);
        return i;
    }

    /**
     * Sorts the given array using {@code QuickSort} algorithm.
     * 
     * @param a
     *            the array to sort
     */
    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * Sorts the given array using {@code QuckSort} algorithm.
     * <p>
     * The algorithm uses <i><strong>Divide-and-conquer</strong></i> method for
     * sorting the given array. Decides the pivot by calling
     * {@link #partition(int[], int, int)} method. Pivot will be at the correct
     * index in the sorted array.</br>
     * Then sorts the array recursively from index {@code 0} through
     * {@code pivot - 1}, and {@code pivot + 1} through {@code a.length - 1}.
     * </p>
     * 
     * @param a
     *            the array to sort
     * @param low
     *            first index
     * @param high
     *            last index
     */
    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    /**
     * Swaps elements at i and j.
     * 
     * @param a
     *            the array
     * @param i
     *            index of first element
     * @param j
     *            index of second element
     */
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1, 16, 10, 8, 14, 9, 3, 2, 4, 7 };
        int[] array1 = new int[] { 17, 27, 3, 16, 10, 13, 1, 5, 0, 12, 4, 8, 9, 7 };

        QuickSort qs = new QuickSort();
        qs.quickSort(array);
        qs.quickSort(array1);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
    }
}
