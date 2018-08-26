package com.huige;

public class HeerSort {
	public static void main(String[] args) {
		int a[] = { 1, 33, -3, 48, 332, 38, 1, 9, 3, 4, 198, 44, 23, 64, 39, 10, 94, 21, 39, 2 };
		int d = a.length / 2;
		while (true) {
			// 遍历数组所有元素
			for (int i = 0; i < d; i++) {
				for (int j = i; j + d < a.length; j += d) {
					int temp;
					if (a[j] > a[j + d]) {
						temp = a[j];
						a[j] = a[j + d];
						a[j + d] = temp;
					}
				}	
			}
			System.out.println("d=  " + d);
			if (d == 1)
				break;
			d--;

		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
