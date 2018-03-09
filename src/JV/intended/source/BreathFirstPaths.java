/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class uses breath first search to find single source shortest paths in an undirected and unweighted graph.
 * @author hp
 */
public class BreathFirstPaths {
    private boolean marked[];//to keep track of visited vertex
    private int edgeTo[];//this serves as a way to keep parent pointers to visited vertices during the first visit and used to reconstruct the paths
    int source;
    
    /**
     * the constructor takes an undirected graph and the source vertex
     * it calls a bfs method and passes it the graph and the source vertex.
     * @param graph
     * @param source
     */
    public BreathFirstPaths(Graph_DS graph,int source)
    {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.source= source;
        bfs(graph,source);
                
    }
    
    /**
     * this method employs breathfirst approach to visit all the connected vertices and set the parent vertex of the not yet marked vertex.
     * @param graph
     * @param vertex
     */
    public void bfs(Graph_DS graph,int vertex)
    {
        marked[vertex] = true;
        Queue<Integer> queue = new LinkedList<Integer>();//To help process vertices in FIFO fashion.
        queue.add(vertex);
        while(!(queue.isEmpty()))
        {
            int v = queue.remove();
            for(int w:graph.adj(v))
            {
                if(!marked[w])
                {
                    edgeTo[w] = v;
                    marked[w]=true;
                    queue.add(w);
                }
            }
        }
    }
    
    /**
     * It returns true if the constructor preprocessing already marked the given vertex as having path to the source.
     * @param v
     * @return
     */
    public boolean hasPathTo(int v)
    {
        return marked[v];
    }
    
    /**
     * The pathTo method gives the client access to the path from the source to the given vertex
     * it traverses the edgeTo array and stores the path in a stack which is then returned as iterable type.
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v)
    {
        if(!hasPathTo(v)) return null;
        Stack path = new Stack();
        for(int x=v;x!=this.source;x=edgeTo[x])
        {
            path.push(x);
            
        }
        path.push(this.source);
        return path;
    }
}
