package com.br;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	private int result = 0;

	public int getResult() {
		return result;
	}

	public void visitNode(TreeNode node) {
	}

	public void visitLeaf(TreeLeaf leaf) {
		result += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {
	private long result = 1;

	public int getResult() {
		return (int) result;
	}

	private void visitTree(Tree tree) {
		if (tree.getColor() == Color.RED) {
			result *= tree.getValue();
			result %= 1000000007;
		}
	}

	public void visitNode(TreeNode node) {
		visitTree(node);
	}

	public void visitLeaf(TreeLeaf leaf) {
		visitTree(leaf);
	}
}

class FancyVisitor extends TreeVis {
	private int sumleaf = 0;
	private int sumEven = 0;

	public int getResult() {
		return (sumEven < sumleaf ? sumleaf - sumEven : sumEven - sumleaf);
	}

	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0)
			sumEven += node.getValue();
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.GREEN)
			sumleaf += leaf.getValue();
	}
}

class Edge {
	int f;
	int s;

	Edge(int f, int s) {
		this.f = f;
		this.s = s;
	}
}

public class JavaVisitorPattern {

	public static Tree solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] x = new int[n + 1];
		for (int i = 1; i <= n; i++)
			x[i] = scan.nextInt();

		int[] c = new int[n + 1];
		for (int i = 1; i <= n; i++)
			c[i] = scan.nextInt();

		Tree root = new TreeNode(x[1], (c[1] == 0 ? Color.RED : Color.GREEN), 0);

		Tree[] arr = new Tree[n + 1];

		arr[1] = root;

		boolean[] isNode = new boolean[n + 1];
		boolean[] isTree = new boolean[n + 1];
		isNode[1] = true;
		isTree[1] = true;

		Queue<Edge> qe = new LinkedList<>();
		Queue<Edge> q = new LinkedList<>();

		{
			int nn = n - 1;
			while (nn-- > 0) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				qe.add(new Edge(u, v));
				q.add(new Edge(u, v));
			}
		}

		scan.close();

		while (!qe.isEmpty()) {
			Queue<Edge> qt = new LinkedList<>();

			while (!qe.isEmpty()) {
				Edge e = qe.remove();
				if (isTree[e.f]) {
					isNode[e.f] = true;
					isTree[e.s] = true;
				} else if (isTree[e.s]) {
					isNode[e.s] = true;
					isTree[e.f] = true;
				} else
					qt.add(e);
			}
			qe = qt;
		}

		while (!q.isEmpty()) {
			Queue<Edge> qt = new LinkedList<>();

			while (!q.isEmpty()) {
				Edge e = q.remove();
				if (isNode[e.f] && arr[e.f] != null) {
					if (isNode[e.s])
						arr[e.s] = new TreeNode(x[e.s], (c[e.s] == 0 ? Color.RED : Color.GREEN),
								arr[e.f].getDepth() + 1);
					else
						arr[e.s] = new TreeLeaf(x[e.s], (c[e.s] == 0 ? Color.RED : Color.GREEN),
								arr[e.f].getDepth() + 1);

					((TreeNode) arr[e.f]).addChild(arr[e.s]);

				} else if (arr[e.s] != null) {
					if (isNode[e.f])
						arr[e.f] = new TreeNode(x[e.f], (c[e.f] == 0 ? Color.RED : Color.GREEN),
								arr[e.s].getDepth() + 1);
					else
						arr[e.f] = new TreeLeaf(x[e.f], (c[e.f] == 0 ? Color.RED : Color.GREEN),
								arr[e.s].getDepth() + 1);

					((TreeNode) arr[e.s]).addChild(arr[e.f]);
				} else
					qt.add(e);
			}

			q = qt;
		}

		return root;
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}