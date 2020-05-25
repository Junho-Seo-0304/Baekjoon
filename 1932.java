import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] tri = new int[n][n];
		int[][] dp = new int[n][n];
		int max=0;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				tri[i][j]=Integer.parseInt(st.nextToken());
				if(i==0) {
					dp[0][0]=tri[0][0];
				} else if(j==0) {
					dp[i][j]=dp[i-1][0]+tri[i][0];
				} else if(j==i) {
					dp[i][j]=dp[i-1][j-1]+tri[i][j];
				} else {
					dp[i][j]=Math.max(dp[i-1][j-1]+tri[i][j], dp[i-1][j]+tri[i][j]);
				}
				max=Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
}
