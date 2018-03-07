package JV.intended.source;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */

import java.util.*;
/*
 * Undirected Graph data structure implemented as Array of linkedlists
 * 
 */
public class Graph_DS {
    private LinkedList<Integer> adjList[]; 
    private int VertexSize;
    private int EdgeSize;
    
    /**
     * The constructor takes the graph size 
     * creates an array of linked list of given size
     * @param size
     */
    public Graph_DS(int size)
    {
        this.VertexSize = size;
        adjList = new LinkedList[size];
        
        for(int i = 0;i<size;i++)
        {
            adjList[i] = new LinkedList();
        }
    }
    
    /**
     * returns the size of vertices in the graph
     * @return
     */
    public int V()
    {
        return this.VertexSize;
    }

    /**
     * returns the size of edges in the graph
     * @return
     */
    public int E()
    {
        return this.EdgeSize;
    }
    
    /**
     * Because it's undirected, the two vertices would have each other in their respective adjacency list
     * then increment edgesize
     * @param v
     * @param w
     */
    public void addEdge(int v,int w)
    {
        adjList[v].add(w);
        adjList[w].add(v);
        this.EdgeSize++;
        
    }
    
    /**
     * returns all the adjacency of a given vertex as iterable type
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v)
    {
        return adjList[v];
    }
}
