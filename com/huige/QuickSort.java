package com.huige;

public class QuickSort {
	public static int sortCount=0;
	
	//获取快速排序基准点排序完的位置
	public static int getMidData(int a[], int start, int end) {
		// 以end为基准点
		int base = a[end];
		while (start < end) {
			while (start < end && a[start] < base) {
				start++;
				sortCount++;
			}
			// 上面循环结束，意味着在基准值左边找到了比基准值大的元素
			if (start < end) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				// 交换后，此时的那个被调换的值也同时调到了正确的位置(基准值右边)，因此右边也要同时向前移动一位
				end--;
				sortCount++;
			}
			while (start < end && a[end] > base) {
				end--;
				sortCount++;
			}
			// 上面循环结束，意味着在基准值右边找到了比基准值小的元素
			if (start < end) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				// 交换后，此时那个被调换的值也回到正确位置（基准值得左边）,因此左边也要向前移动一位
				start++;
				sortCount++;

			}

		}
		return end;
	}
	public static void quickSort(int a[],int start,int end){
		//说明已经分割到一个元素一组，无需再划分了
		if(start>=end){
			return;
		}
		//这样下来，基准值左边的都比基准值小，右边都比基准值大
		int devidePosition=getMidData(a, start, end);
		//递归对分割出来的数组再进行排序
		quickSort(a,start,devidePosition-1);
		quickSort(a,devidePosition+1,end);
	}
	public static void main(String[] args) {
		int [] a={16,15,14,13,12,11,10,9};
		System.out.println("array before quickSort:  ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		quickSort(a, 0, a.length-1);
		System.out.println("array after quickSort:  ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		System.out.print("SortCount="+sortCount);
		
	}

}
