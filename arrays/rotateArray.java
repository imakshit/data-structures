

public class rotateArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int r = 2;

		reverse(arr, 0, arr.length - 1);// full
		reverse(arr, 0, r - 1);// p1
		reverse(arr, r, arr.length - 1);// p2

		for (int val : arr) {
			System.out.print(val+" ");
		}

	}

	private static void reverse(int[] arr, int left, int right) {
		for (int low = left, high = right; low < high; low++, high--) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;

		}

	}
}
