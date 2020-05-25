import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int bsize = (int) Math.log10(b)+1;
		int dsize = (int) Math.log10(d)+1;
		long result1 = (long) (a*Math.pow(10, bsize)+b);
		long result2 = (long) (c*Math.pow(10, dsize)+d);
		System.out.println(result1+result2);
	}
}