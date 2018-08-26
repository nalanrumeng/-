package com.huige;

public class HanNota {
	//记录移动的次数
	int i=1;
	public void hanNota(int n,char from,char dependOn,char to){
		if(n==1){
			//最后一步，只需把底盘从from移到to就行
			move(n,from,to);
		}else{
			hanNota(n-1,from,to,dependOn);//第一步，先将n-1个盘子从A依赖C移到B
			move(n,from,to);//将底盘从A移到C
			hanNota(n-1,dependOn,from,to);//第三步，将n-1个盘子从B依赖A移到C
			
		}
		
	}
	public void move(int n,char from,char to){
		System.out.println("第"+i+++"次移动盘子,从"+from+"到"+to);
	}
	public static void main(String[] args) {
		HanNota han=new HanNota();
		han.hanNota(12, 'A', 'B', 'C');
	}

}
