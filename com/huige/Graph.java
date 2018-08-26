package com.huige;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	// 顶点的数量
	public int VertexSize;
	public int[] vertexs;
	private int[][] matrix;
	private boolean[] isVisited;
	private static final int Max_Value = 1000;
	private static final int MAX_WEIGHT = 1000;
	private LinkedList<Integer> list = new LinkedList<>();

	public Graph(int VertexSize) {
		this.VertexSize = VertexSize;
		vertexs = new int[VertexSize];
		for (int i = 0; i < VertexSize; i++) {
			vertexs[i] = i;
		}
		matrix = new int[VertexSize][];
	}

	public int[] getVertexs() {
		return vertexs;
	}

	public int getOutDegree(int index) {
		int count = 0;
		for (int j = 0; j < VertexSize; j++) {
			if (matrix[index][j] > 0 && (matrix[index][j] < Max_Value)) {
				count++;
			}
		}
		return count;
	}

	public int getIntDegree(int index) {
		int count = 0;
		for (int i = 0; i < VertexSize; i++) {
			if (matrix[i][index] > 0 && (matrix[i][index] < Max_Value)) {
				count++;
			}
		}
		return count;
	}

	public void setVertexs(int[] vertexs) {
		this.vertexs = vertexs;
	}
	/**
	 * 获取两个顶点之间的权值
	 * @return
	 */
	public int getWeight(int v1,int v2){
		int weight = matrix[v1][v2];
		return weight == 0?0:(weight == MAX_WEIGHT?-1:weight);
	}

	// 获取某个节点的第一个临接节点
	public int getFirstNeighbour(int index) {
		int result = -1;
		for (int j = 0; j < VertexSize; j++) {
			if (matrix[index][j] > 0 && (matrix[index][j] < Max_Value)) {
				result = j;
				return result;
			}
		}
		return result;
	}

	// 获取某个节点相对于lastNode的首个临接节点
	public int getNextNeighbor(int index, int lastNode) {
		int result = -1;
		for (int j = lastNode + 1; j < VertexSize; j++) {
			if (matrix[index][j] > 0 && (matrix[index][j] < Max_Value)) {
				result = j;
				return result;
			}
		}
		return result;
	}

	private void DepthFirstSearch(int i) {
		isVisited[i] = true;
		int w = getFirstNeighbour(i);
		while (w != -1) {
			if (!isVisited[w]) {
				System.out.println("访问到了" + w + "节点");
				DepthFirstSearch(w);
			}
			// 如果上一个临接节点已经访问完了，就访问下一个临接节点
			w = getNextNeighbor(i, w);
		}
	}

	public void DepthFirstSearch() {
		isVisited = new boolean[VertexSize];
		for (int i = 0; i < VertexSize; i++) {
			if (!isVisited[i]) {
				System.out.println("访问到了" + i + "节点");
				DepthFirstSearch(i);
			}
		}
	}

	public void BroadFirstSearch(int i) {
		int u, w;
		isVisited = new boolean[VertexSize];
		if(!isVisited[i]){
			System.out.println("访问到了" + i + "节点");
			isVisited[i] = true;	
		}
		list.add(i);
		while (!list.isEmpty()) {
			u = (list.removeFirst()).intValue();
			w = getFirstNeighbour(u);
			while (w != -1) {
				//如果未访问，则访问，并且把它加到到队列中（主要是为了将来获取此节点的临接节点）
				if (!isVisited[w]) {
					System.out.println("访问到了" + w + "节点");
					isVisited[w] = true;
					list.add(w);
				}
				w = getNextNeighbor(u, w);
			}
		}

	}

//	public void prim() {
//		int[] lowcost = new int[VertexSize];// 最小代价顶点权值的数组,为0表示已经获取最小权值
//		int[] adjvex = new int[VertexSize];// 保存最小权值顶点的坐标
//		int min, mId, sum = 0;
//		for (int i = 1; i < VertexSize; i++) {
//			lowcost[i] = matrix[0][i];
//		}
//		for (int i = 1; i < VertexSize; i++) {
//			min = Max_Value;
//			mId = 0;
//			for (int j = 1; j < VertexSize; j++) {
//				if (lowcost[j] > 0 && (lowcost[j] < min)) {
//					min = lowcost[j];
//					mId = j;
//				}
//			}
//			System.out.println("顶点："+adjvex[mId]+"权值: "+min);
//			lowcost[mId]=0;
//			sum+=min;
//			for(int j = 1; j < VertexSize; j++) {
//				if(lowcost[j]!=0&&matrix[mId][j]<lowcost[j]){
//					lowcost[j]=matrix[mId][j];
//					adjvex[j]=mId;
//				}
//			}
//		}
//		System.out.println("最小生成树权值和:"+sum);
//	}
	public void prim(){
		int [] lowcost=new int[VertexSize];
		int[] adjext=new int[VertexSize];//保存最小生成树顶点的坐标
		int min,mId,sum;
		for(int i=1;i<VertexSize;i++){
			lowcost[i]=matrix[0][i];
		}
		sum=0;
		for(int i=1;i<VertexSize;i++){
			min=Max_Value;
			mId=0;
			for(int j=1;j<VertexSize;j++){
				if(lowcost[j]>0&&lowcost[j]<min){
					min=lowcost[j];
					mId=j;
				}
			}
			System.out.println("顶点："+adjext[mId]+"权值："+min);
			lowcost[mId]=0;
			sum+=min;
			for(int j=1;j<VertexSize;j++){
				if(lowcost[j]!=0&&matrix[mId][j]<lowcost[j]){
					lowcost[j]=matrix[mId][j];
					adjext[j]=mId;
				}
			}	
		}
		System.out.println("最小生成数的权值和为："+sum);
	}

	public static void main(String[] args) {
		Graph g = new Graph(9);
		// int[]a0=new int[]{0,Max_Value,Max_Value,Max_Value,6};
		// int[]a1=new int[]{9,0,3,Max_Value,Max_Value};
		// int[]a2=new int[]{2,Max_Value,0,5,Max_Value};
		// int[]a3=new int[]{Max_Value,Max_Value,Max_Value,0,1};
		// int[]a4=new int[]{Max_Value,Max_Value,Max_Value,Max_Value,0};

		int[] a0 = new int[] { 0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT };
		int[] a1 = new int[] { 10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12 };
		int[] a2 = new int[] { MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8 };
		int[] a3 = new int[] { MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21 };
		int[] a4 = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT };
		int[] a5 = new int[] { 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT };
		int[] a6 = new int[] { MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT };
		int[] a7 = new int[] { MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT };
		int[] a8 = new int[] { MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0 };
		g.matrix[0] = a0;
		g.matrix[1] = a1;
		g.matrix[2] = a2;
		g.matrix[3] = a3;
		g.matrix[4] = a4;
		g.matrix[5] = a5;
		g.matrix[6] = a6;
		g.matrix[7] = a7;
		g.matrix[8] = a8;
		// System.out.println("value="+g.getOutDegree(1));
		// System.out.println("value=" + g.getFirstNeighbour(7));
		// System.out.println("value=" + g.getNextNeighbor(3,8));
		// g.DepthFirstSearch();
		g.BroadFirstSearch(0);
		System.out.println("weight="+g.getWeight(2, 3));
		g.prim();
	}

}
