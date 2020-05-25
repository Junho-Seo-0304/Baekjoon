import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0;j<3;j++) {
			dp[0][j]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<n;i++) {
			int[] temp = new int[3];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				temp[j]=Integer.parseInt(st2.nextToken());
			}
			dp[i][0]=Math.min(dp[i-1][1]+temp[0], dp[i-1][2]+temp[0]);
			dp[i][1]=Math.min(dp[i-1][0]+temp[1], dp[i-1][2]+temp[1]);
			dp[i][2]=Math.min(dp[i-1][0]+temp[2], dp[i-1][1]+temp[2]);
		}
		int min = Math.min(dp[n-1][0], dp[n-1][1]);
		min = Math.min(min, dp[n-1][2]);
		System.out.println(min);
	}
}
