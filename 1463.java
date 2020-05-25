import java.io.*;
import java.util.*;

public class Main {
	public static int makeone(int n, int[] dp) {
		if(dp[n]!=-1) {
			return dp[n];
		}
		dp[n]=makeone(n-1,dp)+1;
		if(n%2==0) {
			dp[n]=Math.min(dp[n], makeone(n/2,dp)+1);
		}
		if(n%3==0) {
			dp[n]=Math.min(dp[n],makeone(n/3,dp)+1);
		}
		return dp[n];
	}
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		Arrays.fill(dp,-1);
		dp[0]=0;
		dp[1]=0;
		System.out.println(makeone(n,dp));
	}
}
