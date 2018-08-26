package com.dn.LSB;

public class LSB {
	public static int [][]dp;
	public static StringBuilder builder=new StringBuilder();
	int smallValueB=-1;
	int smallValueA=-1;
	//�ö�̬�滮�������ַ��������������
	public int getLSB(String A,String B){
		int n=A.length();
		int m=B.length();
		char [] a=A.toCharArray();
		char [] b=B.toCharArray();
		dp=new int[m][n];
		
		//����b�ַ�������b��a[0]��ȵ��ַ���Ϊ1(��һ�У�
		//��ʼ����һ�к͵�һ��
		for(int i=0;i<m;i++){
			if(b[i]==a[0]){
				dp[i][0]=1;
				//��ʱֻ�����������һ�ַ���ȣ�����Ҫ�ӵ�����������
//				if(i==0){
//					builder.append(a[0]);
//				}
				smallValueB=i;
				for(int j=i+1;j<m;j++){
					dp[j][0]=1;
				}
				break;
			}
			
		}
		for(int i=0;i<n;i++){
			if(a[i]==b[0]){
//				System.out.println("b[0]="+b[0]);
				dp[0][i]=1;
				//��ʱֻ�����������һ�ַ���ȣ�����Ҫ�ӵ�����������
//				if(i==0){
//					builder.append(b[0]);
//				}
				smallValueA=i;
				for(int j=i+1;j<n;j++){
					dp[0][j]=1;
//					System.out.println("j="+j);
				}
				break;
			}
		}
		if(smallValueA!=-1||smallValueB!=-1){
			if(smallValueA<=smallValueB){
				//��ӵ�һ����ͬ������Ĺ����ַ�
				if(smallValueA!=-1){
					builder.append(a[smallValueA]);
				}else{
					builder.append(b[smallValueB]);
				}
			}else{
				if(smallValueB!=-1){
				builder.append(b[smallValueB]);
				}else{
					builder.append(a[smallValueA]);
				}
			}
		}
		for(int i=1;i<m;i++){
			boolean flag=false;
			for(int j=1;j<n;j++){
				
				if(a[j]==b[i]){
					dp[i][j]=dp[i-1][j-1]+1;
					
					if(!flag){
					System.out.println("i and j="+i+" "+j);
					builder.append(a[j]);
					flag=true;
				 }
				}else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		//�������ֵ
		return dp[m-1][n-1];
		
	}
	public static void main(String[] args) {
		String A="etanroideeomandom";
		String B="random";
		LSB lsb=new LSB();
		System.out.println("MaxCommomStringLength="+lsb.getLSB(A, B));
		for(int i=0;i<B.length();i++){
			for(int j=0;j<A.length();j++){
				System.out.print(dp[i][j]);	
			}
			System.out.println();
		}
		System.out.println("StringBuilder="+builder.toString());
		
	}

}
