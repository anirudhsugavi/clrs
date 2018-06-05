package clrs.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// int[] a = { 5, 2, 4, 6, 1, 7, 3 };
		int[] a = { 31, 41, 59, 26, 41, 58 };
		
		insertionSortAscending(a);
		System.out.println(Arrays.toString(a));
		insertionSortDescending(a);
		System.out.println(Arrays.toString(a));
	}

	public static void insertionSortAscending(int[] a) {
		int n = a.length;
		for (int j = 1; j < n; j++) {
			int key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = key;
		}
	}

	public static void insertionSortDescending(int[] a) {
		int n = a.length;
		for (int j = 1; j < n; j++) {
			int key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] < key) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = key;
		}
	}
}
