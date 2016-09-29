/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_sorting;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author uFernando
 */
public class APS_Sorting {

    /**
     * @param args the command line arguments
     */    
    public static <T extends Comparable<T>> void TestSort(Vector<T> items) {
        long m;
        System.out.println("Items aleatorios");
        System.out.println(items.toString());
        
        System.out.println("\nBubble Sort");
        BubbleSort<T> bubbleSort = new BubbleSort<T>();
        bubbleSort.Insert(items);
        m = bubbleSort.Measure();
        System.out.println(bubbleSort.Result().toString());
        System.out.println("Took: "+m+"ms");

        System.out.println("\nQuick Sort");
        QuickSort<T> quickSort = new QuickSort<T>();
        quickSort.Insert(items);
        m = quickSort.Measure();
        System.out.println(quickSort.Result().toString());                                
        System.out.println("Took: "+m+"ms");            
        
        System.out.println("\nTree Sort");
        TreeSort<T> treeSort = new TreeSort<T>();
        treeSort.Insert(items);
        m = treeSort.Measure();
        System.out.println(treeSort.Result().toString());                                
        System.out.println("Took: "+m+"ms");
    }
    
    public static void TestIntegers() {
        Vector<Integer> items = new Vector<Integer>();
        Random r = new Random();
        for(int i=0; i<1000; i++)
            items.add(r.nextInt());
        System.out.println("Testing integers:\n");
        TestSort(items);
        System.out.println("End integers\n\n");
    }
    
    public static void TestStrings() {
        Vector<String> items = new Vector<String>();
        Random r = new Random();
        for(int i=0; i<1000; i++)
            items.add(Long.toString(Math.abs(r.nextLong()), 36));
        System.out.println("Testing strings:\n");
        TestSort(items);
        System.out.println("End strings\n\n");
    }
    
    public static void main(String[] args) {
        (new APSSort()).setVisible(true);
        //TestIntegers();
        //TestStrings();
    }
}
