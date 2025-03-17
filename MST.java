
import java.util.*;

public class MST {
    private int vertices;
    private List<List<Node>> adjacencyList;

    // Node class to store vertex and its weight
    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public MST(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int u, int v, int weight) {
        adjacencyList.get(u).add(new Node(v, weight));
        adjacencyList.get(v).add(new Node(u, weight)); // For undirected graph
    }

    // Prim's algorithm to find MST
    public void primMST() {
        boolean[] inMST = new boolean[vertices];
        int[] key = new int[vertices];
        int[] parent = new int[vertices];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(vertices, Comparator.comparingInt(node -> node.weight));

        // Initialize arrays
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;
        priorityQueue.add(new Node(0, key[0]));

        int totalWeight = 0;  // Variable to store the total weight of the MST

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            int u = node.vertex;

            if (inMST[u]) {
                continue;  // Skip if u is already included in MST
            }

            inMST[u] = true;
            totalWeight += node.weight;  // Add weight to the MST total weight

            // Explore neighbors of u
            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If v is not in MST and weight is less than key[v], update the key and parent
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    priorityQueue.add(new Node(v, key[v]));
                }
            }
        }

        // Print the MST edges and the total weight
        printMST(parent);
        System.out.println("\nTotal weight of the MST: " + totalWeight);
    }

    // Method to print the MST
    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            // Find the weight of the edge between parent[i] and i
            int weight = 0;
            for (Node neighbor : adjacencyList.get(parent[i])) {
                if (neighbor.vertex == i) {
                    weight = neighbor.weight;
                    break;
                }
            }
            System.out.println(parent[i] + " - " + i + "\t" + weight);
        }
    }

    public static void main(String[] args) {
        int vertices = 7;  // Update vertices to match the number of vertices in your example
        MST graph = new MST(vertices);
        
        // Add edges
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 20);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 5, 15);
        graph.addEdge(3, 4, 12);
        graph.addEdge(3, 5, 35);
        graph.addEdge(3, 6, 18);
        graph.addEdge(4, 6, 4);
        graph.addEdge(5, 6, 30);
       

        // Perform Prim's algorithm to find MST
        graph.primMST();
    }
}

