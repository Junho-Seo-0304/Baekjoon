import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Stack stack = new Stack();
		while(n!=0) {
			if(n%b>=10) {
				stack.push((char)((n%b)+55));
				n/=b;
			} else {
				stack.push((char)((n%b)+48));
				n/=b;
			}
		}
		while(!stack.empty()) {
			System.out.printf("%c", stack.pop());
		}
	}

}
