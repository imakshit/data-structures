package mar24;

import java.util.*;

//import mar16.linklistAddlast;

public class gtrees {

	private static class Node {
		public int data;
		public ArrayList<Node> children = new ArrayList<>();

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private static Node construct(ArrayList<Integer> dl) {
		Node root = null;
		ArrayList<Node> nlist = new ArrayList<>();
		for (int i = 0; i < dl.size(); i++) {
			if (dl.get(i) == -1) {
				nlist.remove(nlist.size() - 1);
			} else {
				Node nn = new Node(dl.get(i));
				if (nlist.size() == 0) {
					root = nn;
				} else {
					Node lastn = nlist.get(nlist.size() - 1);
					lastn.children.add(nn);
				}
				nlist.add(nn);
			}
		}

		return root;
	}

	public static void display(Node node) {

		String s = node.data + "->";
		for (int i = 0; i < node.children.size(); i++) {
			s += node.children.get(i).data + ",";
		}

		System.out.println(s + ".");
		for (int i = 0; i < node.children.size(); i++) {
			display(node.children.get(i));
		}

	}

	public static int size(Node root) {
		int cntr = 0;

		for (int i = 0; i < root.children.size(); i++) {
			cntr += size(root.children.get(i));
		}

		return cntr + 1;
	}

	public static int max(Node node) {
		int m = node.data;

		for (int i = 0; i < node.children.size(); i++) {
			int dta = max(node.children.get(i));

			if (m < dta) {
				m = dta;
			}
		}

		return m;
	}

	public static int height(Node node) {
		int h = 0;

		for (int i = 0; i < node.children.size(); i++) {
			int ch = height(node.children.get(i));
			h = Math.max(h, ch);
		}

		h = h + 1;

		return h;

	}

	public static boolean find(Node root, int dtf) {

		if (root.data == dtf) {
			return true;
		}

		for (int i = 0; i < root.children.size(); i++) {

			boolean res = find(root.children.get(i), dtf);
			if (res == true) {
				return true;
			}

		}

		return false;
	}

	public static ArrayList<Integer> n2rpath(Node root, int dtf) {

		if (root.data == dtf) {
			ArrayList<Integer> br = new ArrayList<Integer>();
			br.add(root.data);
			return br;
		}

		for (int i = 0; i < root.children.size(); i++) {
			ArrayList<Integer> cpath = n2rpath(root.children.get(i), dtf);
			if (cpath != null) {
				cpath.add(root.data);
				return cpath;
			}
		}

		return null;
	}

	public static int lca(Node root, int d1, int d2) {
		int lc = 0;
		ArrayList<Integer> d1l = n2rpath(root, d1);
		ArrayList<Integer> d2l = n2rpath(root, d2);
		// System.out.println(d1l +" "+d2l);

		for (int i = d1l.size() - 1, j = d2l.size() - 1; (i >= 0) && (j >= 0); i--, j--) {
			if (d1l.get(i) != d2l.get(j)) {
				lc = d1l.get(i + 1);
				break;
			}
		}

		return lc;
	}

	public static int distance(Node root, int d1, int d2) {
		int dist = 0;
		ArrayList<Integer> d1l = n2rpath(root, d1);
		ArrayList<Integer> d2l = n2rpath(root, d2);

		int d11 = d1l.size();
		int d22 = d2l.size();

		int cnt = 0;

		for (int i = d1l.size() - 1, j = d2l.size() - 1; (i >= 0) && (j >= 0); i--, j--) {
			if (d1l.get(i) == d2l.get(j)) {
				cnt++;
			}
		}

		dist = d11 + d22 - (2 * cnt) + 1;

		return dist;
	}

	// in-place reversing the child nodes of the tree
	public static void mirror(Node root) {

		for (int i = 0; i < root.children.size(); i++) {

			mirror(root.children.get(i));

		}

		int left = 0;
		int right = root.children.size() - 1;

		while (left < right) {

			Node ln = root.children.get(left);
			Node rn = root.children.get(right);

			root.children.set(left, rn);
			root.children.set(right, ln);
			left++;
			right--;
		}

	}

	public static void removeLeaf(Node root) {
		ArrayList<Node> rc = new ArrayList<Node>();

		for (int i = 0; i < root.children.size(); i++) {
			if (root.children.get(i).children.size() != 0) {
				rc.add(root.children.get(i));
			}
		}
		root.children = rc;

		for (int i = 0; i < root.children.size(); i++) {
			removeLeaf(root.children.get(i));
		}

	}

	public static Node linearize2(Node root) {
		if (root.children.size() == 0) {
			return root;
		}

		Node ol = root.children.get(root.children.size() - 1);
		Node olt = linearize2(ol);

		while (root.children.size() > 1) {
			Node sl = root.children.get(root.children.size() - 2);
			Node slt = linearize2(sl);

			Node last = root.children.get(root.children.size() - 1);
			root.children.remove(last);

			slt.children.add(last);
		}

		return olt;
	}

	public static boolean are_similar(Node root1, Node root2) {
		if (root1.children.size() != root2.children.size()) {
			return false;
		}

		int i = 0;
		for (i = 0; i < root1.children.size(); i++) {

			boolean r1 = are_similar(root1.children.get(i), root2.children.get(i));
			if (!r1) {
				return false;
			}
		}

		return true;
	}

	public static boolean are_mirror(Node root1, Node root2) {

		if (root1.children.size() != root2.children.size()) {
			return false;
		}
		for (int i = 0, j = root2.children.size() - 1; i < root1.children.size(); i++, j--) {

			boolean r = are_mirror(root1.children.get(i), root2.children.get(j));
			if (!r) {
				return false;
			}

		}
		return true;

	}

	public static boolean is_symmetric(Node root) {

		return are_mirror(root, root);
	}

	private static class heap_mover {
		int height = 0;
		int depth = 0;
		int size = 0;
		int mn = Integer.MAX_VALUE; // +infinity
		int mx = Integer.MIN_VALUE; // -infinity
		int ceil = Integer.MAX_VALUE;
		int floor = Integer.MIN_VALUE;
		int pre = Integer.MIN_VALUE;
		int suc = Integer.MAX_VALUE;
		int status = 0;
		int succ = 0;
		int pred = 0;

	}

	public static void ceil_floor(Node root, heap_mover obj, int depth, int number) {
		obj.size++;
		obj.height = depth > obj.height ? depth : obj.height;
		obj.mn = root.data < obj.mn ? root.data : obj.mn;
		obj.mx = root.data > obj.mx ? root.data : obj.mx;

		if (root.data > obj.floor && root.data < number) {
			obj.floor = root.data;
		}

		if (root.data < obj.ceil && root.data > number) {
			obj.ceil = root.data;
		}

		for (int i = 0; i < root.children.size(); i++) {

			ceil_floor(root.children.get(i), obj, depth + 1, number);
		}

	}

	public static void predecessor_successor(Node root, heap_mover obj, int depth, int number) {
		obj.size++;
		obj.height = depth > obj.height ? depth : obj.height;
		obj.mn = root.data < obj.mn ? root.data : obj.mn;
		obj.mx = root.data > obj.mx ? root.data : obj.mx;

		if (obj.status == 0) {
			if (root.data != number) {
				obj.pre = root.data;

			} else {
				obj.status = 1;
			}
		} else if (obj.status == 1) {
			obj.suc = root.data;
			obj.status++;
		}

		for (int i = 0; i < root.children.size(); i++) {
			predecessor_successor(root.children.get(i), obj, depth + 1, number);
		}
	}

	public static void pred_succ(Node root, int curr, int prev, int number, heap_mover obj) {

		prev = curr;
		curr = root.data;

		if (curr == number) {
			obj.pred = prev;
		}
		if (prev == number) {
			obj.succ = curr;
		}

		for (int i = 0; i < root.children.size(); i++) {
			pred_succ(root.children.get(i), curr, prev, number, obj);
		}
	}

	public static int Kthlargest(Node root, int k, heap_mover obj) {
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < k; i++) {
			obj = new heap_mover(); // refreshing the values again and again , initialising the value of floor to
									// -infinity again and again.
			ceil_floor(root, obj, 0, res);
			res = obj.floor;
		}

		return res;
	}

	public static void levelordertraversal(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.size() > 0) {
			Node fr = queue.getFirst();
			queue.removeFirst();// remove
			System.out.print(fr.data + " ");// print
			for (int i = 0; i < fr.children.size(); i++) {
				queue.addLast(fr.children.get(i)); // add
			}
		}
	}

	public static void levelordertraversal_linewise(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		queue.add(null);// nothing after element 10 , so we added null

		while (queue.size() > 0) {
			Node fr = queue.removeFirst(); // fr=10
			if (fr != null) {

				System.out.print(fr.data + " ");// print 10
				for (int i = 0; i < fr.children.size(); i++) {
					queue.addLast(fr.children.get(i)); // add children of 10

				}
			} else {
				System.out.println(" ");
				if (queue.size() > 0) {
					queue.add(null);
				}
			}

		}
	}

	public static void zigzag_traversal(Node root) {

		boolean ltr = true;
		LinkedList<Node> cq = new LinkedList<>();
		LinkedList<Node> ns = new LinkedList<>();

		cq.addLast(root);

		while (cq.size() > 0) {
			Node fr = cq.getFirst();
			cq.removeFirst();
			System.out.print(fr.data + " ");
			if (ltr) {
				for (int i = 0; i < fr.children.size(); i++) {
					ns.addFirst(fr.children.get(i));

				}

			} else {
				for (int i = fr.children.size(); i > 0; i--) {
					ns.addFirst(fr.children.get(i - 1));
				}

			}
			if (cq.size() == 0) {
				cq = ns;
				ns = new LinkedList<>();
				ltr = !ltr;
				System.out.println();

			}

		}

	}

	public static void depth_first_search_prepostorder(Node root) {
		// pre node
		System.out.print(root.data + " "); // pre-order

		for (int i = 0; i < root.children.size(); i++) {
			// pre edge
			depth_first_search_prepostorder(root.children.get(i));
			// post edge
		}
		// System.out.println();

		// post node

		// System.out.print(root.data+" "); post order

	}

	public static void depth_first_search(Node root) {

		LinkedList<Node> stack = new LinkedList<>();

	}

	public static void main(String args[]) {
		ArrayList<Integer> dlist = new ArrayList<Integer>();
		dlist.add(10);
		dlist.add(20);
		dlist.add(50);
		dlist.add(-1);
		dlist.add(60);
		dlist.add(-1);
		dlist.add(-1);
		dlist.add(30);
		dlist.add(70);
		dlist.add(-1);
		dlist.add(80);
		dlist.add(110);
		dlist.add(-1);
		dlist.add(120);
		dlist.add(-1);
		dlist.add(-1);
		dlist.add(90);
		dlist.add(-1);
		dlist.add(-1);
		dlist.add(40);
		dlist.add(100);
		dlist.add(-1);
		dlist.add(-1);
		dlist.add(-1);

		Node root = construct(dlist);
		display(root);
//		System.out.println(size(root));
//		System.out.println(max(root));
//		
//		System.out.println(height(root));
//		System.out.println(find(root,1000));
//		
//		ArrayList<Integer> r=new ArrayList<Integer>();
//		r=n2rpath(root,120);

//		for(int i=0;i<r.size();i++) {
//			System.out.print(r.get(i)+"->");
//		}

		// System.out.println(lca(root,100,70));
		// System.out.println(distance(root,100,120));

		// mirror(root);
		// display(root);

//		removeLeaf(root);
		// display(root);

		System.out.println("**********************************************");
		// linearize2(root);
		display(root);

		ArrayList<Integer> d1list = new ArrayList<Integer>();
		d1list.add(10);
		d1list.add(20);
		d1list.add(50);
		d1list.add(-1);
		d1list.add(60);
		d1list.add(-1);
		d1list.add(-1);
		d1list.add(30);
		d1list.add(70);
		d1list.add(-1);
		d1list.add(80);
		d1list.add(110);
		d1list.add(-1);
		d1list.add(120);
		d1list.add(-1);
		d1list.add(-1);
		d1list.add(90);
		d1list.add(-1);
		d1list.add(-1);
		d1list.add(40);
		d1list.add(100);
		d1list.add(-1);
		d1list.add(-1);
		d1list.add(-1);

		Node root1 = construct(d1list);

		ArrayList<Integer> d2list = new ArrayList<Integer>();
		d2list.add(1);
		d2list.add(2);
		d2list.add(5);
		d2list.add(-1);
		d2list.add(6);
		d2list.add(-1);
		d2list.add(-1);
		d2list.add(3);
		d2list.add(7);
		d2list.add(-1);
		d2list.add(8);
		d2list.add(11);
		d2list.add(-1);
		d2list.add(12);
		d2list.add(-1);
		d2list.add(-1);
		d2list.add(9);
		d2list.add(-1);
		d2list.add(-1);
		d2list.add(4);
		d2list.add(10);
		d2list.add(-1);
		d2list.add(-1);
		d2list.add(-1);

		Node root2 = construct(d2list);
//		display(root2);

		ArrayList<Integer> d3list = new ArrayList<Integer>();
		d3list.add(1);
		d3list.add(2);
		d3list.add(5);
		d3list.add(-1);
		d3list.add(6);
		d3list.add(-1);
		d3list.add(-1);
		d3list.add(3);
		d3list.add(7);
		d3list.add(-1);
		d3list.add(8);
		d3list.add(11);
		d3list.add(-1);
		d3list.add(12);
		d3list.add(-1);
		d3list.add(-1);
		d3list.add(9);
		d3list.add(-1);
		d3list.add(-1);
		d3list.add(4);
		d3list.add(10);
		d3list.add(-1);
		d3list.add(-1);
		d3list.add(-1);

		Node root3 = construct(d3list);

		System.out.println(are_similar(root1, root2));
		System.out.println(are_mirror(root1, root2));
		System.out.println(is_symmetric(root3));

		System.out.println();
		System.out.println("floor and ceil");
		heap_mover obj = new heap_mover();
		ceil_floor(root, obj, 0, 68);
		System.out.println(obj.floor + " " + obj.ceil);

		System.out.println("predecessor and successor");

		predecessor_successor(root, obj, 0, 70);
		System.out.println(obj.pre + " " + obj.suc);

		System.out.println("current previous method: ");
		pred_succ(root, 0, 0, 70, obj);
		System.out.println(obj.pred + " " + obj.succ);

		System.out.println();
		System.out.println("kth largest: ");
		System.out.println(Kthlargest(root, 3, obj));

		System.out.println("level order:");
		// display(root);
		levelordertraversal(root);
		System.out.println();
		System.out.println();

		System.out.println("level order traversal line wise: ");
		// display(root);
		levelordertraversal_linewise(root);
		System.out.println();

		System.out.println();
		System.out.println("zigzag traverel: ");
		zigzag_traversal(root);
		System.out.println();

		System.out.println("depth first search pre-order and post order : ");
		depth_first_search_prepostorder(root);
	}

}