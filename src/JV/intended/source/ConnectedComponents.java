/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

/**
 * This finds connected components in undirected graph using depth first search mechanism which restarts at unvisited vertex
 * @author hp
 */
public class ConnectedComponents {
     private boolean marked[];
    private int id[];
    int S;
    int count;
    
    public ConnectedComponents(Graph_DS graph)
    {
        this.marked = new boolean[graph.V()];
        this.id = new int[graph.V()];
        
        for(int i =0;i<graph.V();i++)
        {
            if(!marked[i])
            {
                dfs(graph,i);
                System.out.println();
                count++;
            }
            
            
        }
        
                
    }
    
    public void dfs(Graph_DS g,int v)
    {
        marked[v] = true;
        id[v] = count;
        System.out.print(v+" ");
        for(int w:g.adj(v))
        {
            if(!marked[w])
            {
                
                 dfs(g,w);
            }
        }
    }
    public boolean connected(int v,int w)
    {
        return id[v]==id[w];
    }
    public int id(int v)
    {
        return id[v];
    }
    
    public int count()
    {return count;}
    
}
