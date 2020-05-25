import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		Stack stack = new Stack();
		do {
			if(n%-2==0) {
				stack.push(0);
				n/=-2;
			} else {
				stack.push(1);
				n=(n-1)/-2;
			}
		}while(n!=0);
		while(!stack.empty()) {
			System.out.print(stack.pop());
		}
	}

}
