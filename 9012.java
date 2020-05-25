import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack();
		int time = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<time;i++) {
			stack.clear();
			String s = sc.nextLine();
			if(s.length()>=2&&s.length()<=50) {
			Boolean b = true;
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='(') {
					stack.push('(');
				} else if(s.charAt(j)==')'){
					if(stack.empty()) {
						System.out.println("NO");
						b = false;
						break;
					} else {
						stack.pop();
					}
				} else {
					System.out.println("You broke the rule.");
				}
			}
			if(b) {
				if(stack.empty()) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
			} else {
				System.out.println("The sentense has to be more than 2 words and less than 50 words.");
			}
		}
	}
}
