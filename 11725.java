import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static ArrayList<Integer>[] a;
	static int[] parent;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	a = new ArrayList[n+1];
    	parent = new int[n+1];
    	visited = new boolean[n+1];
    	for(int i=1;i<=n;i++) {
    		a[i] = new ArrayList();
    	}
    	for(int i=0;i<n-1;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int temp1 = Integer.parseInt(st.nextToken());
    		int temp2 = Integer.parseInt(st.nextToken());
    		a[temp1].add(temp2);
    		a[temp2].add(temp1);
    	}
    	visited[1]=true;
    	check(1);
    	for(int i=2;i<=n;i++) {
    		System.out.println(parent[i]);
    	}
    }
    static void check(int idx) {
    	for(int i=0;i<a[idx].size();i++) {
    		int temp = a[idx].get(i);
    		if(visited[temp])
    			continue;
    		visited[temp]=true;
    		parent[temp]=idx;
    		check(temp);
    	}
    }
}