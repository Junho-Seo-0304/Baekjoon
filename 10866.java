import java.io.*;

class Deque{
	private int[] deque;
	private int size;
	
	public Deque() {
		deque = new int[10000];
		this.size=0;
	}
	
	public void push_front(int x) {
		int[] new_deque = new int[10000];
		for(int i=0;i<size;i++) {
			new_deque[i+1]=deque[i];
		}
		new_deque[0]=x;
		deque=new_deque;
		size++;
	}
	
	public void push_back(int x) {
		deque[size]=x;
		size++;
	}
	
	public int pop_front() {
		if(size==0) {
			return -1;
		} else {
			int[] new_deque = new int[10000];
			int temp = deque[0];
			for(int i=1;i<size;i++) {
				new_deque[i-1]=deque[i];
			}
			deque=new_deque;
			size--;
			return temp;
		}
	}
	
	public int pop_back() {
		if(size==0) {
			return -1;
		} else {
			size--;
			return deque[size];
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public int empty() {
		if(size==0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int front() {
		if(size==0) {
			return -1;
		} else {
			return deque[0];
		}
	}
	
	public int back() {
		if(size!=0) {
			return deque[size-1];
		} else {
			return -1;
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque deque = new Deque();
		int commend_amount = Integer.parseInt(br.readLine());
		String commend;
		for(int i=0; i<commend_amount; i++) {
			commend = br.readLine();
			if(commend.contains("push_back")) {
				int x = Integer.parseInt(commend.substring(10));
				deque.push_back(x);
			} else if(commend.contains("push_front")) {
				int x = Integer.parseInt(commend.substring(11));
				deque.push_front(x);
			} else if(commend.equals("pop_front")) {
				sb.append(deque.pop_front()+"\n");
			} else if(commend.equals("pop_back")) {
				sb.append(deque.pop_back()+"\n");
			} else if(commend.equals("size")) {
				sb.append(deque.size()+"\n");
			} else if(commend.equals("empty")) {
				sb.append(deque.empty()+"\n");
			} else if(commend.equals("front")) {
				sb.append(deque.front()+"\n");
			} else if(commend.equals("back")) {
				sb.append(deque.back()+"\n");
			} else {
				System.out.println("You entered wrong a commend.");
			}
		}
		System.out.print(sb);
	}
}
