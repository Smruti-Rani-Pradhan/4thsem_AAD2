import java.util.*;

class Graph1 {
    int V;
    List<Edge>[] adj;

    Graph1(int V) {
        this.V = V;
        adj = new LinkedList[V]; // Change to LinkedList
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>(); // Initialize with LinkedList
        }
    }

    void addEdge(int u, int v, int weight) {
        adj[u].add(new Edge(u, v, weight));
        adj[v].add(new Edge(v, u, weight));
    }

    class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public void primMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        
        boolean[] inMST = new boolean[V];

        inMST[0] = true;
        for (Edge edge : adj[0]) {
            pq.add(edge);
        }
        
        int mstWeight = 0;
        System.out.println("Edges in MST:");
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST[edge.v]) {
                continue;
            }
            System.out.println(edge.u + " - " + edge.v + " weight: " + edge.weight);
            mstWeight += edge.weight;
            inMST[edge.v] = true;
            for (Edge e : adj[edge.v]) {
                if (!inMST[e.v]) {
                    pq.add(e);
                }
            }
        }

        System.out.println("Total weight of MST: " + mstWeight);
    }
}





public class Prims1 {
    public static void main(String[] args) {
        Graph1 Graph1 = new Graph1(7);
        Graph1.addEdge(0, 1, 8);
        Graph1.addEdge(0, 2, 5);
        Graph1.addEdge(1, 2, 10);
        Graph1.addEdge(1, 3, 2);
        Graph1.addEdge(1, 4, 20);
        Graph1.addEdge(2, 3, 3);
        Graph1.addEdge(2, 5, 15);
        Graph1.addEdge(3, 4, 12);
        Graph1.addEdge(3, 5, 35);
        Graph1.addEdge(3, 6, 18);
        Graph1.addEdge(4, 6, 4);
        Graph1.addEdge(5, 6, 30);
        Graph1.primMST();
    }
}
