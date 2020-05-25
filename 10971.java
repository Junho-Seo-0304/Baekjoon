import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] w;
	static boolean[] used;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		used = new boolean[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
				w[i][j]=Integer.parseInt(st.nextToken());
		}
		min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			used[i]=true;
			check(0,i,0,i);
			used[i]=false;
		}
		System.out.println(min);
	}
	static void check(int depth,int first,int sum,int before) {
		if(depth==n-1) {
			sum+=w[before][first];
			min=Math.min(min, sum);
			return;
		}
		for(int i=0;i<n;i++) {
			if(used[i])
				continue;
			used[i]=true;
			check(depth+1,first,sum+w[before][i],i);
			used[i]=false;
		}
	}
}