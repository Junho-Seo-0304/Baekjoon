import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] ans = new int[t];
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] num = new int[2][n];
			StringTokenizer st0 = new StringTokenizer(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				num[0][j]=Integer.parseInt(st0.nextToken());
			}
			for(int j=0;j<n;j++) {
				num[1][j]=Integer.parseInt(st1.nextToken());
			}
			int[][] dp = new int[n][3];
			dp[0][0]=num[0][0];
			dp[0][1]=num[1][0];
			for(int j=1;j<n;j++) {
				dp[j][0]=Math.max(dp[j-1][1]+num[0][j], dp[j-1][2]+num[0][j]);
				dp[j][1]=Math.max(dp[j-1][0]+num[1][j], dp[j-1][2]+num[1][j]);
				dp[j][2]=Math.max(dp[j-1][0], dp[j-1][1]);
			}
			ans[i]=Math.max(dp[n-1][0], dp[n-1][1]);
			ans[i]=Math.max(ans[i], dp[n-1][2]);
		}
		for(int i=0;i<t;i++) {
			System.out.println(ans[i]);
		}
	}
}
