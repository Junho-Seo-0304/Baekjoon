import java.io.*;
import java.util.*;

public class Main {
	static int n,k;
	static int[] road = new int[200001];
	static boolean[] visited = new boolean[200001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited[n]=true;
		Queue<Integer> q = new LinkedList();
		q.add(n);
		road[n]=0;
		bfs(q);
		System.out.println(road[k]);
	}
	static void bfs(Queue<Integer> q) {
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp+1<200001&&!visited[temp+1]) {
				q.add(temp+1);
				visited[temp+1]=true;
				road[temp+1] = road[temp]+1;
			}
			if(temp-1>=0&&!visited[temp-1]) {
				q.add(temp-1);
				visited[temp-1]=true;
				road[temp-1] = road[temp]+1;
			}
			if(temp*2<200001&&!visited[temp*2]) {
				q.add(temp*2);
				visited[temp*2]=true;
				road[temp*2]=road[temp]+1;
			}
		}
	}
}
