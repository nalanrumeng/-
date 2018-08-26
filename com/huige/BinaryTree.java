package com.huige;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	private TreeNode root = null;
	public static List<String> data = new ArrayList<>();
	public static String[] TreeData = "A,B,D,#,#,E,#,#,C,F,#,#,G,#,#".split(",");

	public BinaryTree() {
		root = new TreeNode(1, "A");
	}

	/**
	 * ���������� A B C D E F
	 */
	public void createBinaryTree() {
		TreeNode nodeB = new TreeNode(2, "B");
		TreeNode nodeC = new TreeNode(3, "C");
		TreeNode nodeD = new TreeNode(4, "D");
		TreeNode nodeE = new TreeNode(5, "E");
		TreeNode nodeF = new TreeNode(6, "F");
		TreeNode nodeG = new TreeNode(7,"G");
		root.leftChild = nodeB;
		root.rightChild = nodeC;
		nodeB.leftChild = nodeD;
		nodeB.rightChild = nodeE;
		nodeC.leftChild = nodeF;
		nodeC.rightChild=nodeG;
	}

	/*
	 * ʹ��ǰ������ķ�ʽ����������
	 * 
	 * @param index TreeNode index
	 * 
	 * @param
	 */
	public TreeNode PreCreateBinaryThree(int index, List<String> data) {
		if (data.size() == 0) {
			return null;
		}
		if(data.get(0).equals("#")){
			data.remove(0);
			return null;
		}
		TreeNode node = new TreeNode(index, data.get(0));
		if (index == 0) {
			root = node;
		}
		data.remove(0);
		while(data.size()>0){
		node.leftChild=PreCreateBinaryThree(++index, data);
		node.rightChild=PreCreateBinaryThree(++index, data);
		}

		return node;
	}

	/**
	 * ��������ĸ߶�
	 * 
	 * @author Administrator
	 *
	 */
	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int i = getHeight(node.leftChild);
			int j = getHeight(node.rightChild);
			return (i < j) ? j + 1 : i + 1;
		}
	}

	/**
	 * ��ȡ�������Ľ����
	 * 
	 * @author Administrator
	 *
	 */
	public int getSize() {
		return getSize(root);
	}

	private int getSize(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + getSize(node.leftChild) + getSize(node.rightChild);
		}
	}

	/**
	 * ǰ�������������
	 * 
	 * @author Administrator
	 *
	 */
	public void preOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			System.out.println("preOrder data:" + node.getData());
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}

	/**
	 * ǰ����������ǵ���
	 */

	public void nonRecOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while (!stack.isEmpty()) {
			// ��ջ�ͽ�ջ
			TreeNode n = stack.pop();// ���������
			// ѹ���ӽ��
			System.out.println("nonRecOrder data" + n.getData());
			if (n.rightChild != null) {
				stack.push(n.rightChild);

			}
			if (n.leftChild != null) {
				stack.push(n.leftChild);
			}
		}
	}

	/**
	 * ���������������
	 * 
	 * @author Administrator
	 *
	 */
	public void midOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			midOrder(node.leftChild);
			System.out.println("midOrder data:" + node.getData());
			midOrder(node.rightChild);
		}
	}
	


	/**
	 * ������������ǵ���
	 */
	public void nonMidOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();

		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.leftChild;

			} else {
				node = stack.pop();
				System.out.println("midOrder data:" + node.getData());
				node = node.rightChild;
			}
		}
	}

	/**
	 * ���������������
	 * 
	 * @author Administrator
	 *
	 */
	public void postOrder(TreeNode node) {
		if (node == null) {
			return;
		} else {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.println("postOrder data:" + node.getData());
		}
	}
	/**
	 * ������������ǵ���
	 * @author huige
	 *
	 */
	public void nonpostOrder(TreeNode node){
		
		Stack<TreeNode> stackParent=new Stack<>();
		Stack<TreeNode> stackChild=new Stack<>();
		while(node!=null||stackParent.size()>0){
			if(node!=null){
				stackParent.push(node);
				stackChild.push(node);
				node=node.rightChild;
			}else{
				node=stackParent.pop();
				node=node.leftChild;
			}
		}
		while(stackChild.size()>0){
			node=stackChild.pop();
			System.out.println("nonpostOrder data:" + node.getData());
		}
		
	}

	public class TreeNode {
		private int index;
		private String data;
		private TreeNode leftChild;
		private TreeNode rightChild;

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public TreeNode(int index, String data) {
			this.index = index;
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		int height = binaryTree.getHeight();
		System.out.println("treeHeihgt:" + height);
		int size = binaryTree.getSize();
		// System.out.println("treeSize:"+size);
		// binaryTree.preOrder(binaryTree.root);
		// binaryTree.midOrder(binaryTree.root);
		// binaryTree.postOrder(binaryTree.root);
		// binaryTree.nonRecOrder(binaryTree.root);
		 binaryTree.nonpostOrder(binaryTree.root);
//		for (String s : TreeData) {
//			data.add(s);
//		}
//		binaryTree.PreCreateBinaryThree(0, data);
//		binaryTree.preOrder(binaryTree.root);
	}

}