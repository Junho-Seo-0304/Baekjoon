import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static ArrayList<Integer>[] a;
	static int[] route;
	static boolean[] visited;
	static boolean isAble = true;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new ArrayList[n+1];
		route = new int[n];
		visited = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = new ArrayList();
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			a[temp1].add(temp2);
			a[temp2].add(temp1);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int temp = Integer.parseInt(st.nextToken());
			route[i]=temp;
		}
		int last=1;
		int checking=0;
		while(last<n) {
			int count=0;
			for(int i=last;i<a[route[checking]].size()+last;i++) {
				if(i>=n)
					break;
				if(a[route[checking]].contains(route[i])) {
					count++;
				}
			}
			last+=count;
			checking++;
			if(checking==last) {
				isAble=false;
				break;
			}
		}
		int ans = isAble?1:0;
		System.out.println(ans);
	}
}
