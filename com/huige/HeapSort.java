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
		//�������ѣ��ҵ����Ľڵ�
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
		//ֻ��Ҫ����һ��������ڵ㣬���ܱȽ����нڵ�
		int half=(array.length-1)/2;
		//�Ӻ���ǰ��������������
		for(int i=half;i>=0;i--){
			MaxHeap(array,array.length,i);
		}
		
	}
	//params: length ��Ҫ����array�ĳ��ȣ������ĳ�����ζ���Ѿ����մ�С�����˳�����к���˳�򣬲���Ҫ����Ĵ���
	private void MaxHeap(int[] array, int length, int half) {
		// TODO Auto-generated method stub
		//��ڵ��븸�ڵ�Ĺ�ϵ���£��� 1Ϊ���ڵ�Ĺ�ϵ��
		int left=2*half+1;
		int right=2*half+2;
		//��¼���ֵԪ�ص�λ�ã��ݶ����ڵ�Ԫ�ص�ֵ���
		int largest=half;
		if(left<length&&(array[left]>array[half])){
			largest=left;
		}
		if(right<length&&(array[right]>array[largest])){
			largest=right;
		}
		//���ӽڵ����ĺ͸��ڵ㽻��λ��
		if(half!=largest){
			exchanged(array,half,largest);
			//����������ӽڵ�
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
