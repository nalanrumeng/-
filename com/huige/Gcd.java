package com.huige;

public class Gcd {
	//ŷ����õݹ����������Լ��
	public int gcd(int m,int n){
		if(n==0){
			return m;
		}else{
			return gcd(n,m%n);
		}
	}
	public static void main(String[] args) {
		Gcd gcd=new Gcd();
		int x=gcd.gcd(198, 87);
		System.out.println("x="+x);
	}

}
