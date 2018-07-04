package clrs.heap;

import java.util.Arrays;

/**
 * Provides all the methods and functionalities concerning a <i>Max-Heap</i>
 * data structure.
 * 
 * @author ani
 *
 */
public class MaxHeap {

    /**
     * The variable that keeps track of how many elements in the given <i>Heap</i>
     * satisfy the conditions for a <i>Max-Heap</i>.
     */
    private int heapSize;

    /**
     * <p>
     * Makes sure that the array <i>arr</i> conforms the requirements of a
     * <i>Max-Heap</i> from the node <i>i</i> in the array.
     * </p>
     * 
     * <p>
     * It starts by checking the largest element among the <i>i</i>th node and its
     * children. If <i>i</i>th node is the largest, then the algorithm stops right
     * there. Else, swaps the <i>i</i>th element with the largest of its children.
     * </p>
     * 
     * <p>
     * This logic is continued recursively until that last node adheres the
     * constrains of a <i>Max-Heap</i>.
     * </p>
     * 
     * @param arr
     *            The 1D array to work on
     * @param i
     *            The index of the node from which the array will be a
     *            <i>Max-Heap</i>
     * @param size
     *            The heap size of the array
     */
    public void maxHeapify(int[] arr, int i, int size) {
        heapSize = size;
        int left = left(i);
        int right = right(i);
        int largest;

        if (left < heapSize && arr[left] > arr[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, size);
        }
    }

    /**
     * <p>
     * Same as {@link #maxHeapify(int[], int, int)} but achieves the functionality
     * by running a loop instead of recursion.
     * </p>
     * 
     * @param arr
     *            The 1D array to work on
     * @param i
     *            The index of the node from which the array will be a
     *            <i>Max-Heap</i>
     */
    public void maxHeapifyLoop(int[] arr, int i) {
        heapSize = arr.length;

        while (i < arr.length) {
            int left = left(i);
            int right = right(i);
            int largest;
            if (left < heapSize && arr[left] > arr[i])
                largest = left;
            else
                largest = i;

            if (right < heapSize && arr[right] > arr[largest])
                largest = right;

            if (largest == i)
                break;

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            i = largest;
        }
    }

    /**
     * <p>
     * Turns the given array into a <i>Max-Heap</i>.
     * </p>
     * 
     * <p>
     * It starts at the last node and goes all the way up to the root, calling
     * {@link #maxHeapify(int[], int, int)} method at every node on its way.
     * </p>
     * 
     * <p>
     * Starting at the last node instead at the root spares duplication of the
     * effort of {@link #maxHeapify(int[], int, int)} method.
     * </p>
     * 
     * @param arr
     *            The array to convert into a <i>Max-Heap</i>
     */
    public void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    /**
     * <p>
     * Returns the left child of node <i>i</i>.
     * </p>
     * 
     * @param i
     *            The node whose left child needs to be found
     * @return Left child of node <i>i</i>
     */
    public int left(int i) {
        return 2 * i + 1;
    }

    /**
     * <p>
     * Returns the right child of node <i>i</i>.
     * </p>
     * 
     * @param i
     *            The node whose right child needs to be found
     * @return Right child of node <i>i</i>
     */
    public int right(int i) {
        return left(i) + 1;
    }

    /**
     * <p>
     * Returns the parent node of leaf/node <i>i</i>.
     * </p>
     * 
     * @param i
     *            The leaf/node whose parent node needs to be found
     * @return The parent of <i>i</i>
     */
    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Getter method of heapSize.
     * 
     * @return the heapSize
     */
    public int getHeapSize() {
        return heapSize;
    }

    /**
     * Setter method of heapSize.
     * 
     * @param heapSize
     *            the heapSize to set
     */
    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        int[] array = new int[] { 1, 16, 10, 8, 14, 9, 3, 2, 4, 7 };
        int[] array1 = new int[] { 17, 27, 3, 16, 10, 13, 1, 5, 0, 12, 4, 8, 9, 7 };
        int[] arrayClone = array.clone();
        int[] array1Clone = array1.clone();

        heap.maxHeapify(array, 1, array.length);
        heap.maxHeapify(array1, 2, array1.length);
        heap.maxHeapifyLoop(arrayClone, 1);
        heap.maxHeapifyLoop(array1Clone, 2);

        System.out.println(Arrays.equals(array, arrayClone));
        System.out.println(Arrays.equals(array1, array1Clone));

        System.out.println("Heap");
        heap.buildMaxHeap(array);
        heap.buildMaxHeap(array1);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));

        int[] makeMaxHeap = new int[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        heap.buildMaxHeap(makeMaxHeap);
        System.out.println(Arrays.toString(makeMaxHeap));
    }
}
