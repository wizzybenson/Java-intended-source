/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

import java.util.Stack;

/**
 * This class uses depth first search to find single source paths in an undirected and unweighted graph.
 * @author hp
 */
public class DepthFirstPaths {
    private boolean marked[];//to keep track of visited vertex
    private int edgeTo[];//this serves as a way to keep parent pointers to visited vertices during the first visit and used to reconstruct the paths
    int source;
    
    /**
     * the constructor takes an undirected graph and the source vertex
     * it calls a dfs method and passes it the graph and the source vertex.
     * @param graph
     * @param source
     */
    public DepthFirstPaths(Graph_DS graph,int source)
    {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.source = source;
        dfs(graph,this.source);
                
    }
    
    /**
     *
     * this method employs depthfirst approach to visit all the connected vertices and set the parent vertex of the not yet marked vertex.
     * @param g
     * @param vertex
     */
    public void dfs(Graph_DS g,int vertex)
    {
        marked[vertex] = true;
        
        for(int w:g.adj(vertex))
        {
            if(!marked[w])
            {
                edgeTo[w] = vertex;
                dfs(g,w);
            }
        }
    }
    
    /**
     *It returns true if the constructor preprocessing already marked the given vertex as having path to the source.
     * @param vertex
     * @return
     */
    public boolean hasPathTo(int vertex)
    {
        return marked[vertex];
    }
    
    /**
//     * The pathTo method gives the client access to the path from the source to the given vertex
     * it traverses the edgeTo array and stores the path in a stack which is then returned as iterable type.
     * @param vertex
     * @return
     */
    public Iterable<Integer> pathTo(int vertex)
    {
        if(!hasPathTo(vertex)) return null;
        Stack path = new Stack();
        for(int x=vertex;x!=this.source;x=edgeTo[x])
        {
            path.push(x);
            
        }
        path.push(this.source);
        return path;
    }
}
