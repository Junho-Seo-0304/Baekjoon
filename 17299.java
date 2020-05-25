import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		int[] count = new int[1000001];
		int[] ngf = new int[n];
		Arrays.fill(count, 0);
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
			count[num[i]]++;
			ngf[i]=-1;
		}
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			while(!stack.empty()) {
				if(count[num[i]]>count[num[stack.peek()]]) {
					ngf[stack.pop()]=num[i];
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
			System.out.print(ngf[i]+" ");
		}
	}

}
