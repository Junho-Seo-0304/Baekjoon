import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());
		int size_a = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		long decimal = 0;
		for(int i=0;i<size_a;i++) {
			int temp = Integer.parseInt(st2.nextToken());
			decimal += (long) (temp*Math.pow(a, size_a-i-1));
		}
		Stack<Integer> stack = new Stack();
		while(decimal!=0) {
			stack.push((int) (decimal%b));
			decimal/=b;
		}
		while(!stack.empty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
