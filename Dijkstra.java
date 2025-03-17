
import java.util.*;
//import ad.Dijkstra.Edge;
//import ad.Dijkstra.Graph;
public class Dijkstra {
    static class Edge {
        int destination, weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;
        Map<String, Integer> vertexMap;
        Map<Integer, String> reverseMap;

        Graph() {
            this.vertices = 0;
            adjList = new ArrayList<>();
            vertexMap = new HashMap<>();
            reverseMap = new HashMap<>();
        }

        void addEdge(String source, String destination, int weight) {
            int srcIndex = getVertexIndex(source);
            int destIndex = getVertexIndex(destination);

            adjList.get(srcIndex).add(new Edge(destIndex, weight));
            adjList.get(destIndex).add(new Edge(srcIndex, weight)); 
        }
        private int getVertexIndex(String vertex) {
            if (!vertexMap.containsKey(vertex)) {
                vertexMap.put(vertex, vertices);
                reverseMap.put(vertices, vertex);
                adjList.add(new ArrayList<>());
                vertices++;
            }
            return vertexMap.get(vertex);
        }
    }

    static void dijkstra(Graph graph, String source) {
        int vertices = graph.vertices;
        int[] dist = new int[vertices];  
        Arrays.fill(dist, Integer.MAX_VALUE);
        int sourceIndex = graph.vertexMap.get(source);
        dist[sourceIndex] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
        pq.offer(sourceIndex);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (Edge edge : graph.adjList.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(v); 
                }
            }
        }

        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            String vertex = graph.reverseMap.get(i);
            System.out.println("Vertex " + vertex + ": " + dist[i]);
        }
    }
	public static void main(String[] args) {
		Graph graph = new Graph();
        graph.addEdge("s", "w", 10);
        graph.addEdge("s", "x", 5);
        graph.addEdge("w", "z", 1);
        graph.addEdge("w", "x", 2);
        graph.addEdge("x", "w", 3);
        graph.addEdge("x", "z", 9);
        graph.addEdge("x", "y", 2);
        graph.addEdge("y", "z", 6);
        dijkstra(graph, "s");

	}

}


    

