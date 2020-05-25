import java.io.*;
import java.util.*;



public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String commend = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<commend.length();i++) {
			switch(commend.charAt(i)) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.empty()&&Priority(stack.peek())>=Priority(commend.charAt(i))) {
					System.out.print(stack.pop());
				}
				stack.push(commend.charAt(i));
				break;
			case '(':
				stack.push(commend.charAt(i));
				break;
			case ')':
				while(!stack.empty()&&stack.peek()!='(') {
					System.out.print(stack.pop());
				}
				stack.pop();
				break;
			default:
				System.out.print(commend.charAt(i));
			}
		}
		while(!stack.empty()) {
			System.out.print(stack.pop());
		}
	}
	
	public static int Priority(char x) {
		switch(x) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case ')':
			return 0;
		}
		return -1;
	}
}
