package com.shareWine;

public class shareWine {
	//���ɷ־��㷨
	//�ƶ�һ���ķ־Ʋ��ԣ�aֻ����b���ƣ�bֻ����c���ƣ�cֻ����a���ơ�����bΪ��ʱ��a������b���ƣ�����cͰ���󣬲���a����
	//��ʼ����Ͱ����
	int a=12,b=8,c=5;
	//Ҫ�ֵľ���
	int desWine=6;
	private int count=0;
	//params: aa,bb,ccΪa,b,c��ǰ�ľ�����
	public void shareWine(int aa,int bb,int cc){
		System.out.println("��ǰ����Ͱ����Ϊ��a="+aa+",b="+bb+",c="+cc);
		
		if(count==500){
			System.out.println("500���ڷֲ��˾ƣ�");
			return;
		}
		count++;
		if(aa==desWine||bb==desWine||cc==desWine){
			System.out.println("�ѷֵ�����ľ���");
			return;
		}else if(cc<c&&bb>0){
			if(bb+cc>c){
				shareWine(aa,bb-(c-cc),c);
			}else{
				shareWine(aa,0,cc+bb);
			}
		}else if(cc==c){
			if(cc+aa>a){
				shareWine(a,bb,cc-(a-aa));
			}else{
				shareWine(aa+cc,bb,0);
			}
			
		}else if(bb==0){
			if(aa>b){
				shareWine(aa-b,b,cc);
			}else{
				shareWine(0,aa,cc);
			}
		}
		
	}
	public static void main(String[] args) {
		shareWine mShareWine=new shareWine();
		mShareWine.shareWine(12, 0, 0);
	}

}
