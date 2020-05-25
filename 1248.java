import java.io.*;

public class Main {
	static int n;
	static char[][] sign;
	static int[] num;
	static boolean done = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		sign = new char[n][n];
		num = new int[n];
		int cntS=0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				sign[i][j]=s.charAt(cntS++);
			}
		}
		dfs(0);
	}
	static void dfs(int idx) {
		if(done)
			return;
		if(idx==n) {
			for(int i=0;i<n;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			done=true;
			return;
		}
		for(int i=-10;i<=10;i++) {
			num[idx]=i;
			if(check(idx)) {
				dfs(idx+1);
			}
			num[idx]=0;
		}
	}
	static boolean check(int idx) {
		for(int i=0;i<=idx;i++) {
			int sum=0;
			for(int j=i;j<=idx;j++) {
				sum += num[j];
				char a='1';
				if(sum<0)
					a='-';
				if(sum==0)
					a='0';
				if(sum>0)
					a='+';
				if(a!=sign[i][j])
					return false;
			}
		}
		return true;
	}
}
