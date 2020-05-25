import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] dp = new int[n];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
			dp[i]=a[i];
			for(int j=i;j>=0;j--) {
				if(a[i]>a[j]&&dp[i]<dp[j]+a[i]) {
					dp[i]=dp[j]+a[i];
				}
			}
			max=Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
