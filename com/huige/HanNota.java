package com.huige;

public class HanNota {
	//��¼�ƶ��Ĵ���
	int i=1;
	public void hanNota(int n,char from,char dependOn,char to){
		if(n==1){
			//���һ����ֻ��ѵ��̴�from�Ƶ�to����
			move(n,from,to);
		}else{
			hanNota(n-1,from,to,dependOn);//��һ�����Ƚ�n-1�����Ӵ�A����C�Ƶ�B
			move(n,from,to);//�����̴�A�Ƶ�C
			hanNota(n-1,dependOn,from,to);//����������n-1�����Ӵ�B����A�Ƶ�C
			
		}
		
	}
	public void move(int n,char from,char to){
		System.out.println("��"+i+++"���ƶ�����,��"+from+"��"+to);
	}
	public static void main(String[] args) {
		HanNota han=new HanNota();
		han.hanNota(12, 'A', 'B', 'C');
	}

}
