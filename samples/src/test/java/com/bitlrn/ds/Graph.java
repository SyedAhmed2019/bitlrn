package com.bitlrn.ds;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {
    final int vertices;
    final LinkedList<Integer>[] adjacencyLists;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyLists = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyLists[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.traverseDfs(0, new boolean[4]);

    }

    public void addEdge(int vertex, int edge) {
        adjacencyLists[vertex].add(edge);
    }

    public void traverseDfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println("->" + vertex);
        ListIterator<Integer> iterator = adjacencyLists[vertex].listIterator();
        while (iterator.hasNext()) {
            int neighborVertex = iterator.next();
            if (!visited[neighborVertex]) {
                traverseDfs(neighborVertex, visited);
            }
        }
    }
}
