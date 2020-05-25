import java.io.*;
import java.util.*;

public class Main {
	static int[] num;
	static int[] dp;
	static int[] dp2;
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[n];
		dp = new int[n];
		dp2 = new int[n];
		int max = 1;
		int last = 0;
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
			dp[i]=1;
			dp2[i]=-1;
			for(int j=0;j<i;j++) {
				if(num[i]==num[j]) {
					dp[i]=dp[j];
				}
				if(num[i]>num[j]&&dp[j]>=dp[i]) {
					dp[i]=dp[j]+1;
					dp2[i]=j;
					if(dp[i]>max) {
						max=dp[i];
						last=i;
					}
				}
			}
		}
		System.out.println(max);
		System.out.println(go(last).trim());
	}
	public static String go(int p) {
		if(p==-1) {
			return "";
		} else {
			return go(dp2[p])+" "+num[p];
		}
	}
}
