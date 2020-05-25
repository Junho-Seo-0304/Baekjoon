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
		w = Integer.parseInt(st1.nextToken());
		h = Integer.parseInt(st1.nextToken());
		arr = new int[h][w];
		visited = new boolean[h][w];
		Queue<int[]> a = new LinkedList();
		boolean isFinished = true;
		for(int i=0;i<h;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				int temp = Integer.parseInt(st2.nextToken());
				if(temp==1) {
					a.add(new int[] {i,j});
					visited[i][j]=true;
				}
				if(temp==-1)
					arr[i][j]=-1;
				if(temp==0) {
					isFinished = false;
					arr[i][j]=-2;
				}
					
			}
		}
		if(isFinished) {
			System.out.println("0");
			return;
		}
		check(a);
		int max = 0;
		boolean isAble=true;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(arr[i][j]==-2) {
					isAble = false;
					break;
				}
				max = Math.max(max, arr[i][j]);
			}
			if(!isAble)
				break;
		}
		if(isAble) {
			System.out.println(max);
		} else {
			System.out.println("-1");
		}
	}
	public static void check(Queue<int[]> q) {
	    while(!q.isEmpty()) {
	    	int[] now = q.poll();
	    	for(int i=0;i<4;i++) {
	    		int nX = now[0]+xc[i];
	    		int nY = now[1]+yc[i];
	    		if(nX<0||nX>=h||nY<0||nY>=w)
	    			continue;
	    		if(visited[nX][nY]||arr[nX][nY]==-1)
	    			continue;
	    		q.add(new int[] {nX,nY});
	    		arr[nX][nY]= arr[now[0]][now[1]]+1;
	    		visited[nX][nY]=true;
	    	}
	    }
	}
}
