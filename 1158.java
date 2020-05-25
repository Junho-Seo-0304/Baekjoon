import java.util.*;

public class Main {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int count = 0;
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}
		while(!queue.isEmpty()) {
			for(int i=1;i<k;i++) {
				int temp = queue.poll();
				queue.offer(temp);
			}
			arr[count]=queue.poll();
			count++;
		}
		System.out.print('<');
		for(int i=0;i<n-1;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.print(arr[n-1]+">");
	}
}