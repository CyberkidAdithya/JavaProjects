package Competitive;

import java.io.*;
import java.lang.*;
//import java.util.*;

class Node {
	int val;
	Node left = null;
	Node right = null;
	Node (int value) {
		val = value;
	}
}

class BinaryTree {
	Node root = null;
	public void inorderTraversal(Node root) {
		if (root == null) return;
		inorderTraversal(root.left);
		System.out.println(root.val);
		inorderTraversal(root.right);
	}
}

public class BinaryTreeMain {
	public static String solve() {
		System.out.println("\nGoodBye!");
		return "\n";
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		try {
			System.setIn(new FileInputStream("inputf.txt"));
			System.setOut(new PrintStream(new FileOutputStream("outputf.txt")));
		} catch (Exception e) {
			; // System.err.println("Error retrieving your I/O files");
		}

//		Scanner scan = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tcs = 1;
		// tcs = scan.nextInt();
		while (tcs-- > 0) {
			BinaryTree tree = new BinaryTree();
			tree.root = new Node(1);
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			tree.root.left.left = new Node(4);
			tree.root.left.right = new Node(5);
			tree.inorderTraversal(tree.root);
			System.out.println(solve());
		}
	}
}