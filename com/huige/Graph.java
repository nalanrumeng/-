package com.huige;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	// ���������
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
	 * ��ȡ��������֮���Ȩֵ
	 * @return
	 */
	public int getWeight(int v1,int v2){
		int weight = matrix[v1][v2];
		return weight == 0?0:(weight == MAX_WEIGHT?-1:weight);
	}

	// ��ȡĳ���ڵ�ĵ�һ���ٽӽڵ�
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

	// ��ȡĳ���ڵ������lastNode���׸��ٽӽڵ�
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
				System.out.println("���ʵ���" + w + "�ڵ�");
				DepthFirstSearch(w);
			}
			// �����һ���ٽӽڵ��Ѿ��������ˣ��ͷ�����һ���ٽӽڵ�
			w = getNextNeighbor(i, w);
		}
	}

	public void DepthFirstSearch() {
		isVisited = new boolean[VertexSize];
		for (int i = 0; i < VertexSize; i++) {
			if (!isVisited[i]) {
				System.out.println("���ʵ���" + i + "�ڵ�");
				DepthFirstSearch(i);
			}
		}
	}

	public void BroadFirstSearch(int i) {
		int u, w;
		isVisited = new boolean[VertexSize];
		if(!isVisited[i]){
			System.out.println("���ʵ���" + i + "�ڵ�");
			isVisited[i] = true;	
		}
		list.add(i);
		while (!list.isEmpty()) {
			u = (list.removeFirst()).intValue();
			w = getFirstNeighbour(u);
			while (w != -1) {
				//���δ���ʣ�����ʣ����Ұ����ӵ��������У���Ҫ��Ϊ�˽�����ȡ�˽ڵ���ٽӽڵ㣩
				if (!isVisited[w]) {
					System.out.println("���ʵ���" + w + "�ڵ�");
					isVisited[w] = true;
					list.add(w);
				}
				w = getNextNeighbor(u, w);
			}
		}

	}

//	public void prim() {
//		int[] lowcost = new int[VertexSize];// ��С���۶���Ȩֵ������,Ϊ0��ʾ�Ѿ���ȡ��СȨֵ
//		int[] adjvex = new int[VertexSize];// ������СȨֵ���������
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
//			System.out.println("���㣺"+adjvex[mId]+"Ȩֵ: "+min);
//			lowcost[mId]=0;
//			sum+=min;
//			for(int j = 1; j < VertexSize; j++) {
//				if(lowcost[j]!=0&&matrix[mId][j]<lowcost[j]){
//					lowcost[j]=matrix[mId][j];
//					adjvex[j]=mId;
//				}
//			}
//		}
//		System.out.println("��С������Ȩֵ��:"+sum);
//	}
	public void prim(){
		int [] lowcost=new int[VertexSize];
		int[] adjext=new int[VertexSize];//������С���������������
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
			System.out.println("���㣺"+adjext[mId]+"Ȩֵ��"+min);
			lowcost[mId]=0;
			sum+=min;
			for(int j=1;j<VertexSize;j++){
				if(lowcost[j]!=0&&matrix[mId][j]<lowcost[j]){
					lowcost[j]=matrix[mId][j];
					adjext[j]=mId;
				}
			}	
		}
		System.out.println("��С��������Ȩֵ��Ϊ��"+sum);
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
