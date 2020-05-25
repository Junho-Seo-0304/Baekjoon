import java.io.*;
import java.util.*;
public class Main {
	static int n,m;
	static char[][] board;
	static boolean[][] visited;
	static int[] xc = {1,-1,0,0}, yc = {0,0,1,-1};
	static boolean isAble=false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				board[i][j]=s.charAt(j);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j])
					continue;
				visited[i][j] = true;
				check(i,j,i,j,0,board[i][j]);
				visited[i][j] = false;
			}
		}
		String ans = isAble?"Yes":"No";
		System.out.println(ans);
	}
	static void check(int sx,int sy,int x,int y,int depth,char color) {
		if(depth>=3) {
			for(int i=0;i<4;i++) {
				int nx = x+xc[i];
				int ny = y+yc[i];
				if(nx<0||nx>=n||ny<0||ny>=m)
					continue;
				if(color!=board[nx][ny])
					continue;
				if(nx==sx&&ny==sy) {
					isAble=true;
					return;
				}
			}
		}
		if(isAble)
			return;
		for(int i=0;i<4;i++) {
			int nx = x+xc[i];
			int ny = y+yc[i];
			if(nx<0||nx>=n||ny<0||ny>=m)
				continue;
			if(color!=board[nx][ny])
				continue;
			if(visited[nx][ny])
				continue;
			visited[nx][ny]=true;
			check(sx,sy,nx,ny,depth+1,color);
			visited[nx][ny]=false;
		}
	}
}
