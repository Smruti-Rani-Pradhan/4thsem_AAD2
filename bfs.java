import java.util.LinkedList;
import java.util.Queue;
public class bfs {
	int v;
	LinkedList<Integer> adj[];
	bfs(int n){
		v=n;
		adj=new LinkedList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new LinkedList();
		}
	}
		 void addedge(int u,int v) {
			adj[u].add(v);
			adj[v].add(u);
		}
		 void bfs_algo(int s) {
			 boolean visited []=new boolean[v];
			 Queue<Integer> Q=new LinkedList<>();
			 visited[s]=true;
			 Q.add(s);
			 while(!Q.isEmpty()) {
				 s=Q.remove();
				 System.out.print(s+" ");
				 for(int n:adj[s]) {
					 if(!visited[n]){
						 visited[n]=true;
						 Q.add(n);
					 }
				 }
			 }
		 }
	

	public static void main(String[] args) {
		bfs g=new bfs(8);
		g.addedge(1,2);
		g.addedge(1,3);
		g.addedge(2,3);
		g.addedge(2,4);
		g.addedge(2,5);
		g.addedge(3,5);
		g.addedge(3,6);
		g.addedge(3,7);
		g.addedge(4,5);
		g.addedge(6,7);
		System.out.println("BFS starting from vertex 1");
		g.bfs_algo(1);

	}

}
