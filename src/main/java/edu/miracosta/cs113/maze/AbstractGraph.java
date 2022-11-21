package edu.miracosta.cs113.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AbstractGraph implements Graph {
    private final int numV;
    private final boolean directed;

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

        while(scan.hasNext()) {
            String line = scan.nextLine();

            //separate all values by comma
            String[] lineVector = line.split(",");
            int source = Integer.parseInt(lineVector[0]);
            int dest = Integer.parseInt(lineVector[1]);
            if(isDirected()) {
                Edge edge = new Edge(source, dest);
                insert(edge);
            }else{
                int weight = Integer.parseInt(lineVector[2]);
                Edge edge = new Edge(source, dest, weight);
                insert(edge);
            }

        }
        System.out.println("Closing Scanner...");
        scan.close();
    }

    public static Graph createGraph(Scanner scan, boolean isDirected, String type) throws FileNotFoundException {

        //int numV = scan.nextInt();

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
