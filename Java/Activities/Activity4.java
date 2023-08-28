package activities;

import java.util.Arrays;

public class Activity4 {

	static void sort(int array1[]) {
		
		int x;

		for (int i = 1; i < array1.length; i++) {
			int compare1 = array1[i];
			int j = i - 1;

			while (j >= 0 && compare1 < array1[j]) {

				x = array1[j];
				array1[j] = array1[j + 1];
				array1[j + 1] = x;
				--j;
			}

		}

		System.out.println("Array after sorting"+Arrays.toString(array1));

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		int[] array = { 5, 2, 6, 3, 7, 8, 4, 7, 5, 3 };
		System.out.println("Array before sorting " + Arrays.toString(array));
		sort(array);

	}

}
