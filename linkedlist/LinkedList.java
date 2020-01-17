package mar16;

//import mar16.LinkedList.Node;

public class LinkedList {
	private class Node {
		public int data;
		public Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// constructor
	public LinkedList() {
		head = tail = null;
		size = 0;
		// this is by default in java
	}

	// add last function
	// this is made public so as to make it accessible from main
	public void addLast(int data) {
		if (size == 0) {
			handleAddWhenSize0(data);
			// because this is the first addition and hence is done in a
			// different way
		} else {
			// space allocation
			Node nn = new Node();

			// data and next;
			nn.data = data;
			nn.next = null;

			// connect
			tail.next = nn;

			// summary

			tail = nn;
			size++;

		}
	}

	// this is made private because it is not required to be called in main as
	// user is
	// going to add the elements so it is the responsibility of ll to do it on
	// its own
	private void handleAddWhenSize0(int data) {
		// space allocation
		Node nn = new Node();

		// data and next

		nn.data = data;
		nn.next = null;

		head = tail = nn;
		size = 1;

	}

	// to display the elements of linked list

	public void display() {
		Node temp = head;
		for (int i = 0; i < size; i++) {
			System.out.print(temp.data + " ");
			temp = temp.next;

		}
		System.out.println();
	}

	// get size
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		// if(size==0){
		// return true;
		// }
		// return false;
		return size == 0;
	}

	public void addFirst(int data) {
		if (size == 0) {
			handleAddWhenSize0(data);
		} else {
			// space allocation
			Node nn = new Node();

			// data and next;
			nn.data = data;
			nn.next = head;

			head = nn;
			// summary

			size++;
		}

	}

	public int getFirst() {
		if (size == 0) {
			return -1;
		} else {
			return head.data;
		}

	}

	public int getLast() {
		if (isEmpty()) {
			return -1;
		} else {
			return tail.data;
		}
	}

	private int handleRemovalWhenSize1() {
		int temp = head.data;
		// deleted via garbage collector

		head = tail = null;
		size = 0;
		return temp;
	}

	public int removeLast() {
		if (size == 1) {
			return handleRemovalWhenSize1();
		} else if (size == 0) {
			return -1;
		} else {
			int temp = tail.data;
			Node secondLast = getNodeAt(size - 2);
			secondLast.next = null;
			tail = secondLast;
			size--;
			return temp;
		}
	}

	public void addAt(int data, int index) {
		if (index < 0 || index > size) {
			System.out.println("invalid index");

		} else if (index == 0) {
			addFirst(data);
		} else if (index == size) {
			addLast(data);
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node np1 = nm1.next;

			Node nn = new Node();

			nn.data = data;
			nm1.next = nn;
			nn.next = np1;
			size++;

		}

	}

	public int removeFirst() {

		if (size == 0) {
			return -1;
		} else if (size == 1) {
			return handleRemovalWhenSize1();
		} else {
			// collect data
			int temp = head.data;
			// second head
			Node second = head.next;
			// release head
			// via garbage collector

			// summaries
			head = second;
			size--;

			// return
			return temp;

		}
	}

	private Node getNodeAt(int index) {
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int getAt(int index) {
		if (index < 0 || index >= size) {
			System.out.println("invalid index");
			return -1;
		} else {
			Node temp = getNodeAt(index);
			return temp.data;
		}
	}

	public int removeAt(int index) {
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(index - 1);
			Node n = nm1.next;
			Node np1 = n.next;
			int temp = n.data; // data is stored that was required to be remove
			nm1.next = np1;
			size--;
			return temp;
		}
	}

	public void rdi() {
		if (size == 0) {
			System.out.println("Size of ll is 0");
		} else {
			int l = 0;
			int r = size - 1;
			while (l < r) {
				Node fn = getNodeAt(l);
				Node ln = getNodeAt(r);

				int temp = fn.data;
				fn.data = ln.data;
				ln.data = temp;
				l++;
				r--;

			}

		}
	}

	public void rpi() {
		// for(int i =size-1;i>=0;i--){
		// Node ln = getNodeAt(i);
		// Node sn = getNodeAt(i-1);
		// ln.next = sn;
		// if(i==0){
		// head.next = null;
		// Node temp = head;
		// head = tail;
		// tail = temp;
		// }
		// for n^2

		// }
		Node prev = null;
		Node current = head;
		Node temp = head.next;
		while (current != null) {

			current.next = prev;
			prev = current;
			current = temp;
			if (temp != null) {
				temp = temp.next;
			}
		}
		Node htemp = head;
		head = tail;
		tail = htemp;

	}

	private void displayReverse(Node node) {
		if (node == null) {
			return;
		}
		Node fn = node;
		Node sn = fn.next;

		displayReverse(sn);
		System.out.print(fn.data + " ");
	}

	public void displayReverse() {
		displayReverse(head);
	}

	private void rpr(Node node) {
		if (node == tail) {
			return;
		}
		rpr(node.next);
		node.next.next = node;

	}

	public void rpr() {
		rpr(head);
		Node htemp = head;
		head = tail;
		tail = htemp;
		tail.next = null;
	}

	Node rdrLeft;

	private void rdr(Node right, int floor) {
		if (right == null) {
			return;
		}
		rdr(right.next, floor + 1);
		if (floor >= (size / 2)) {
			int temp = rdrLeft.data;
			rdrLeft.data = right.data;
			right.data = temp;
		}
		rdrLeft = rdrLeft.next;

	}

	public void rdr() {
		rdrLeft = head;
		rdr(head, 0);

	}

	Node ipLeft;

	private boolean isPalindrome(Node right) {

		if (right == null) {
			return true;
		}

		boolean rr = isPalindrome(right.next);
		boolean mr = rr == true && ipLeft.data == right.data;
		// isPalindrome(right.next);
		// if(ipLeft.data == right.data){
		// return true;
		// }
		ipLeft = ipLeft.next;
		return mr;
	}

	public boolean isPalindrome() {
		ipLeft = head;

		return isPalindrome(head);
	}

	Node foldLeft;

	private void fold(Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(right.next, floor + 1);
		if (floor > size / 2) {
//			Node temp = foldLeft.next;
//			foldLeft.next  = right;
//			foldLeft = temp;
//			right.next =  foldLeft;

			Node rl = foldLeft;
			right.next = rl.next;
			rl.next = right;
			foldLeft = rl.next.next;

		} else if (floor == size / 2) {
			tail = right;
			tail.next = null;
		}

	}

	public void fold() {
		foldLeft = head;
		fold(head, 0);
	}

	private void unfold(Node left) {
		if (left.next == null) {
			head = tail = left;
			return;
		} else if (left.next.next == null) {
			head = left;
			tail = left.next;
			return;
		}
		Node right = left.next; // next node is stored in a temporary variable
		unfold(left.next.next); // next to next elemet is called
		left.next = head; // add first
		tail.next = right;// add last
		head = left; // first vale ko head bna diya
		tail = right; // last vale ko tail bna diya
		tail.next = null;// tail k next ko null set kar diya

	}

	private void addFirstNode(Node nn) {
		if (size == 0) {
			head = tail = nn;
			size = 1;

		} else {
			nn.next = head;
			head = nn;
			size++;
		}
	}

	private Node removeFirstNode() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node temp = head;
			head = tail = null;
			size = 0;
			return temp;

		} else {
			Node oh = head;
			head = head.next;
			size--;
			oh.next = null; // so that it becomes completely isolated.
			return oh;
		}
	}

	public void kreverse(int k) {
		LinkedList prev = null;
		while (this.size != 0) {
			LinkedList current = new LinkedList();
			for (int i = 0; i < k && this.size > 0; i++) {
				current.addFirstNode(this.removeFirstNode());
			}
			if (prev == null) {
				prev = current;
			} else {
				prev.tail.next = current.head;
				prev.tail = current.tail;
				prev.size += current.size;

			}

		}
		this.size = prev.size;
		this.head = prev.head;
		this.tail = prev.tail;

	}

	private void addLastNode(Node nn) {
		if (size == 0) {
			head = tail = nn;
			size = 1;
		} else {
			tail.next = nn;
			tail = nn;
			size++;
		}
	}

	public void removeDuplicate() {
		LinkedList n1 = new LinkedList();
		while (this.size > 0) {
			Node temp = this.removeFirstNode();
			if (n1.size == 0 || n1.tail.data != temp.data) {
				n1.addLastNode(temp);
			}

		}
		this.head = n1.head;
		this.tail = n1.tail;
		this.size = n1.size;
	}

//	public void oddEven(){
//		LinkedList prev = null;
//		while(this.size!=0){
//			LinkedList current = new LinkedList();
//			for(int i =0;i<;i++)
//			{
//				
//			}
//			
//		
//			
//		}
//	}
	public void unfold() {
		unfold(head);
	}

	public void oddEven() {
		LinkedList nodd = new LinkedList();
		LinkedList even = new LinkedList();
		while (this.size > 0) {
			int temp = this.removeFirst();
			if (temp % 2 == 0) {
				even.addLast(temp);

			} else {
				nodd.addLast(temp);
			}

		}

		if (nodd.size == 0) {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;

		} else if (even.size == 0) {
			this.head = nodd.head;
			this.tail = nodd.tail;
			this.size = nodd.size;

		}

		else {
			this.head = nodd.head;
			nodd.tail.next = even.head;
			this.tail = even.tail;
			this.size = nodd.size + even.size;

		}
		clear(nodd);
		clear(even);

	}

	private void clear(LinkedList nl) {
		nl.size = 0;
		nl.head = null;
		nl.tail = null;
	}

	private Node midNode(Node sp, Node ep) {
		Node slow = sp;
		Node fast = sp;
		while (fast != ep && fast.next != ep) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public int midElement() {
		Node temp = midNode(head, tail);
		return temp.data;
	}

	public int kthfromlast(int k) {
		Node slow = head;
		Node fast = head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;

		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;

	}

	public void mergesortTwoLists(LinkedList ll1, LinkedList ll2) {
		Node s1 = ll1.head;
		Node s2 = ll2.head;
		while (s1 != null && s2 != null) {
			if (s1.data <= s2.data) {
				this.addLast(s1.data);
				s1 = s1.next;

			} else {

				this.addLast(s2.data);
				s2 = s2.next;

			}

		}

		while (s2 != null) {
			this.addLast(s2.data);
			s2 = s2.next;
		}

		while (s1 != null) {
			this.addLast(s1.data);
			s1 = s1.next;
		}
	}

	private LinkedList mergesort(Node sp, Node ep) {
		if (sp == ep) {
			LinkedList ll = new LinkedList();
			ll.addLast(sp.data); // one we will , other you will
			return ll;
		}
		Node mid = midNode(sp, ep);
		LinkedList ll1 = mergesort(sp, mid);
		LinkedList ll2 = mergesort(mid.next, ep);

		LinkedList result = new LinkedList();
		result.mergesortTwoLists(ll1, ll2);

		return result;

	}

	public LinkedList mergesort() {
		LinkedList ll5 = mergesort(head, tail);
		return ll5;
	}
	
	
//	public void addLists(LinkedList ll1 , LinkedList ll2) {
//		Node n1 = ll1.head;
//		Node n2 = ll2.head;
//		
//	}

	public static void main(String[] args) {

		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		//
		// l1.addLast(10);
		// l1.addLast(20);
		// l1.addLast(30);
		// l1.addLast(40);
		// l1.addLast(50);
		// l1.addLast(60);
		// l1.addLast(70);

		// l1.display();
		// System.out.println();
		// System.out.println(l1.getSize());
		// System.out.println();
		// System.out.println(l1.isEmpty());
		// System.out.println("\nAdd First \n");
		// l1.addFirst(100);
		// l1.display();
		// System.out.println("\nFirst Element\n");
		// System.out.println(l1.getFirst());
		// System.out.println("\nLast Element \n");
		// System.out.println(l1.getLast());
		// System.out.println("remove first");
		// System.out.println(l1.removeFirst());
		// System.out.println(l1.getAt(2));
		// System.out.println(l1.removeAt(3));
		// System.out.println();
		// System.out.println(l1.removeLast());
		// l1.display();

		l1.addLast(10);
		l1.addLast(20);
		l1.addLast(30);
		System.out.println("add last:");
		l1.display(); // 10 20 30
		l1.addFirst(40);
		l1.addFirst(50);
		System.out.println("add first:");
		l1.display(); // 50 40 10 20 30
		l1.addAt(100, 3);
		System.out.println("add at 3:");
		l1.display(); // 50 40 10 100 20 30
		l1.removeFirst();
		l1.removeFirst();
		System.out.println("2x remove first:");
		l1.display(); // 10 100 20 30
		l1.removeLast();
		System.out.println("remove last:");
		l1.display();
		l1.addLast(200);
		System.out.println("add last:");
		l1.display();
		l1.removeAt(2);// 10 100 20 200
		System.out.println("remove at 2:");
		l1.display(); // 10 100 200

		// l1.rdi();
		// l1.display();
		l1.addLast(40);
		// l1.addLast(20);
		// l1.addLast(30);
		//
		// l1.rpi();
		// l1.display();
		// l1.addLast(10);
		// l1.addLast(20);
		// l1.addLast(30);
		// l1.display();

		// l1.displayReverse();

		l1.rpr();
		System.out.println("rpr: ");
		l1.display();

		l1.rdr();
		System.out.println("rdr: ");
		l1.display();
		System.out.println("palindrome:");
		System.out.println(l1.isPalindrome());
		// System.out.println("fold");
		l2.addLast(2);
		l2.addLast(2);
		l2.addLast(3);
		l2.addLast(3);
		l2.addLast(4);
		l2.addLast(4);
//		System.out.println(l2.isPalindrome());
		System.out.println();
		l2.display();
//	l2.fold();
//	l2.display();
//	l2.addLast(1000);
//	l2.display();
//	l2.fold();
//	l2.display();
//	l2.addLast(2000);
//	l2.display();
//	l2.fold();
//	l2.display();
//	l2.unfold();
//	l2.display();
//	l2.addLast(3000);
//	l2.display();

//	l2.kreverse(3);
		// l2.display();
		System.out.println("remove duplicate: ");
		l2.removeDuplicate();
		l2.display();
		l2.addLast(50);
		l2.addLast(30);
		l2.addLast(71);
		l2.addLast(40);
		System.out.println("list: ");
		l2.display();
		System.out.println("odd even: ");
		l2.oddEven();
		l2.display();
		System.out.println("mid element :");
		System.out.println(l2.midElement());
		System.out.println("3rd from last");
		System.out.println(l2.kthfromlast(3));
		System.out.println();

		ll1.addLast(10);
		ll1.addLast(20);
		ll1.addLast(30);
		ll1.addLast(40);
		ll1.addLast(50);

		ll2.addLast(11);
		ll2.addLast(22);
		ll2.addLast(33);
		ll2.addLast(44);

		LinkedList ll3 = new LinkedList();
		System.out.println("linklist ll1: ");
		ll1.display();
		System.out.println("linklist ll2: ");
		ll2.display();
		System.out.println("merged lists: ");
		ll3.mergesortTwoLists(ll1, ll2);
		ll3.display();
		System.out.println();

		System.out.println("ll3:");
		ll3.fold();
		ll3.display();
		System.out.println("merge sort:");
		LinkedList ll7 = ll3.mergesort();
		ll7.display();

	}

}