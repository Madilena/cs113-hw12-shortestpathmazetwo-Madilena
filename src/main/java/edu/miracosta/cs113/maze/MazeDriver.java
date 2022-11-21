package edu.miracosta.cs113.maze;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MazeDriver {
    public static <Graph> void main(String[] args){
        int numV = 0;
        edu.miracosta.cs113.maze.Graph theMaze = null;
        try{
            Scanner scan = new Scanner(new File("/Users/madilenamendiola/IdeaProjects/cs113-hw11-shortestpathmaze-Madilena/src/main/java/edu/miracosta/cs113/maze/maze.txt"));
            theMaze = AbstractGraph.createGraph(scan, false, "List");
            numV = theMaze.getNumV();
        }

        catch (IOException ex){
            System.err.println("IO Error while reading graph.");
            System.err.println(ex.toString());
            System.exit(1);
        }

        int parent[]= BreadthFirstSearch.breadthFirstSearch(theMaze, 0);
        Stack thePath = new Stack();
        int v = numV - 1;
        while (parent[v] != -1){
            thePath.push(v);
            v = parent[v];
        }

        System.out.println("***THE SHORTEST PATH IS:");
        while(!thePath.empty()){
            System.out.println(thePath.pop());
        }
    }
}
