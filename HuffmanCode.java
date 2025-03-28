import java.util.PriorityQueue;
import java.util.Comparator;
class Node{
  int item;
  char c;
  Node left,right;
}
class ImplementComparator implements Comparator<Node>
{

	public int compare(Node x, Node y) {
		
		return x.item-y.item;
	}
	
}
public class HuffmanCode {
	public static void Codes(Node root,String s) {
		if(root.left==null&&root.right==null&&Character.isLetter(root.c)) {
			System.out.println(root.c+" :"+s);
			return;
		}
		Codes(root.left,s+"0");
		Codes(root.right,s+"1");
	}

	public static void main(String[] args) {
		int n=6;
		char [] ch= {'a','b','c','d','e','f'};
		int [] freq= {45,13,12,16,9,5};
		PriorityQueue<Node> q=new PriorityQueue<Node>(n,new ImplementComparator());
		for(int i=0;i<n;i++) {
			Node h=new Node();h.c=ch[i];
			h.item=freq[i];
			h.left=null;
			h.right=null;
			q.add(h);
		}
		Node root=null;
		while(q.size()>1) {
			Node x=q.peek();
			q.poll();
			Node y=q.peek();
			q.poll();
			Node z=new Node();
			z.item=x.item+y.item;
			z.c='-';
			z.left=x;
			z.right=y;
			root=z;
			q.add(z);
		}
		System.out.println("Char: Huffman Code");
		System.out.println("------------------");
		Codes(root," ");
		
		

	}

}
