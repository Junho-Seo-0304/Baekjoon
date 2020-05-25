import java.io.*;
import java.util.*;

class Spot implements Comparable<Spot>{
	int x;
	int y;
	int cost;
	
	public Spot(int x, int y, int cost) {
		this.x=x;
		this.y=y;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Spot o) {
		return this.cost < o.cost? -1:1;
	}
}

public class Main {
	static int n,m,ans;
	static int[][] a;
	static int[][] r;
	static PriorityQueue<Spot> pq;
	static int[] xc = {-1,1,0,0}, yc = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[m][n];
		r = new int[m][n];
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				r[i][j]=s.charAt(j)-'0';
				a[i][j]=Integer.MAX_VALUE;
			}
		}
		pq = new PriorityQueue();
		bfs();
		System.out.println(a[m-1][n-1]);
	}
	static void bfs() {
		pq.add(new Spot(0,0,0));
		a[0][0]=0;
		while(!pq.isEmpty()) {
			Spot temp = pq.poll();
			if(temp.x==m-1&&temp.y==n-1) {
				ans=temp.cost;
				return;
			}
			for(int i=0;i<4;i++) {
				int nx=temp.x+xc[i];
				int ny=temp.y+yc[i];
				if(nx>=0&&nx<m&&ny>=0&&ny<n) {
					if(a[nx][ny]>a[temp.x][temp.y]+r[nx][ny]) {
						a[nx][ny]=a[temp.x][temp.y]+r[nx][ny];
						pq.add(new Spot(nx,ny,a[nx][ny]));
					}
				}
			}
		}
	}
}
