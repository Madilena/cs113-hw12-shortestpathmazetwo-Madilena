package edu.miracosta.cs113.maze;

import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {
    private int numV;
    private boolean directed;
    private double[][] edges;
    private boolean[][] isSetMatrix;

    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);

        this.directed = directed;
        this.numV = numV;

        // Simply initializes our adjacency matrix to the appropriate size
        edges = new double[numV][numV];
        isSetMatrix = new boolean[numV][numV];
    }

    public void insert(Edge edge ) {
        int source = edge.getSource();
        int destination  = edge.getDest();
        int valueToAdd = 1;

        edges[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!directed) {
            edges[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }


    public void addEdge(int source, int destination, float weight) {

        float valueToAdd = weight;

        edges[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!directed) {
            edges[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }
    public void printMatrix() {
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                // We only want to print the values of those positions that have been marked as set
                if (isSetMatrix[i][j])
                    System.out.format("%8s", String.valueOf(edges[i][j]));
                else System.out.format("%8s", "/  ");
            }
            System.out.println();
        }
    }
    public void printEdges() {
        for (int i = 0; i < numV; i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (int j = 0; j < numV; j++) {
                if (isSetMatrix[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
    public boolean isEdge(int source, int destination) {
        return isSetMatrix[source][destination];
    }

    public Edge getEdge(int source, int destination) {
        if ( !isSetMatrix[source][destination])
            return null;
        double weight = edges[source][destination];
        Edge edge = new Edge(source, destination, weight);
        return edge;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return null;
    }
}
