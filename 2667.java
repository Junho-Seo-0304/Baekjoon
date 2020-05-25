import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] h;
	static int n,a=0;
	static int[] xc = {-1,1,0,0}, yc = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		h = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				if(s.charAt(j)=='1')
					h[i][j]=true;
			}
		}
		int count=0;
		ArrayList<Integer> num = new ArrayList();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(h[i][j]) {
					check(i,j);
					num.add(a);
					count++;
					a=0;
				}
			}
		}
		System.out.println(count);
		Collections.sort(num);
		for(int i=0;i<num.size();i++) {
			System.out.println(num.get(i));
		}
	}
	public static void check(int x, int y) {
		h[x][y]=false;
		a++;
		for(int i=0;i<4;i++) {
			int nextX = x+xc[i];
			int nextY = y+yc[i];
			if(nextX>=0&&nextX<n&&nextY>=0&&nextY<n) {
				if(h[nextX][nextY])
					check(nextX,nextY);
			}
		}
	}
}
