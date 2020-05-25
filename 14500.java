import java.io.*;
import java.util.*;
 
public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] used;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int max;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st1 = new StringTokenizer(br.readLine());
    	n=Integer.parseInt(st1.nextToken());
    	m=Integer.parseInt(st1.nextToken());
    	arr = new int[n][m];
    	used = new boolean[n][m];
    	for(int i=0;i<n;i++) {
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		for(int j=0;j<m;j++) {
    			arr[i][j]=Integer.parseInt(st2.nextToken());
    		}
    	}
    	max = 0;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			check(i,j,0,0);
    			check2(i,j);
    		}
    	}
    	System.out.println(max);
    }
    static void check(int x,int y,int depth, int sum) {
    	if(depth==4) {
    		max=Math.max(max, sum);
    		return;
    	}
    	for(int i=0;i<4;i++) {
    		int nX=x+dx[i];
    		int nY=y+dy[i];
    		if(nX<0||nX>=n||nY<0||nY>=m)
    			continue;
    		if(used[nX][nY])
    			continue;
    		used[nX][nY]=true;
    		check(nX,nY,depth+1,sum+arr[nX][nY]);
    		used[nX][nY]=false;
    	}
    }
    static void check2(int x, int y) {
    	int wing = 4;
    	int sum = arr[x][y];
    	int min = Integer.MAX_VALUE;
    	for(int i=0;i<4;i++) {
    		int nX=x+dx[i];
    		int nY=y+dy[i];
    		if(wing<=2)
    			return;
    		if(nX<0||nX>=n||nY<0||nY>=m) {
    			wing--;
    			continue;
    		}
    		sum+=arr[nX][nY];
    		min=Math.min(min, arr[nX][nY]);
    	}
    	if(wing==4) {
    		sum-=min;
    	}
    	max=Math.max(max, sum);
    }
}