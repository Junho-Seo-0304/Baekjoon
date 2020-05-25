import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack stack = new Stack();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='<') {
				while(!stack.empty()) {
					System.out.print(stack.pop());
				}
				System.out.print('<');
				for(int j=i+1;i<s.length();j++) {
					if(s.charAt(j)=='>') {
						i=j;
						System.out.print('>');
						break;
					} else {
						System.out.print(s.charAt(j));
					}
				}
			} else if(s.charAt(i)==' ') {
				while(!stack.empty()) {
					System.out.print(stack.pop());
				}
				System.out.print(' ');
			} else {
				stack.push(s.charAt(i));
			}
		}
		if (!stack.empty()) {
			while(!stack.empty()) {
				System.out.print(stack.pop());
			}
		}
	}

}
