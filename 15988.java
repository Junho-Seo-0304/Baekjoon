import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		long[] ans = new long[t];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4;i<1000001;i++) {
			dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
		}
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			ans[i]=dp[n];
		}
		for(int i=0;i<t;i++) {
			System.out.println(ans[i]);
		}
	}
}
