package edu.miracosta.cs113.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AbstractGraph implements Graph {
    private final int numV;
    private final boolean directed;
    /**
     * Comma delimiter string parsing in graphs
     */
    public static final String DELIM = ","; //for file parsing

    public AbstractGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }

    public int getNumV(){
        return numV;
    }

    public boolean isDirected(){
        return directed;
    }

    public void loadEdgesFromFile(Scanner scan){

    }

    public static Graph createGraph(Scanner scan, boolean isDirected, String type) throws FileNotFoundException {

        String line = scan.nextLine();
        int numV = Integer.parseInt(line);
        AbstractGraph returnValue = null;
        if(type.equalsIgnoreCase("Matrix")){
            returnValue = new MatrixGraph(numV, isDirected);
        } else if (type.equalsIgnoreCase("List")){
            returnValue = new ListGraph(numV, isDirected);
        }
        else{
            throw new IllegalArgumentException();
        }
        returnValue.loadEdgesFromFile(scan);
        return returnValue;
    }
}
