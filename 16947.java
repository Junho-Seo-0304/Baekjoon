import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int[] round;
	static ArrayList<Integer>[] a;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		round = new int[n+1];
		Arrays.fill(round, -1);
		a = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = new ArrayList();
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			a[temp1].add(temp2);
			a[temp2].add(temp1);
		}
		for(int i=1;i<=n;i++) {
			if(round[i]==0)
				continue;
			ArrayList<Integer> temp = new ArrayList();
			temp.add(i);
			CheckRound(i,temp,0);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			if(round[i]==0) {
				sb.append(round[i]+" ");
				continue;
			}
			round[i]=Integer.MAX_VALUE;
			boolean[] visited = new boolean[n+1];
			visited[i]=true;
			CheckDistance(i,0,i,visited);
			sb.append(round[i]+" ");
		}
		System.out.println(sb);
	}
	static void CheckRound(int before,ArrayList<Integer> route,int depth) {
		if(depth>=2) {
			for(int i=0;i<a[before].size();i++) {
				if(route.get(0)==a[before].get(i)) {
					for(int j=0;j<route.size();j++) {
						round[route.get(j)]=0;
					}
					return;
				}
			}
		}
		for(int i=0;i<a[before].size();i++) {
			if(route.contains(a[before].get(i)))
				continue;
			route.add(a[before].get(i));
			CheckRound(a[before].get(i),route,depth+1);
			route.remove(route.size()-1);
		}
	}
	static void CheckDistance(int before,int depth,int start,boolean[] visited) {
		if(round[before]==0) {
			round[start]=Math.min(round[start], depth);
			return;
		}
		for(int i=0;i<a[before].size();i++) {
			if(visited[a[before].get(i)])
				continue;
			visited[a[before].get(i)]=true;
			CheckDistance(a[before].get(i),depth+1,start,visited);
			visited[a[before].get(i)]=false;
		}
	}
}
