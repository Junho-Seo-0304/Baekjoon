import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n];
		int[][] dp = new int[n][2];
		for(int i=0;i<n;i++) {
			wine[i]=Integer.parseInt(br.readLine());
		}
		if(n==1) {
			dp[0][1]=wine[0];
		}else {
		dp[0][1]=wine[0];
		dp[1][0]=wine[0];
		dp[1][1]=dp[0][1]+wine[1];
		for(int i=2;i<n;i++) {
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1]=Math.max(dp[i-2][0]+wine[i-1]+wine[i], dp[i-1][0]+wine[i]);
		}
		}
		int ans = Math.max(dp[n-1][0], dp[n-1][1]);
		System.out.println(ans);
	}
}
