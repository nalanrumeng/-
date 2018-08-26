package com.huige;

public class BubbleSort {
	public  static void bubbleSort(){  
	     int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};  
	    int temp=0;  
	    for(int i=0;i<a.length-1;i++){  
	        for(int j=0;j<a.length-1-i;j++){  
	        if(a[j]>a[j+1]){  
	            temp=a[j];  
	            a[j]=a[j+1];  
	            a[j+1]=temp;  
	        }  
	        }  
	    }  
	    for(int i=0;i<a.length;i++)  
	        System.out.println(a[i]);     
	} 
	//Ñ¡ÔñÅÅÐò
	public static void SelectSort(){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51}; 
		int k;
		for(int i=0;i<a.length-1;i++){
			k=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[k]){
					k=j;
				}
			}
			if(k!=i){
				int temp=a[i];
				a[i]=a[k];
				a[k]=temp;
			}
			
		}
		 for(int i=0;i<a.length;i++)  
		        System.out.println(a[i]); 
	}
	//²åÈëÅÅÐò
	public static void insertSort(){
		int a[]={49,38,65,97,76,13,27,78,34,12,64,5,4,62,99,98,54,56,17,18,23,15,35,25,53,51}; 
		for(int i=1;i<a.length;i++){
			int temp=a[i];
			int in=i;
			while(in>0&&a[in-1]>=temp){
				a[in]=a[in-1];
				in--;
			}
			a[in]=temp;
		}
		 for(int i=0;i<a.length;i++)  
		        System.out.println(a[i]); 
	}
	public static void main(String[] args) {
//		bubbleSort();
//		SelectSort();
		insertSort();
	}

}
