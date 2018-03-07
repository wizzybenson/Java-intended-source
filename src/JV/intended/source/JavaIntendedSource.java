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
public class JavaIntendedSource {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DisjointSet DS = new DisjointSet();
        int[] arr = {1,2,3,4,5,6,7};
        for(int a : arr)
        DS.CreateSet(a);
        
        DS.union(1, 2);
        DS.union(2, 3);
        DS.union(4, 5);
        DS.union(6, 7);
        DS.union(5, 6);
        DS.union(3, 7);
        
        System.out.println(DS.find(1));//For all values from 1-7 this would give 4 because they are all now in the same set.
    }
    
}
