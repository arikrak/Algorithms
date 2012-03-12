/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p2heaps;

/**
 *
 * @author Ariel Krakowski
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[]arr = new int[13];

        for(int i=1;i<arr.length;i++){
            arr[i]=(int)(Math.random()*10*i); //
        }
        System.out.println("Array followed by MaxHeap: ");
        MaxHeaper maxH = new MaxHeaper(arr, 3);

        System.out.println( " size " + maxH.sizeofheap());
        
        maxH.sortincreasingorder();

        int [] agg = new int[21];
        int k=0;
        int l=21;
        while(k<21){
            agg[k]=l;
            k++;
            l--;
        }

        System.out.println("\nArray followed by MinHeap: ");
        MinHeap minH = new MinHeap(agg, 4);
        minH.sortdecreasingorder();

        int [] att = new int[15];
        k=0;
        l=15;
        while(k<14){
            att[k]=l;
            k++;
            l--;
        }

        System.out.println("\nArray followed by MinHeap: ");
        MinHeap minQ = new MinHeap(att, 2);

        System.out.println("\n test queue:");
        int i=0;
        while(i < 3){
        System.out.println("Extract-Min: " +minQ.extractmin());
        i++;
        }
        while(i<5){
            minQ.insert(i);
            i++;
        }

        System.out.println("Heap after numbers 3 & 4 inserted: ");
        minQ.printheap();



    }

}
