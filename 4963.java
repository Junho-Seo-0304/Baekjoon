import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] arr;
	static int w,h;
	static int[] xc = {-1,1,0,0,-1,-1,1,1}, yc = {0,0,1,-1,-1,1,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st1.nextToken());
			h = Integer.parseInt(st1.nextToken());
			if(w==0&&h==0)
				break;
			arr = new boolean[h][w];
			for(int i=0;i<h;i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					char c = st2.nextToken().charAt(0);
					if(c=='1')
						arr[i][j]=true;
				}
			}
			int count=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(arr[i][j]) {
						check(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	public static void check(int x, int y) {
		arr[x][y]=false;
		for(int i=0;i<8;i++) {
			int nextX = x+xc[i];
			int nextY = y+yc[i];
			if(nextX>=0&&nextX<h&&nextY>=0&&nextY<w) {
				if(arr[nextX][nextY])
					check(nextX,nextY);
			}
		}
	}
}
