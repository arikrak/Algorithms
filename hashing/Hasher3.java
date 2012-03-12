/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * h(x) = (2x + 5) mod M
 *
 */

package hashing;

/**
 *
 * @author Ariel Krakowski
 */
public class Hasher3 {

    Integer ar[];  //or just pass by method
    Integer dar[];

    Integer temp[];
    Integer tempd[];    

    int m;
    int load;

    int dcollide;
    int qcollide;

    public Hasher3()
    {
        ar = new Integer[8];  //set to 8
        dar = new Integer[8];
        m = ar.length;
        load =0;

        dcollide =0;
        qcollide=0;
    }


    public void insert(int key)    //array?
    {

        ar = quadInsert(ar, key);
        dar = doubleInsert(dar, key);
        load++;


        //first check size of table
        if(load>m/2){
            //double size
            m = m*2;
            temp  = new Integer[m];   // ar[m]
            tempd = new Integer[m];

            //rehash
            for(Integer k: ar){
                if(k!=null){
                temp = quadInsert(temp, k);
                }
            }
            ar = temp;

            for(Integer k: dar)
            {
                if(k!=null){
                    tempd=doubleInsert(tempd, k);
                }
            }
            dar = tempd;

        }

    }

    public Integer[] quadInsert(Integer[] array, int k)
    {
        int i=0;
        int q =0;
        do{
            q = ( hf(k) + 7*i + 4*i*i)%m;  //c1 & c2?
            i++;            
        }while(array[q]!=null && array[q]!=-2147483647 ); //&& i<array.length
        qcollide=qcollide+i;
        array[q]=k;
        System.out.print(k+" ");
        return array;

    }

    public Integer[] doubleInsert(Integer[] array, int k)
    {
        int i=0;
        int q=0;
        do{
        q = (hf(k) + i*(1+k%11) )%m;   //formula
        i++;
        }while(array[q]!=null && array[q]!=-2147483647 && i<array.length  );
        dcollide = dcollide+i;
        array[q]=k;
        return array;

    }


    public int hf(int key)  //int i
    {
        return (2*key + 5) % m;
    }


    public void delete(int key)
    {
        ar = quadDelete(ar, key);
        dar = doubleDelete(dar, key);
        load--;
        
        
         if(load< (m/4) && load>16){
            //split size
            m=m/2+1;
            temp = new Integer[m];
            tempd = new Integer[m];

            //rehash

               for(Integer k: ar){
                if(k!=null){
                    temp = quadInsert(temp, k);
                }
            }
            ar = temp;
            
            for(Integer k: dar)
            {
                if(k!=null){
                tempd=doubleInsert(tempd, k);
            }
            }
            dar = tempd;

        }

    }

    public Integer[] quadDelete(Integer[] array, int k)
    {
        int i =0;
        int q=0;
        Integer val=0;
            do{
                q = ( hf(k) + 4*i + 7*i*i)%m;  //check equation - circular if all  by 0?
                i++;               
                val = array[q];
            }while(val!=null&&val!=k ||val==null ); //&& i<array.length
                //if(val==k){
                array[q]= -2147483647;
               
            
        return array;
    }

    public Integer[] doubleDelete(Integer[] array, int k)
    {
        int i =0;
        int q=0;
        do{  //
            q = (hf(k) + i*(1+k%11) )%m;
            i++;
            }while(array[q]!=k && i<array.length);
            if(array[q]==k)
                array[q]= -2147483647;
            
        
        return array;
    }

    public Integer[] getAr()
    {
        return ar;
    }

    public Integer[] getDar()
    {
        return dar;
    }

    public int getDcollide()
    {
        return dcollide;

    }

    public int getQcollide()
    {
        return qcollide;

    }





}
