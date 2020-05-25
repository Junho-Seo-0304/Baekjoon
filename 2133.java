import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n][3];
		int[][] dp = new int[n][3];
		int min = 1000*n+1;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			house[i][0]=Integer.parseInt(st.nextToken());
			house[i][1]=Integer.parseInt(st.nextToken());
			house[i][2]=Integer.parseInt(st.nextToken());
		}
		dp[0][0]=house[0][0];
		dp[0][1]=1000*n+1;
		dp[0][2]=1000*n+1;
		for(int i=1;i<n;i++) {
			dp[i][0]=Math.min(dp[i-1][1]+house[i][0], dp[i-1][2]+house[i][0]);
			dp[i][1]=Math.min(dp[i-1][0]+house[i][1], dp[i-1][2]+house[i][1]);
			dp[i][2]=Math.min(dp[i-1][0]+house[i][2], dp[i-1][1]+house[i][2]);
		}
		min = Math.min(dp[n-1][1],dp[n-1][2]);
		dp[0][0]=1000*n+1;
		dp[0][1]=house[0][1];
		dp[0][2]=1000*n+1;
		for(int i=1;i<n;i++) {
			dp[i][0]=Math.min(dp[i-1][1]+house[i][0], dp[i-1][2]+house[i][0]);
			dp[i][1]=Math.min(dp[i-1][0]+house[i][1], dp[i-1][2]+house[i][1]);
			dp[i][2]=Math.min(dp[i-1][0]+house[i][2], dp[i-1][1]+house[i][2]);
		}
		min = Math.min(min,dp[n-1][0]);
		min = Math.min(min,dp[n-1][2]);
		dp[0][0]=1000*n+1;
		dp[0][1]=1000*n+1;
		dp[0][2]=house[0][2];
		for(int i=1;i<n;i++) {
			dp[i][0]=Math.min(dp[i-1][1]+house[i][0], dp[i-1][2]+house[i][0]);
			dp[i][1]=Math.min(dp[i-1][0]+house[i][1], dp[i-1][2]+house[i][1]);
			dp[i][2]=Math.min(dp[i-1][0]+house[i][2], dp[i-1][1]+house[i][2]);
		}
		min = Math.min(min,dp[n-1][0]);
		min = Math.min(min,dp[n-1][1]);
		System.out.println(min);
	}
}
