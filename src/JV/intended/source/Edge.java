/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

/**
 *
 * @author hp
 */
public class Edge implements Comparable<Edge> {
    private int vertex1,vertex2;
    private double weight;
    
    public Edge(int v,int w,double weight)
    {
        vertex1 = v;
        vertex2 = w;
        this.weight = weight;
    }
    
    public int either()
    {
        return vertex1;
    }
    public int other(int vertex)
    {
        if(vertex==vertex1)return vertex2;
        else if(vertex==vertex2)return vertex1;
        else return -1;
    }
    public double weight()
    {
        return this.weight;
    }
    
    @Override
    public int compareTo(Edge that)
    {
        if(this.weight()<that.weight())return -1;
        else if(this.weight()>that.weight())return 1;
        return 0;
    }
}
