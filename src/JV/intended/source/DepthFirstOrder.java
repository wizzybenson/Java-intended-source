/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JV.intended.source;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author hp
 */
public class DepthFirstOrder {
    private LinkedList pre;
    private LinkedList post;
    private Stack reversePost;
    private boolean[] marked;
    
    public DepthFirstOrder(Digraph G)
    {
        pre = new LinkedList();
        post = new LinkedList();
        reversePost = new Stack();
        marked = new boolean[G.V()];
        for(int v = 0;v<G.V();v++)
        {
            if(!marked[v])
            dfs(G,v);
        }
    }
    
     public void dfs(Digraph g,int v)
    {
        marked[v] = true;
        pre.addLast(v);
        for(int w:g.adj(v))
        {
            if(!marked[w])
            {
                dfs(g,w);
            }
        }
        post.addLast(v);
        reversePost.push(v);
        
        
    }
    
    public Iterable<Integer> pre()
    {
        return pre;
    }
     public Iterable<Integer> post()
    {
        return post;
    }
      public Iterable<Integer> reversePost()
    {
        return reversePost;
    }
}
