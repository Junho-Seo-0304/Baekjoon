import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		String commend = br.readLine();
		double[] num = new double[26];
		Stack<Double> stack = new Stack<Double>();
		for(int i=0;i<target;i++) {
			num[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<commend.length();i++) {
			if(commend.charAt(i)>=65&&commend.charAt(i)<=90) {
				stack.push(num[commend.charAt(i)-65]);
			} else {
				double x = stack.pop();
				double y = stack.pop();
				if(commend.charAt(i)=='+') {
					stack.push(x+y);
				} else if(commend.charAt(i)=='-') {
					stack.push(y-x);
				} else if(commend.charAt(i)=='*') {
					stack.push(x*y);
				} else if(commend.charAt(i)=='/') {
					stack.push(y/x);
				} else if(commend.charAt(i)=='%') {
					stack.push(y%x);
				} else {
					System.out.println("The operation is wrong");
				}
			}
		}
		if(stack.size()==1) {
			System.out.printf("%.2f",stack.pop());
		} else {
			System.out.println("The operation is wrong");
		}
	}
}
