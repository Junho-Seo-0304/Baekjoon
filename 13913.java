import java.io.*;
import java.util.*;

public class Main {
	static int n,k;
	static int[] road = new int[100101];
	static boolean[] visited = new boolean[100101];
	static int[] before = new int[100101];
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
		Stack stack = new Stack();
		stack.add(k);
		int temp = k;
		while(temp!=n) {
			stack.add(before[temp]);
			temp=before[temp];
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	static void bfs(Queue<Integer> q) {
		while(!q.isEmpty()) {
			int temp = q.poll();
			if(temp+1<100101&&!visited[temp+1]) {
				q.add(temp+1);
				visited[temp+1]=true;
				road[temp+1] = road[temp]+1;
				before[temp+1]=temp;
			}
			if(temp-1>=0&&!visited[temp-1]) {
				q.add(temp-1);
				visited[temp-1]=true;
				road[temp-1] = road[temp]+1;
				before[temp-1]=temp;
			}
			if(temp*2<100101&&!visited[temp*2]) {
				q.add(temp*2);
				visited[temp*2]=true;
				road[temp*2]=road[temp]+1;
				before[temp*2]=temp;
			}
		}
	}
}
