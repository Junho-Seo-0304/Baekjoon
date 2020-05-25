import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack stack = new Stack();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int total = 0;
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i)=='(') {
				if(s.charAt(i+1)==')') {
					total += stack.size();
				} else {
					stack.push('(');
				}
			} else if(s.charAt(i)==')') {
				if(s.charAt(i+1)==')') {
					stack.pop();
					total++;
				}
			} else {
				System.out.println("You entered a wrong sentense.");
				break;
			}
		}
		System.out.println(total);
	}
}