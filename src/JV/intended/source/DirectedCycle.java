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
public class DirectedCycle {
     private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack cycle;
    
    
    public DirectedCycle(Digraph G)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];
        
        for(int v=0;v<G.V();v++)
        {
            if(!marked[v])
            dfs(G,v);
        }
    }
    
    public void dfs(Digraph G,int v)
    {
        onStack[v] = true;
        marked[v] = true;
        for(int w:G.adj(v))
        {
            if(hasCycle())return;
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(G,w);
            }
            else{
            
                if(onStack[w])
                {
                    cycle = new Stack();
                    for(int x=v;x!=w;x=edgeTo[x])
                    {
                        cycle.push(x);
                    }
                    cycle.push(w);
                    cycle.push(v);
                }
            }
        }
        onStack[v] = false;
    }
    
    public boolean hasCycle()
    {
        return cycle !=null;
        
    }
    
    public Iterable<Integer> cycle()
    {
        return cycle;
    }
}
