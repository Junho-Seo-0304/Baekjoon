import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		Arrays.fill(dp[1], 1);
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=j;k>=0;k--) {
					dp[i][j]=(dp[i][j]+dp[i-1][k])%10007;
				}
			}
		}
		int ans = 0;
		for(int i=0;i<10;i++) {
			ans=(ans+dp[n][i])%10007;
		}
		System.out.println(ans);
	}
}
