import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] ans = new int[T];
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ao = a;
			int bo = b;
			if(b>a) {
				int temp=a;
				a=b;
				b=temp;
			}
			while(b!=0) {
				int r = a%b;
				a=b;
				b=r;
			}
			ans[i]=ao*bo/a;
		}
		for(int i=0;i<T;i++) {
			System.out.println(ans[i]);
		}
	}

}
