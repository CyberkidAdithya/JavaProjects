package Proj13;

import java.util.ArrayList;
import java.util.Iterator;

//class Vertex {
//    String label;
//    Vertex(String label) {
//        this.label = label;
//    }
//    // equals and hashCode
//}

public class Graph {    // adj list representation
    private int V = 2;
    static boolean directedGraph = false;

    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

//    int[][] weights = new int[V][V];
    boolean[] visited = new boolean[V];

    Graph(int V) {   // initialize graph
        this.V = V;

        for (int i = 0; i < V; i++) {
            this.adj.add(i, new ArrayList<>());
        }

//        for (int[] row: weights) {
//            Arrays.fill(row, -1);
//        }
    }

    public void addEdge(int u, int v) {  // adding cities
        boolean directedGraph = false;      // <----- change HERE
        adj.get(u).add(v);
//        weights[u][v] = dist;
        if (!directedGraph) {
            adj.get(v).add(u);
//            weights[v][u] = dist;
        }
    }

    public void removeEdge(int u, int v) {
        adj.get(u).remove(v);
//        weights[u][v] = -1;
        if (!directedGraph) {
            adj.get(v).remove(u);
//            weights[v][u] = -1;
        }
    }

    public void removeNode(int u) {
        if (!directedGraph) {
            for (int v: adj.get(u)) {
                adj.get(v).remove(u);
            }
        }
        adj.get(u).clear();
    }

    public String printGraph() {
        Iterator graphIterator = adj.iterator();
        String graphString = "";
        int index = 0;
        while (graphIterator.hasNext()) {
            Object graphElement = graphIterator.next();
            graphString +=  index + " : " + graphElement + "\n";
            index++;
        }
        return graphString;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adj=" + adj +
                '}';
    }
}
