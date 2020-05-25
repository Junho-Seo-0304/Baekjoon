import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int w,h;
	static int[] xc = {-1,1,0,0}, yc = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st1.nextToken());
		w = Integer.parseInt(st1.nextToken());
		arr = new int[h][w];
		visited = new boolean[h][w];
		for(int i=0;i<h;i++) {
			String s =br.readLine();
			for(int j=0;j<w;j++) {
				if(s.charAt(j)=='1')
					arr[i][j]=1;
			}
		}
		visited[0][0]=true;
		arr[0][0]=1;
		check(0,0);
		System.out.println(arr[h-1][w-1]);
	}
	public static void check(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
	    q.add(new int[] {x,y});
	    while(!q.isEmpty()) {
	    	int[] now = q.poll();
	    	for(int i=0;i<4;i++) {
	    		int nX = now[0]+xc[i];
	    		int nY = now[1]+yc[i];
	    		if(nX<0||nX>=h||nY<0||nY>=w)
	    			continue;
	    		if(visited[nX][nY]||arr[nX][nY]==0)
	    			continue;
	    		q.add(new int[] {nX,nY});
	    		arr[nX][nY]= arr[now[0]][now[1]]+1;
	    		visited[nX][nY]=true;
	    	}
	    }
	}
}
