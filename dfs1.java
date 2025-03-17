import java.util.LinkedList;
	import java.util.Stack;
	public class dfs1 {
		int v;
		LinkedList<Integer> adj[];
		dfs1(int n){
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
			 void dfs_algo(int s) {
				 boolean visited []=new boolean[v];
				 Stack<Integer> st=new Stack<>();
				 visited[s]=true;
				 st.push(s);
				 while(!st.isEmpty()) {
					 s=st.pop();
					 System.out.print(s+" ");
					 for(int n:adj[s]) {
						 if(!visited[n]){
							 visited[n]=true;
							 st.add(n);
						 }
					 }
				 }
			 }
		

		public static void main(String[] args) {
			dfs g=new dfs(8);
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
			System.out.println("dfs starting from vertex 1");
			g.dfs_algo(1);

		}

	}

	


