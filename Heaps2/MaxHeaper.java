/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p2heaps;

/**
 *
 * @author Ariel Krakowski
 */
public class MaxHeaper extends Heaper {

    public MaxHeaper(int[] arr, int de)
    {
        super(arr, de);
        buildmaxheap();
        printheap();
                
    }
    
     public void maxheapify(int i)
    {
        int big=i;
        for(int n=1;n<=d;n++)
        {
            int child = i*d+n;
            if(child<heapsize){ //<=
                if(ar[child]>ar[big])
                    big=child;
            }
        }


        if(big!=i){  //swap
        int temp=ar[i];
        ar[i]=ar[big];
        ar[big]=temp;
        maxheapify(big);        
        }

    }
     
      public void buildmaxheap()
    {
        heapsize = ar.length; //-1

        
        int j = heapsize/d;  //d
        while(j>=0){
            maxheapify(j);
            j--;
            }
       
    }

      public void sortincreasingorder() //i.e HeapSort
    {
          //already built maxheap.

          for(int i=ar.length-1; i>=0; i--){
              int temp = ar[0];
              ar[0]=ar[i];
              ar[i]=temp;

              heapsize--;
              maxheapify(0);
          }


          System.out.println("Max-HeapSorted: ") ;

          for(int i=0; i<ar.length; i++){
              System.out.print(ar[i]+" ");
          }

    }

      //to switch order, just swap each element


}
