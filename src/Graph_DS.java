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
 * Graph data structure implemented as Array of linkedlists
 */
public class Graph_DS {
    private LinkedList<Integer> adjList[]; 
    private int V;
    private int E;
    
    public Graph_DS(int v)
    {
        this.V = v;
        adjList = new LinkedList[v];
        
        for(int i = 0;i<v;i++)
        {
            adjList[i] = new LinkedList();
        }
    }
    
    public int V()
    {
        return this.V;
    }
    public int E()
    {
        return this.E;
    }
    
    public void addEdge(int v,int w)
    {
        adjList[v].add(w);
        adjList[w].add(v);
        this.E++;
        
    }
    public Iterable<Integer> adj(int v)
    {
        return adjList[v];
    }
}
