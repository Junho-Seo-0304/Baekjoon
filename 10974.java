import java.io.*;

public class Main {
	static int n;
	static boolean[] used;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		used = new boolean[n+1];
		makeString(0,"");
	}
	
	static void makeString(int depth,String s) {
		if(depth==n) {
			System.out.println(s);
			return;
		}
		for(int i=1;i<=n;i++) {
			if(used[i])
				continue;
			used[i]=true;
			makeString(depth+1,s+i+" ");
			used[i]=false;
		}
	}
}