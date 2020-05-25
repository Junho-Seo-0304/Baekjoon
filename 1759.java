import java.io.*;
import java.util.*;

public class Main {
	static int l,c;
	static char[] letter;
	static char[] vowel = {'a','e','i','o','u'};
	static int cntV = 0;
	static int cntC = 0;
	static boolean[] used;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st1.nextToken());
		c = Integer.parseInt(st1.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		letter = new char[c];
		used = new boolean[c];
		for(int i=0;i<c;i++)
			letter[i]=st2.nextToken().charAt(0);
		Arrays.parallelSort(letter);
		check(0,"",-1);
	}
	static void check(int depth,String s,int before) {
		if(depth==l) {
			if(cntV>=1&&cntC>=2)
				System.out.println(s);
			return;
		}
		for(int i=before+1;i<c;i++) {
			if(used[i])
				continue;
			used[i]=true;
			boolean isVowel = false;
			for(int j=0;j<vowel.length;j++) {
				if(letter[i]==vowel[j])
					isVowel=true;
			}
			if(isVowel) {
				cntV++;
			} else {
				cntC++;
			}
			check(depth+1,s+letter[i],i);
			used[i]=false;
			if(isVowel) {
				cntV--;
			} else {
				cntC--;
			}
		}
	}
}
