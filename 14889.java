import java.io.*;
import java.util.*;

public class Main {
	static int n,min=Integer.MAX_VALUE;
	static int[][] s;
	static boolean[] team;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n][n];
		team = new boolean[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				s[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		check(0,-1);
		System.out.println(min);
	}
	static void check(int depth,int index) {
		if(depth==n/2) {
			int team1 = 0;
			int team2 = 0;
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					if(team[i]&&team[j])
						team1+=s[i][j]+s[j][i];
					if(!team[i]&&!team[j])
						team2+=s[i][j]+s[j][i];
				}
			}
			min=Math.min(min, Math.abs(team1-team2));
			return;
		}
		for(int i=index+1;i<n;i++) {
			team[i]=true;
			check(depth+1,i);
			team[i]=false;
		}
	}
}
