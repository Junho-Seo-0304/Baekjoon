import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static ArrayList<Integer>[] r;
	static boolean[] used;
	static boolean isAble=false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		r = new ArrayList[n];
		for(int i=0;i<n;i++)
			r[i] = new ArrayList<>();
		used = new boolean[n];
		for(int i=0;i<m;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			r[a].add(b);
			r[b].add(a);
		}
		for(int i=0;i<n;i++) {
			used[i]=true;
			check(0,i);
			used[i]=false;
			if(isAble)
				break;
		}
		if(isAble) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
	static void check(int depth,int before) {
		if(depth==4) {
			isAble=true;
			return;
		}
		for(int i=0;i<r[before].size();i++) {
			int next = r[before].get(i);
			if(used[next])
				continue;
			used[next]=true;
			check(depth+1,next);
			used[next]=false;
		}
	}
}
