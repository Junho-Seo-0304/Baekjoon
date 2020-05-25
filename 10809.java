import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		for(int i=0;i<s.length();i++) {
			if(alphabet[s.charAt(i)-97]==-1) {
				alphabet[s.charAt(i)-97]=i;
			}
		}
		for(int i=0;i<26;i++) {
			System.out.print(alphabet[i]+" ");
		}
	}
}
