import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int n;
	static int[] xc = {-2,-1,1,2,2,1,-1,-2}, yc = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visited = new boolean[n][n];
			Queue<int[]> q = new LinkedList();
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int[] start = { Integer.parseInt(st1.nextToken()),Integer.parseInt(st1.nextToken())};
			int[] finish = { Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken())};
			q.add(start);
			visited[start[0]][start[1]]=true;
			check(q);
			System.out.println(arr[finish[0]][finish[1]]);
		}
	}
	public static void check(Queue<int[]> q) {
	    while(!q.isEmpty()) {
	    	int[] now = q.poll();
	    	for(int i=0;i<8;i++) {
	    		int nX = now[0]+xc[i];
	    		int nY = now[1]+yc[i];
	    		if(nX<0||nX>=n||nY<0||nY>=n)
	    			continue;
	    		if(visited[nX][nY])
	    			continue;
	    		q.add(new int[] {nX,nY});
	    		arr[nX][nY]= arr[now[0]][now[1]]+1;
	    		visited[nX][nY]=true;
	    	}
	    }
	}
}
