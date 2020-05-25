import java.io.*;
import java.util.*;

public class Main {
	static int n,max=0;
	static int[] t,p;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new int[n];
		p = new int[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		check(0,0);
		System.out.println(max);
	}
	static void check(int sum,int index) {
		max=Math.max(max, sum);
		for(int i=index;i<n;i++) {
			if(i+t[i]<=n)
				check(sum+p[i],i+t[i]);
		}
	}
}
