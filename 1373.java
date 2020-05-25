import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Integer> stack = new Stack();
		while(s.length()%3!=0) {
			s='0'+s;
		}
		for(int i=s.length()-1;i>=0;i-=3) {
			int temp=0;
			if(s.charAt(i)=='1') {
				temp+=1;
			}
			if(s.charAt(i-1)=='1') {
				temp+=2;
			}
			if(s.charAt(i-2)=='1') {
				temp+=4;
			}
			stack.push(temp);
		}
		while(!stack.empty()) {
			System.out.print(stack.pop());
		}
	}

}
