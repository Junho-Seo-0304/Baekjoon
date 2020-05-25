import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nge = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			nge[i]=-1;
		}
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			while(!stack.empty()) {
				if(arr[i]>arr[stack.peek()]) {
					nge[stack.pop()]=arr[i];
				} else {
					stack.push(i);
					break;
				}
			}
			if(stack.empty()) {
				stack.push(i);
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(nge[i]+" ");
		}
	}
}
