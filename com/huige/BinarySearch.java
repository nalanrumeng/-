package com.huige;

public class BinarySearch {
	public static int direactSearch(int data,int [] array){
		int left=0;
		int right=array.length-1;
		//left>right说明找不到该数据，返回-1
		while(left<=right){
			int middle=(left+right)/2;
			if(array[middle]<data){
				left=middle+1;
			}else if(array[middle]>data){
				right=middle-1;
			}else{
				System.out.println("找到了，该元素下标为"+middle);
				return middle;
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		int a[]={87,1,0,-2,-5,93,-23,12,9,7,39};
		for(int n:a){
			System.out.print(n+"　");
		}
		System.out.print("\n");
		HeapSort mHeepSort=new HeapSort();
		mHeepSort.heapsort(a);
		for(int n:a){
			System.out.print(n+"　");
		}
		System.out.print("\n");
		direactSearch(87, a);
		
		
	}

}
