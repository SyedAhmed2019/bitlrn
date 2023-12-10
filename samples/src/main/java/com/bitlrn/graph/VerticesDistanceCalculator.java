package com.bitlrn.graph;

import java.util.*;

public class VerticesDistanceCalculator<T extends Comparable<T>> extends Vertex<T> {
    Map<String, Vertex<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VerticesDistanceCalculator<Integer> vdc = new VerticesDistanceCalculator<>();
        vdc.prepareGraph(scanner);
        vdc.graph.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().children.stream().forEach(a -> System.out.print(a.data));
            System.out.println();
        });
        // get input on which vertices shortest path to find
        int start = scanner.nextInt();
        int to = scanner.nextInt();
        System.out.println(vdc.bfs(start, to));

    }

    private int bfs(T start, T to) {
        List<Vertex<T>> visited = new ArrayList<>();
        Vertex startVertex = graph.get(String.valueOf(start));
        if (startVertex == null) {
            return -1;
        }
        Vertex endVertex = graph.get(String.valueOf(to));
        if (endVertex == null) {
            return -1;
        }
        if (startVertex.data.equals(endVertex.data)) {
            return 0;
        }
        Deque<Vertex<T>> queue = new ArrayDeque<>();
        queue.add(startVertex);
        int minDist = Integer.MAX_VALUE;
        int dist = 0;
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.pop();
            visited.add(current);
            dist++;
            for (Vertex<T> child : current.children) {
                if (!visited.contains(child)) {
                    if (child.data.equals(endVertex.data)) {
                        if (dist < minDist) {
                            minDist = dist;
                            break;
                        }
                    }
                    queue.add(child);
                }
            }

        }
        if (minDist == Integer.MAX_VALUE) {
            return -1;
        }
        return minDist;
    }

    private void prepareGraph(Scanner scanner) {

        System.out.println("Number of vertices in graph");
        int connectionsCnt = scanner.nextInt();
        for (int i = 0; i < connectionsCnt; ++i) {
            String connection = scanner.next();
            String[] vertices = connection.split(",");
            Vertex<Integer> vertex;
            if (!graph.containsKey(vertices[0])) {
                vertex = new Vertex<>();
                vertex.data = Integer.parseInt(vertices[0]);
                graph.put(vertices[0], vertex);
            } else {
                vertex = graph.get(vertices[0]);
            }
            for (int j = 1; j < vertices.length; ++j) {
                Vertex<Integer> child = vertex.addChild(Integer.parseInt(vertices[j]));
                child.addChild(vertex.data);
                if (!graph.containsKey(vertices[j])) {
                    graph.put(vertices[j], child);
                }
            }
        }
    }
}
