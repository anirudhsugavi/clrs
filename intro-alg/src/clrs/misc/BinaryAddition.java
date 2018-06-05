package clrs.misc;

import java.util.Arrays;

public class BinaryAddition {

	public static void main(String[] args) {
		int[] a = {1,1,0,1,1};
		int[] b = {1,0,1,1,1};
		
		int[] sum = add(a, b);
		System.out.println(Arrays.toString(sum));
	}

	public static int[] add(int[]a, int[]b) {
		int n = a.length;
		int[] sum = new int[n + 1];
		
		int c = 0;
		
		for (int i = n - 1; i >= 0; i--) {
			sum[i + 1] = a[i] ^ b[i] ^ c;
			if ((c + a[i] + b[i]) > 1) {
				c = 1;
			}
		}
		sum[0] = c;
		return sum;
	}
}
