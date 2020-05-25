import java.io.*;
import java.util.*;

public class Main {
	static boolean[] num = new boolean[21];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String commend = st.nextToken();
			if(commend.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				num[x]=true;
			}
			if(commend.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				num[x]=false;
			}
			if(commend.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if(num[x]) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
			}
			if(commend.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if(num[x]) {
					num[x]=false;
				} else {
					num[x]=true;
				}
			}
			if(commend.equals("all")) {
				Arrays.fill(num, true);
			}
			if(commend.equals("empty")) {
				Arrays.fill(num, false);
			}
		}
		System.out.println(sb);
	}
}
