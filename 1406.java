import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		int commend_amount = Integer.parseInt(br.readLine());
		Stack<String> stack_L = new Stack<String>();
		Stack<String> stack_R = new Stack<String>();
		for(int i=0;i<sb.length();i++) {
			stack_L.push(sb.substring(i,i+1));
		}
		String c;
		for(int i=0;i<commend_amount;i++) {
			c=br.readLine();
			if(c.equals("L")) {
				if(!stack_L.empty()) {
					stack_R.push(stack_L.pop());
				}
			} else if(c.equals("D")) {
				if(!stack_R.empty()) {
					stack_L.push(stack_R.pop());
				}
			} else if(c.equals("B")) {
				if(!stack_L.empty()) {
					stack_L.pop();
				}
			} else if(c.contains("P")) {
				stack_L.push(c.substring(2,3));
			}
		}
		for(int i=0;i<stack_L.size();i++) {
			System.out.print(stack_L.get(i));
		}
		for(int i=stack_R.size()-1;i>=0;i--) {
			System.out.print(stack_R.get(i));
		}
	}
}
