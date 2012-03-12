/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p2heaps;

/**
 *
 * @author Ariel Krakowski
 */
public class MinHeap extends Heaper {

    public MinHeap(int[] arr, int de)
    {
        super(arr, de);
        buildminheap();
        printheap();
    }


    public void minheapify(int i)
    {
        int littleindex=i;
        for(int n=1;n<=d;n++)
        {
            int child = i*d+n;
            if(child<heapsize){ //<=
                if(ar[child]<ar[littleindex])
                    littleindex=child;
            }
        }

        if(littleindex!=i){
        int temp=ar[i];
        ar[i]=ar[littleindex];
        ar[littleindex]=temp;
        minheapify(littleindex);
        }

    }

      public void buildminheap()
    {
        heapsize = ar.length;

        int j = heapsize/d; //-1
        while(j>=0){
            minheapify(j);
            j--;
            }


    }
      
      public void sortdecreasingorder()
    {
           {
          //already built maxheap.

          for(int i=ar.length-1; i>=0; i--){
              int temp = ar[0];
              ar[0]=ar[i];
              ar[i]=temp;

              heapsize--;
              minheapify(0);
          }


          System.out.println("\nMin-HeapSorted: ") ;

          for(int i=0; i<ar.length; i++){
              System.out.print(ar[i]+" ");
          }

    }

    }




      //priority Q

    public void insert(int key)
    {
        heapsize++;
        if(heapsize>ar.length){
          int[]newarray = new int[ar.length*2];
        for(int i=0;i<ar.length;i++){
            newarray[i]= ar[i];
            }
        }
        ar[heapsize-1] = -2147483646;
        decreasekey(heapsize -1, key);

    }
    public int minimum()
    {
        return ar[1];

    }
    public int extractmin()
    {
        if (heapsize<1) //<0
            return -1;

        else{
        int min=ar[0];

        ar[0]=ar[heapsize-1];
        heapsize--;
        minheapify(0);

        return min;
        }

    }


    public void decreasekey(int i,int key)
    {
        if(key>i){
            System.out.println("error");
        }
        else{
            ar[i]=key;
            while(i>0 && ar[parent(i)] > ar[i]){
              int temp = ar[i];
              ar[i]=ar[parent(i)];
              ar[parent(i)]=temp;
              i=parent(i);

            }
        }


    }


}
