package com.shareWine;

public class shareWine {
	//泊松分酒算法
	//制定一定的分酒策略，a只能往b倒酒，b只能往c倒酒，c只能往a倒酒。仅当b为空时，a才能往b倒酒；仅当c桶满后，才往a倒酒
	//初始各酒桶容量
	int a=12,b=8,c=5;
	//要分的酒量
	int desWine=6;
	private int count=0;
	//params: aa,bb,cc为a,b,c当前的酒容量
	public void shareWine(int aa,int bb,int cc){
		System.out.println("当前各酒桶容量为：a="+aa+",b="+bb+",c="+cc);
		
		if(count==500){
			System.out.println("500次内分不了酒！");
			return;
		}
		count++;
		if(aa==desWine||bb==desWine||cc==desWine){
			System.out.println("已分到所需的酒量");
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
