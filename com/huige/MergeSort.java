package com.huige;

public class MergeSort {
	public static void sort(int [] a,int left,int right){
		if(left>=right){
			return;
		}
		int middle=(left+right)/2;
		sort(a,left,middle);
		sort(a,middle+1,right);
		merage(a,left,middle,right);
	}

	private static void merage(int[] a, int left, int middle, int right) {
		// TODO Auto-generated method stub
		int [] array=new int[a.length];
		int rightStart=middle+1;
		int temp=left;
		int third=left;
		//将两个小数组合并为大数组
		while(left<=middle&&rightStart<=right){
			if(a[left]<a[rightStart]){
				array[third++]=a[left++];
			}else {
				array[third++]=a[rightStart++];
			}
		}
		while(left<=middle){
			array[third++]=a[left++];
		}
		while(rightStart<=right){
			array[third++]=a[rightStart++];
		}
		while(temp<=right){
			a[temp]=array[temp];
			temp++;
		}
		
	}
	public static void main(String[] args) {
		int [] a={-1,9,3,-1,33,-2,9,29,13,53,32,54,53,85,9,5};
		sort(a,0,a.length-1);
		System.out.println("---------------------------");
		for(int n:a){
			System.out.print(n+"　");
		}
	}

}
