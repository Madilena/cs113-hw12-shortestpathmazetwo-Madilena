package edu.miracosta.cs113.maze;

import java.util.*;

public class Edge {
    private int dest;
    private int source;
    private double weight;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    public Edge (int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }

    public boolean equals(Object o) {
        return false;
    }

    public int getDest() {
        return this.dest;
    }

    public int getSource() {
        return this.source;
    }

    public double getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "";
    }
}
