/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

/**
 * Kosaraju algorithm for strongly connected components
 * @author hp
 */
public class StrongConnectedComponents {
    private int count;
    private int id[];
    private boolean marked[];
    
    public StrongConnectedComponents(Digraph G)
    {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for(int v : order.reversePost())
        {
            if(!marked[v])
            {
                dfs(G,v);
                System.out.print(v+" ");
                count++;
            }
        }
    }
    
    public void dfs(Digraph G,int v)
    {
        marked[v]=true;
        id[v] = count;
        for(int w : G.adj(v))
        {
            if(!marked[w])
                dfs(G,w);
        }
        System.out.println(v+" ");
        
    }
    
    public boolean stronglyConnected(int v,int w)
    {
        return id[v]==id[w];
    }
    public int count()
    {
        return count;
    }
    public int id(int v)
    {
        return id[v];
    }
}
