import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int case_num = sc.nextInt();
		Stack stack = new Stack();
		for(int i=0;i<=case_num;i++) {
			String s = sc.nextLine();
			if(s.length()>1000) {
				System.out.println("The sentense is too long.");
			} else {
				for(int j=0;j<s.length();j++) {
					if(s.charAt(j)==' ') {
						while(!stack.empty()) {
							System.out.print(stack.pop());
						}
						System.out.print(' ');
					} else if(j==s.length()-1){
						stack.push(s.charAt(j));
						if(stack.size()>20) {
							System.out.println("The word is too long.");
							break;
						}
						while(!stack.empty()) {
							System.out.print(stack.pop());
						}
						System.out.println();
					} else {
						stack.push(s.charAt(j));
						if(stack.size()>20) {
							System.out.println("The word is too long.");
							break;
						}
					}
				}
			}
		}
	}
}