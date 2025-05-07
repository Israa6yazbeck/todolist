package fin.priorityalprojec;
import java.util.*;
class Node{
	Node next;
	int priority;
	String task;
	public Node() {
		
	}
	public Node(int priority,String task) {
		this.next=null;
		this.priority=priority;
		this.task=task;
	}
}
class Nnode{
	Nnode next;
	int priority;
	String task;
	public Nnode() {
		
	}
	public Nnode(int priority,String task) {
		this.next=null;
		this.priority=priority;
		this.task=task;
	}
}
class Queueupcomingtasks{
	Node head;
	int numupcomingtasks;
	public Queueupcomingtasks() {
		
	}
	public void enque(int priority,String task) {
		Node n=new Node(priority,task);
		if(head==null) {
			head=n;
		}else {
			Node current=head;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=n;
		}
		numupcomingtasks++;
	}
	public Node deque() {
		Node deletedtask=head;
		head=head.next;
		return deletedtask;
	}
	public void display() {
		Node current=head;
		while(current!=null) {
			System.out.print(current.task);
			if(current.priority==1) {
				System.out.println("(High)");	
			}else if(current.priority==2) {
				System.out.println("(Medium)");	

			}
			else if(current.priority==3) {
				System.out.println("(Low)");	

			}
			current=current.next;
		}
	}
}
class LinkedList{
	Node head;
	Queueupcomingtasks q;
	public LinkedList(	Queueupcomingtasks f) {
	q=f;
	q.head=f.head;
	
	}
	public void insert(int priority, String task) {
	    Node t = new Node(priority, task);

	    if (head == null || priority < head.priority) {
	        t.next = head;
	        head = t;
	    } else {
	        Node current = head;
	        while (current.next != null && current.next.priority <= priority) {
	            current = current.next;
	        }
	        t.next = current.next;
	        current.next = t;
	    }
	}

	public void toactivate() {
		Node f=q.deque();
		 if (head == null || f.priority < head.priority) {
		        f.next = head;
		        head = f;
		    } else {
		        Node current = head;
		        while (current.next != null && current.next.priority <= f.priority) {
		            current = current.next;
		        }
		        f.next = current.next;
		        current.next = f;
		    }
		}
public Node remove(String f) {
	Node current=head;
	Node prev=current;
	Node temp = head;
	if(head.task.equals(f)) {
		temp=head;
		head=head.next;
		return temp;
	
	}else {
		while(current!=null ) {
			if(current.task.equals(f)) {
				temp=current;
				prev.next=current.next;
				return temp;
			}else {
			prev=current;
			current=current.next;}
		}
		
	}
	return temp;
}
public void dissplay() {
	Node current=head;
	while(current!=null) {
		System.out.print(current.task);
		if(current.priority==1) {
			System.out.println("(High)");	
		}else if(current.priority==2) {
			System.out.println("(Medium)");	

		}
		else if(current.priority==3) {
			System.out.println("(Low)");	

		}
		current=current.next;
	}
}
}
class Stack{
	Node top;
	LinkedList p;
	public Stack(LinkedList l) {
		p=l;
		p.head=l.head;
	}
	public void push(int priority,String task) {
		Node j=new Node(priority,task);
		if(top==null) {
			top=j;
		}else {
			Node current=top;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=j;
		}
	}
	public void tocomplete(String task) {
		Node current=top;
		Node x=p.remove(task);
		push(x.priority,x.task);
	}
	public void dissplay() {
		Node current=top;
		while(current!=null) {
			System.out.print(current.task);
			if(current.priority==1) {
				System.out.println("(High)");	
			}else if(current.priority==2) {
				System.out.println("(Medium)");	

			}
			else if(current.priority==3) {
				System.out.println("(Low)");	

			}
			current=current.next;
		}
	}
}
public class todolist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console=new Scanner(System.in);
		Queueupcomingtasks q=new Queueupcomingtasks();
		System.out.print("How many upcoming tasks: ");
		int f=console.nextInt();
		 console.nextLine();
		for(int i=0;i<f;i++) {
		System.out.print("Task " +(i+1)+": ");
		String h=console.nextLine();
		System.out.print("priority of " +"Task "+(i+1)+ ":");

		int g=console.nextInt();
		 console.nextLine();
		q.enque(g, h);
		}
		System.out.print("The upcoming tasks: ");
		q.display();
		
		LinkedList l=new LinkedList(q);
		System.out.print("How many activated tasks: ");
		int fa=console.nextInt();
		 console.nextLine();
		for(int p=0;p<fa;p++) {
		System.out.print("Task " +(p+1)+": ");
		String ha=console.nextLine();
		System.out.print("priority of " +"Task "+(p+1)+ ":");

		int ga=console.nextInt();
		 console.nextLine();
		l.insert(ga, ha);
		}
		System.out.print("The activated tasks: ");
		l.dissplay();
		System.out.print("How many task do you want to activate: ");
		int e=console.nextInt();
		for(int g=0;g<e;g++) {
		l.toactivate();}
		System.out.print("activated tasks: ");

		l.dissplay();
		Stack s=new Stack(l);
		System.out.print("How many completed tasks: ");
		int fp=console.nextInt();
		 console.nextLine();
		for(int p=0;p<fp;p++) {
		System.out.print("Task " +(p+1)+": ");
		String hq=console.nextLine();
		System.out.print("priority of " +"Task "+(p+1)+ ":");
		int a=console.nextInt();
		 console.nextLine();
		s.push(a, hq);
		}
		System.out.print("The completed tasks: ");
		s.dissplay();
		System.out.print("How many task do you complete: ");
		int sa=console.nextInt();
		 console.nextLine();
		for(int w=0;w<sa;w++) {
			System.out.print("What is the "+(w+1)+" task you have completed: ");
			String asd=console.nextLine();
			s.tocomplete(asd);
		}
		System.out.print("completed tasks: ");

		s.dissplay();
		

	}

}
