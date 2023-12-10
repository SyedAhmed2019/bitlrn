package com.bitlrn.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T extends Comparable<T>> {
    T data;
    List<Vertex<T>> children = new ArrayList<>();

    protected Vertex<T> addChild(T data) {
        for (Vertex<T> child : children) {
            if (child.data.compareTo(data) == 0) {
                return child;
            }
        }
        Vertex<T> vertex = new Vertex<>();
        vertex.data = data;
        children.add(vertex);
        return vertex;
    }
}
