import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		int[] dp = new int[n];
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=num[0];
		int max = dp[0];
		for(int i=1;i<n;i++) {
			dp[i]=Math.max(num[i], dp[i-1]+num[i]);
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
