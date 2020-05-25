import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>=65&&s.charAt(i)<=90) {
				if(s.charAt(i)+13>90) {
					System.out.printf("%c",s.charAt(i)-13);
				} else {
					System.out.printf("%c",s.charAt(i)+13);
				}
			} else if(s.charAt(i)>=97&&s.charAt(i)<=122) {
				if(s.charAt(i)+13>122) {
					System.out.printf("%c",s.charAt(i)-13);
				} else {
					System.out.printf("%c",s.charAt(i)+13);
				}
			} else {
				System.out.printf("%c",s.charAt(i));
			}
		}
	}
}
