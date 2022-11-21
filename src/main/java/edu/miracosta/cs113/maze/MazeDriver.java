package edu.miracosta.cs113.maze;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MazeDriver {
    public static void main(String[] args){
        Graph g = null;
        int n = 0;
        edu.miracosta.cs113.maze.Graph theMaze = null;
        try{
            Scanner scan = new Scanner(new File("/Users/madilenamendiola/IdeaProjects/cs113-hw12-shortestpathmazetwo-Madilena/src/main/java/edu/miracosta/cs113/maze/maze.txt"));
            g = AbstractGraph.createGraph(scan, true, "Matrix");
            n = g.getNumV();
        }

        catch (IOException ex){
            ex.printStackTrace();
            System.exit(1);
        }

        DepthFirstSearch dfs = new DepthFirstSearch(g);
        int[] dOrder = dfs.getDiscoveryOrder();
        int[] fOrder = dfs.getFinishOrder();
        System.out.println("Discovery and finish order");
        for (int i = 0; i < n; i++){
            System.out.println(dOrder[i] + " " + fOrder[i]);
        }
    }
}
