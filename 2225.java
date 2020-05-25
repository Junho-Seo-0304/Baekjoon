import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[][] dp = new long[n+1][k+1];
		for(int i=1;i<k+1;i++) {
			dp[1][i]=i;
		}
		for(int i=1;i<n+1;i++) {
			dp[i][1]=1;
		}
		for(int i=2;i<n+1;i++) {
			for(int j=2;j<k+1;j++) {
				dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;
			}
		}
		System.out.println(dp[n][k]);
	}
}
