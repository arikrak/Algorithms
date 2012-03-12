/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hashing;

/**
 *
 * @author Ariel Krakowski
 */
//import java.util.LinkyLists;
//import java.util.ArrayList;

public class Chainingcopy {
    
   //ArrayList<LinkyLists> arlist;
    LinkyLists[] ar;
   int m;
   int i;
   int nodes;
    
 public Chainingcopy()
 {

    //check like before
    //arlist = new ArrayList<LinkyLists>(8);  //(8)
     ar= new LinkyLists[8];  //8
     m = ar.length;

    i=0;
    while(i<m){
    LinkyLists list = new LinkyLists();
    ar[i]=list;
    i++;
    }

 }

public void insert(int x)
{
     //insert x at the head of a list
    int in = hf(x);
    LinkyLists li = ar[in];
    /* somehow its still getting a null.. 
     if(li==null)
        System.out.print("NULL!**"); */
    li.add(x);
    ar[in]=li;
    nodes++;

    if(nodes>m/2){   //in real life, it can actually hold much more..
        m= m*2;
        LinkyLists[] tempar = new LinkyLists[m];
        ar = fillUp(tempar);
    }

}

public LinkyLists[] fillUp(LinkyLists[] tempar)
{

            int j=0;
            while(j<m){
                LinkyLists list = new LinkyLists();
                tempar[j]=list;
                j++;
            }
        for(LinkyLists l: ar){
            if(! l.isEmpty()){
            Integer[] nums = l.toArray();

                for(Integer n:nums){
                    int index =hf(n);

                    LinkyLists copy=tempar[index];
                    copy.add(n);
                    tempar[index]=copy;
                    }
                }

        }
        return tempar;

}


public void delete(Integer x)
{
    //delete x from its list
    int index = hf(x);
    LinkyLists l = ar[index];
    l.delete(x);

    ar[index]=l;
    nodes--;


    if(nodes < m/4-1){
        m=m/2;
        LinkyLists[] tempar= new LinkyLists[m];
        ar=tempar;
    }

    

}

 public int hf(int x)
    {
        return ((2*x + 5) % m);
    }

 public LinkyLists[] getAr()
 {
     return ar;
 }




    

}
