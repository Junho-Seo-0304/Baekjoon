import java.io.*;
import java.util.*;

public class Main {
	static int n,m,v;
	static boolean[][] r;
	static boolean[] used;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		v = Integer.parseInt(st1.nextToken());
		r = new boolean[n+1][n+1];
		used = new boolean[n+1];
		for(int i=0;i<m;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			r[a][b] = true;
			r[b][a] = true;
		}
		dfs();
		System.out.println();
		Arrays.fill(used, false);
		bfs();
	}
	static void dfs() {
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		used[v] = true;
		System.out.print(v+" ");
		boolean flag;
		while(!stack.empty()) {
			int vv = stack.peek();
			flag=false;
			for(int i=1;i<=n;i++) {
				if(r[vv][i]&&!used[i]) {
					stack.push(i);
					System.out.print(i+" ");
					used[i]=true;
					flag = true;
					break;
				}
			}
			if(!flag) {
				stack.pop();
			}
		}
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		used[v]=true;
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v+" ");
			for(int i=1;i<=n;i++) {
				if(r[v][i]&&!used[i]) {
					q.add(i);
					used[i]=true;
				}
			}
		}
	}
}
