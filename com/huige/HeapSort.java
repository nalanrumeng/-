package com.huige;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapSort heapSort=new HeapSort();
		int [] array=new int[]{26,8,32,34,58,78,3,8,10};
		System.out.println("array before sort");
		for(int i=0;i<array.length;i++){
			System.out.println("array"+"["+i+"]"+"="+array[i]);
		}
		heapSort.heapsort(array);
		System.out.println("array after sort");
		for(int i=0;i<array.length;i++){
			System.out.println("array"+"["+i+"]"+"="+array[i]);
		}
		

	}
	public void heapsort(int [] array){
		if(array==null||array.length<=1){
			return;
		}
		//构建最大堆，找到最大的节点
		buildMaxHeap(array);
		for(int i=array.length-1;i>=1;i--){
			exchanged(array,0,i);
			MaxHeap(array,i,0);
		}
	}
	private void buildMaxHeap(int[] array) {
		// TODO Auto-generated method stub
		if(array==null||array.length<=1){
			return;
		}
		//只需要遍历一半二叉树节点，就能比较所有节点
		int half=(array.length-1)/2;
		//从后往前遍历，构建最大堆
		for(int i=half;i>=0;i--){
			MaxHeap(array,array.length,i);
		}
		
	}
	//params: length 需要处理array的长度，超过的长度意味着已经按照从小到大的顺序排列好了顺序，不需要更多的处理
	private void MaxHeap(int[] array, int length, int half) {
		// TODO Auto-generated method stub
		//左节点与父节点的关系如下：（ 1为根节点的关系）
		int left=2*half+1;
		int right=2*half+2;
		//记录最大值元素的位置，暂定父节点元素的值最大
		int largest=half;
		if(left<length&&(array[left]>array[half])){
			largest=left;
		}
		if(right<length&&(array[right]>array[largest])){
			largest=right;
		}
		//让子节点最大的和父节点交换位置
		if(half!=largest){
			exchanged(array,half,largest);
			//遍历下面的子节点
			MaxHeap(array,length,largest);
		}
		
	}
	private void exchanged(int [] array,int half, int largest) {
		// TODO Auto-generated method stub
		int temp=array[half];
		array[half]=array[largest];
		array[largest]=temp;
		
	}

}
