
package hashing;

/**
 *
 * @author Ariel Krakowski
 */

import java.io.*;
import java.util.Scanner;

//import java.util.LinkedList;

//import java.util.Iterator;

public class Input {

    Scanner in;
    File text;
    Hasher3 ha;
    Chainingcopy chainHashTable;

    public Input() throws FileNotFoundException {

        in = new Scanner(new File("C:\\Downloads\\sample5.txt"));
        ha = new Hasher3();
        chainHashTable = new Chainingcopy();
        getAllInputAndCallMethods();

    }

    public void getAllInputAndCallMethods()
    {

        while (in.hasNext()) {

            String word = in.next();    
            // check if word is INS DEL or PRT
          

            
            if (word.equals("PRT")) {
                //System.out.print(word);
                printOut();
            }
            else {
                int key = in.nextInt();


                if (word.equals("INS")) {
                    //System.out.print(word);

                    ha.insert(key);
                    chainHashTable.insert(key);
                }

                else if (word.equals("DEL")) {
                   // System.out.print(word);
                    
                ha.delete(key);
                chainHashTable.delete(key);
                }

            }

        }


        System.out.println( " \n Double Hashing collisions: " + ha.getDcollide());
        System.out.println(" \n Quadratic hashing collisions: " + ha.getQcollide());
        


    }

    public void printOut()
    {
        try{
            PrintStream out = new PrintStream(new FileOutputStream("C:\\Downloads\\output.txt"));
            //print stuff
            out.println(" ");
            out.println("--Quadratic Function Open Addressing: ");
            Integer ar[] = ha.getAr();

            for(Integer i: ar){
                if(i!=null && i!=-2147483647){
                   //i=(int) i;
                out.print(i + " ");
                System.out.print(i + " ");
                }
            }

            out.println(" ");
            out.println("--Double Hashing: ");
            Integer dar[] = ha.getDar();
            for (Integer i:dar){
                if(i!=null && i!=-2147483647){
                out.print(i + " ");
                System.out.print(i + " ");
                }
            }

            //Print Chaining
            out.println(" ");
            out.println("--HashTable with Linked lists: ");
            LinkyLists[] al = chainHashTable.getAr();
            for(LinkyLists l: al){
                Integer[] arr = l.toArray();
                for(Integer n: arr){
                if(n!=null){
                out.print(n+" ");
                System.out.print(n+" ");
                }
                }

            }

             out.close();
            } 
        
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
         
    }



}




