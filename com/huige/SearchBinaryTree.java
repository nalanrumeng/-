package com.huige;

import java.util.Stack;

import com.huige.BinaryTree.TreeNode;

public class SearchBinaryTree {
	public static TreeNode root;

	public SearchBinaryTree() {

	}

	class TreeNode {
		public int data;
		public TreeNode LeftChild;
		public TreeNode RightChild;
		public TreeNode parent;

		public TreeNode(int data) {
			this.data = data;
			this.LeftChild = null;
			this.RightChild = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TreeNode getLeftChild() {
			return LeftChild;
		}

		public void setLeftChild(TreeNode leftChild) {
			LeftChild = leftChild;
		}

		public TreeNode getRightChild() {
			return RightChild;
		}

		public void setRightChild(TreeNode rightChild) {
			RightChild = rightChild;
		}

		public TreeNode getParent() {
			return parent;
		}

		public void setParent(TreeNode parent) {
			this.parent = parent;
		}

	}

	/**
	 * 中序遍历——非迭代
	 */
	public void nonMidOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();

		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.LeftChild;

			} else {
				node = stack.pop();
				System.out.println("midOrder data:" + node.getData());
				node = node.RightChild;
			}
		}
	}

	public TreeNode put(int data) {
		if (root == null) {
			root = new TreeNode(data);
			return root;
		} else {
			TreeNode node = root;
			TreeNode parent=null;
			TreeNode newNode = new TreeNode(data);
			while (node != null) {
				if (data < node.data) {
					parent=node;
					node = node.LeftChild;
				} else if (data > node.data) {
					parent=node;
					node = node.RightChild;
				}
			}
			if (parent.data > data) {
				 parent.LeftChild=newNode;
			} else if (parent.data < data) {
				 parent.RightChild=newNode;
			}
			return newNode;
		}

	}
	public static void main(String[] args) {
		int[] intArray = { 98,78,763,22,21,112}; 
		SearchBinaryTree tree=new SearchBinaryTree();
		for(int i:intArray){
			tree.put(i);
		}
		tree.nonMidOrder(root);
	}
}
