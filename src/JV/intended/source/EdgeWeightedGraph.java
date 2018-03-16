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
public class EdgeWeightedGraph {
    private int vertexSize;
    private int EdgeSize;
    private LinkedList<Edge> adjList[];
    
    public EdgeWeightedGraph(int size)
    {
        vertexSize = size;EdgeSize=0;
        adjList = new LinkedList[size];
        for(int v = 0;v<size;v++)
            adjList[v] = new LinkedList<>();
    }
    
    public int vertexSize()
    {
        return vertexSize;
    }
    public int EdgeSize()
    {
        return EdgeSize;
    }
    public void addEdge(Edge e)
    {
        int v = e.either(),w=e.other(v);
        adjList[v].add(e);
        adjList[w].add(e);
        EdgeSize++;
    }
    public Iterable<Edge> adj(int v)
    {
        return adjList[v];
    }
    
    public Iterable<Edge> edges() 
    {
        LinkedList<Edge> edges = new LinkedList();
        for(int v = 0;v<vertexSize;v++)
            for(Edge e : adjList[v])
                if(e.other(v)>v)
                    edges.add(e);
        return edges;
    }
}
