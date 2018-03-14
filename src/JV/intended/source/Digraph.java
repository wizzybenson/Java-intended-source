/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

import java.util.LinkedList;

/**
 *
 * @author hp
 */
public class Digraph {
     private LinkedList<Integer> adjList[]; 
    private int V;
    private int E;
    
    public Digraph(int v)
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
        this.E++;
        
    }
    public Iterable<Integer> adj(int v)
    {
        return adjList[v];
    }
    
    public Digraph reverse()
    {
        Digraph Rdg = new Digraph(V);
        for(int v = 0;v<V;v++)
        {
            for(int w:adj(v))
            {
                Rdg.addEdge(w,v);
            }
        }
        
        return Rdg;
    }
}
