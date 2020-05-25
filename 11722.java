import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		int[] dp = new int[n+1];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
			dp[i]=1;
			for(int j=i;j>=0;j--) {
				if(a[i]<a[j]&&dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
			max=Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
