package com.huige;

public class QuickSort {
	public static int sortCount=0;
	
	//��ȡ���������׼���������λ��
	public static int getMidData(int a[], int start, int end) {
		// ��endΪ��׼��
		int base = a[end];
		while (start < end) {
			while (start < end && a[start] < base) {
				start++;
				sortCount++;
			}
			// ����ѭ����������ζ���ڻ�׼ֵ����ҵ��˱Ȼ�׼ֵ���Ԫ��
			if (start < end) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				// �����󣬴�ʱ���Ǹ���������ֵҲͬʱ��������ȷ��λ��(��׼ֵ�ұ�)������ұ�ҲҪͬʱ��ǰ�ƶ�һλ
				end--;
				sortCount++;
			}
			while (start < end && a[end] > base) {
				end--;
				sortCount++;
			}
			// ����ѭ����������ζ���ڻ�׼ֵ�ұ��ҵ��˱Ȼ�׼ֵС��Ԫ��
			if (start < end) {
				int temp = a[start];
				a[start] = a[end];
				a[end] = temp;
				// �����󣬴�ʱ�Ǹ���������ֵҲ�ص���ȷλ�ã���׼ֵ����ߣ�,������ҲҪ��ǰ�ƶ�һλ
				start++;
				sortCount++;

			}

		}
		return end;
	}
	public static void quickSort(int a[],int start,int end){
		//˵���Ѿ��ָһ��Ԫ��һ�飬�����ٻ�����
		if(start>=end){
			return;
		}
		//������������׼ֵ��ߵĶ��Ȼ�׼ֵС���ұ߶��Ȼ�׼ֵ��
		int devidePosition=getMidData(a, start, end);
		//�ݹ�Էָ�����������ٽ�������
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
