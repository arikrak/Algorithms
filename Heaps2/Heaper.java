/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p2heaps;

/**
 *
 * @author Ariel Krakowski
 */
public class Heaper {

    public int[] ar;
    public int heapsize;
    public int d;

    public Heaper(int[] arr, int de)
    {
        ar =arr;
        d= de;

        System.out.print("\nBefore: ");
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }

        System.out.println("\n Heaped:");

       

    }



    public int parent(int i)
{
    return i/d;
}

    public int sizeofheap()
{
        return heapsize;

}


    public void printheap()  //fix for d-ary heap
    {
        int two=1;
        int i=0;
        while(i<ar.length){
            System.out.print(ar[i] +" ");          
            i++;
            if(i==two){  //%i
                two=two+(two*d);
                System.out.println("");
            }
            
        }
    }


}
