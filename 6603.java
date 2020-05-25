import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] s;
	static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0)
				break;
			s = new int[k];
			used = new boolean[k];
			for(int i=0;i<k;i++)
				s[i]=Integer.parseInt(st.nextToken());
			check(0,"",-1);
			System.out.println();
		}
	}
	static void check(int depth,String st,int before) {
		if(depth==6) {
			System.out.println(st);
			return;
		}
		for(int i=before+1;i<k;i++) {
			if(used[i])
				continue;
			used[i]=true;
			check(depth+1,st+s[i]+" ",i);
			used[i]=false;
		}
	}
}