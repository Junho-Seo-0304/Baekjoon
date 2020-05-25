import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n+1];
		for(int i=1;i<=n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n+2];
		int[] dp2 = new int[n+2];
		int max = num[1];
		for(int i=1;i<=n;i++) {
			dp[i]=num[i];
			dp[i]=Math.max(dp[i], dp[i-1]+num[i]);
			max=Math.max(max, dp[i]);
		}
		for(int i=n;i>=1;i--) {
			dp2[i]=num[i];
			dp2[i]=Math.max(dp2[i], dp2[i+1]+num[i]);
			max=Math.max(dp[i-1]+dp2[i+1], max);
		}
		System.out.println(max);
	}
}
