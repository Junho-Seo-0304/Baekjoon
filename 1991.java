import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		Node l,r;
		char c;
		Node (char c){
			this.c = c;
		}
	}
	static Node tree[];
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new Node[n];
		for(int i=0;i<n;i++) {
			tree[i] = new Node((char)('A'+i));
		}
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			if(left!='.') tree[root-'A'].l = tree[left-'A'];
			if(right!='.') tree[root-'A'].r = tree[right-'A'];
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}
	static void preorder(int idx) {
		System.out.print(tree[idx].c);
		if(tree[idx].l!=null) preorder(tree[idx].l.c-'A');
		if(tree[idx].r!=null) preorder(tree[idx].r.c-'A');
	}
	static void inorder(int idx) {
		if(tree[idx].l!=null) inorder(tree[idx].l.c-'A');
		System.out.print(tree[idx].c);
		if(tree[idx].r!=null) inorder(tree[idx].r.c-'A');
	}
	static void postorder(int idx) {
		if(tree[idx].l!=null) postorder(tree[idx].l.c-'A');
		if(tree[idx].r!=null) postorder(tree[idx].r.c-'A');
		System.out.print(tree[idx].c);
	}
}
