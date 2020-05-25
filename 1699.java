import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=100000;
			for(int j=1;j<=Math.sqrt(i);j++) {
				dp[i]=Math.min(dp[i], dp[i-(j*j)]+1);
			}
		}
		System.out.println(dp[n]);
	}
}
