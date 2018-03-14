/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

import java.util.Stack;

/**
 *
 * @author hp
 */
public class DirectedDFS {
     private boolean marked[];
    private int count;
    private boolean canCallPathTo=false;
    private int[] edgeTo;
    private int V;
    public DirectedDFS(Digraph graph,int v)
    {
        this.canCallPathTo=true;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        V=v;
        dfs2(graph,v);
    }
    public DirectedDFS(Digraph graph,Iterable<Integer> sources)
    {
        marked = new boolean[graph.V()];
        for(int v:sources)
        {
            if(!marked[v])
            {
                dfs(graph,v);
            }
        }
    }
    public boolean marked(int v)
    {
        return marked[v];
    }
    public void dfs(Digraph g,int v)
    {
        marked[v] = true;
        for(int w:g.adj(v))
        {
            if(!marked[w])
            {
                dfs(g,w);
            }
        }
        
    }
    public void dfs2(Digraph g,int v)
    {
        marked[v] = true;
        for(int w:g.adj(v))
        {
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs2(g,w);
            }
        }
        
    }
    
    public boolean hasPath(int v)
    {
        return marked(v);
    }
    public Iterable<Integer> pathTo(int v)
    {
        if(!this.canCallPathTo) return null;
        if(!(hasPath(v))) return null;
        
        Stack st = new Stack();
        for(int w=v;w!=this.V;w=edgeTo[w])
        {
            st.push(w);
        }
        st.push(this.V);
        
        return st;
    }
}
