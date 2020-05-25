import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			int uppercase = 0;
			int lowercase = 0;
			int number = 0;
			int space = 0;
			for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>=65&&s.charAt(i)<=90) {
				uppercase++;
			} else if(s.charAt(i)>=97&&s.charAt(i)<=122) {
				lowercase++;
			} else if(s.charAt(i)>=48&&s.charAt(i)<=57) {
				number++;
			} else if(s.charAt(i)==' ') {
					space++;
				}
			}
			System.out.println(lowercase+" "+uppercase+" "+number+" "+space);
		}
	}
}
