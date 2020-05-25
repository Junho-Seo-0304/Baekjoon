import java.io.*;
import java.util.*;

public class Main {
	static int n,s;
	static int[] num;
	static boolean[] used;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		s = Integer.parseInt(st1.nextToken());
		num = new int[n];
		used = new boolean[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st2.nextToken());
		}
		check(0,-1);
		System.out.println(count);
	}
	static void check(int depth,int before) {
		if(depth>0) {
			int sum=0;
			for(int i=0;i<n;i++) {
				if(used[i])
					sum+=num[i];
			}
			if(s==sum)
				count++;
		}
		for(int i=before+1;i<n;i++) {
			if(used[i])
				continue;
			used[i]=true;
			check(depth+1,i);
			used[i]=false;
		}
	}
}
