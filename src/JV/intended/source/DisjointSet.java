package JV.intended.source;


import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *DisjointSet datastructure with path compression and union by rank
 * @author hp
 */
public class DisjointSet {
    
    private Map<Integer,Node> map = new HashMap<>();//Map to store the elements of the set as key to their various Node types.
    
    class Node{
        int data;
        Node parent;
        int rank;//rank is used to approximate the height of the tree rooted at this node. particularly useful for node representatives.
    }
    
    /**
     * Makeset creates a new Node object for the specified element.
     * initial rank is 0
     * Node is put in the map as value to a key of element
     * @param element
     */
    public void CreateSet(int element)
    {
        Node node = new Node();
        node.data = element;
        node.parent = node;
        node.rank = 0;
        map.put(element, node);
    }
    
    /**
     * find checks if current node is equal to it's own parent
     * and returns the parent if it is.
     * else recursively finds the representative of the set in which node belongs.
     * It does path compression on return.
     * @param node
     * @return 
     */
    private Node find(Node node)
    {
        if(node.parent==node)
            return node.parent;
       return node.parent=find(node.parent);//path compression done with the assignment.
    }
    
    /**
     * The public find takes int values and defers to the private find method to do the work.
     * it returns int value of the representative of the set
     * @param element
     * @return
     */
    public int find(int element)
    {
        return find(map.get(element)).data;
    }
    
    /**
     * Union takes two elements,
     * extracts the Node values from the map
     * calls find on them to determine their representative(rep)
     * if they have the same rep then do nothing.
     * if the rank of rep of element1 > that of element2 then
     * the parent of rep2 becomes rep1
     * if the ranks are equal you increment rep1.rank by one and make it the parent of rep2.
     * else rep2 becomes rep1.parent
     * @param element1
     * @param element2
     */
    public void union(int element1,int element2)
    {
        Node node1 = map.get(element1);
        Node node2 = map.get(element2);
        Node rep1 = find(node1);
        Node rep2 = find(node2);
        
        if(rep1==rep2)
            return;
        if(rep1.rank >= rep2.rank)
        {
            rep1.rank = (rep1.rank==rep2.rank) ? rep1.rank+1:rep1.rank;
            rep2.parent = rep1;
        }
        else rep1.parent = rep2;
    }
    
    
    
}
