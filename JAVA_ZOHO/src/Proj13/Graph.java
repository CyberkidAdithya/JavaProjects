package Proj13;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

//class Vertex {
//    String label;
//    Vertex(String label) {
//        this.label = label;
//    }
//    // equals and hashCode
//}

public class Graph {
    //    HashMap<Vertex, ArrayList<Vertex>> map = new HashMap<>();
    private int V = 2;
    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
    int[][] weights = new int[V][V];
    boolean[] visited = new boolean[V];

    Graph(int V) {   // initialize graph
        this.V = V;

        for (int i = 0; i < V; i++) {
            this.adj.add(i, new ArrayList<>());
        }

        for (int[] row: weights) {
            Arrays.fill(row, -1);
        }
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
        boolean directedGraph = false;      // <----- change HERE
        adj.get(u).remove(v);
        weights[u][v] = -1;
        if (!directedGraph) {
            adj.get(v).remove(u);
            weights[v][u] = -1;
        }
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
