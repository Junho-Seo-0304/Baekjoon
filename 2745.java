import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		long ans = 0;
		for(int i=0;i<n.length();i++) {
			if(n.charAt(i)>=64&&n.charAt(i)<=90) {
				int temp = n.charAt(i)-55;
				ans += temp*Math.pow(b, n.length()-1-i);
			} else if(n.charAt(i)>=48&&n.charAt(i)<=57) {
				int temp = n.charAt(i)-48;
				ans += temp*Math.pow(b, n.length()-1-i);
			}
		}
		System.out.println(ans);
	}

}
