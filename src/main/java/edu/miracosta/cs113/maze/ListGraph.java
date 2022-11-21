package edu.miracosta.cs113.maze;


import java.util.*;

public class ListGraph extends AbstractGraph {
    private List<Edge>[] edges;

    public ListGraph(int numV, boolean directed){
        super(numV, directed);
        edges = new List[numV];
        for (int i = 0 ; i < numV; i++){
            edges[i]=new LinkedList<Edge>();
        }
    }

    public boolean isEdge(int source, int dest){
        return edges[source].contains(new Edge(source, dest));
    }

    public void insert(Edge edge){
        edges[edge.getSource()].add(edge);
        if(!isDirected()){
            edges[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
    }

    public Iterator<Edge> edgeIterator(int source){
        return edges[source].iterator();
    }

    public Edge getEdge(int source, int dest){
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);

        for(Edge edge : edges[source]){
            if (edge.equals(target)){
                return edge;
            }
        }

        return target;
    }

}
