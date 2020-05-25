import java.io.*;

class Queue{
	private int[] queue;
	private int size;
	
	public Queue() {
		queue = new int[10000];
		this.size=0;
	}
	
	public void push(int x) {
		queue[size]=x;
		size++;
	}
	
	public int pop() {
		if(size==0) {
			return -1;
		} else {
			int[] new_queue = new int[10000];
			int temp = queue[0];
			for(int i=1;i<size;i++) {
				new_queue[i-1]=queue[i];
			}
			queue=new_queue;
			size--;
			return temp;
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
			return queue[0];
		}
	}
	
	public int back() {
		if(size!=0) {
			return queue[size-1];
		} else {
			return -1;
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue queue = new Queue();
		int commend_amount = Integer.parseInt(br.readLine());
		String commend;
		for(int i=0; i<commend_amount; i++) {
			commend = br.readLine();
			if(commend.contains("push")) {
				int x = Integer.parseInt(commend.substring(5));
				queue.push(x);
			} else if(commend.equals("pop")) {
				sb.append(queue.pop()+"\n");
			} else if(commend.equals("size")) {
				sb.append(queue.size()+"\n");
			} else if(commend.equals("empty")) {
				sb.append(queue.empty()+"\n");
			} else if(commend.equals("front")) {
				sb.append(queue.front()+"\n");
			} else if(commend.equals("back")) {
				sb.append(queue.back()+"\n");
			} else {
				System.out.println("You entered wrong a commend.");
			}
		}
		System.out.print(sb);
	}
}
