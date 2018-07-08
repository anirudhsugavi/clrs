package clrs.sort;

import java.util.Arrays;

/**
 * Implements the <i><strong>Merge Sort</strong></i> algorithm.
 * 
 * @author ani
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = { 31, 41, 59, 26, 41, 58 };
        mergeSort(array);
        System.out.println(Arrays.toString(array));

        int[] randArray = new int[100];
        for (int i = 0; i < 100; i++) {
            int randNum = (int) (Math.random() * 10);
            randArray[i] = randNum;
        }
        int[] copyRandArray = randArray.clone();
        mergeSort(randArray);
        Arrays.sort(copyRandArray);
        System.out.println(Arrays.equals(randArray, copyRandArray));
    }

    /**
     * Sorts the given array using the <i>Merge Sort</i> algorithm.
     * 
     * @param array
     *            the array to sort
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * Sorts the given array using the <i>Merge Sort</i> algorithm.
     * 
     * <p>
     * The algorithm uses <i><strong>Divide-and-conquer</strong></i> method for
     * sorting the given array. The {@code array} is recursively divided at the
     * mid-point into two sub arrays. Each sub array is merged by placing the
     * elements at their correct positions by the method
     * {@link #merge(int[], int, int, int)}.
     * </p>
     * 
     * @param array
     *            the array to sort
     * @param left
     *            left/first index of the array
     * @param right
     *            the right/last index of the array
     */
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    /**
     * Merges the two sub arrays created from the given array.
     * <p>
     * Two sub arrays, {@code leftArray} and {@code rightArray} are created from the
     * given {@code array}. These two arrays are merged by selecting the smallest
     * element of the two arrays.
     * </p>
     * 
     * @param array
     *            the array to merge
     * @param left
     *            the left index of the array
     * @param middle
     *            the middle index of the array
     * @param right
     *            the right index of the array
     */
    private static void merge(int[] array, int left, int middle, int right) {
        int leftArraySize = middle - left + 1;
        int rightArraySize = right - middle;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftArraySize && j < rightArraySize) {
            array[k++] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
        }

        while (i < leftArraySize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArraySize) {
            array[k++] = rightArray[j++];
        }
    }
}
