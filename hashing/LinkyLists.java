/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hashing;

/**
 *
 * @author Ariel Krakowski
 */
public class LinkyLists {
    
    Node firstNode;
    int length=0;


    public void add(int d)
    {
        if(firstNode==null){
            firstNode= new Node(d, null);
        }
        else{
        Node nod = new Node(d, firstNode);
        firstNode = nod;
        }

        length++;

    }

    public boolean delete(int d)
    {
            if(firstNode.getData()==d){
            firstNode=firstNode.nextNode();
            length--;
            return true;
            }
            Node check=firstNode.nextNode();
            Node lastNode = firstNode;
            while(check!=null){
            if(check.getData()==d){
                lastNode.changePointer(check.nextNode());
                length--;
                return true;
            }
            else{
                lastNode=check;
                check = check.nextNode();
            }

        }
            return false;

    }

    public boolean isEmpty()
    {
        //can also check firstNode
        return (length==0);
    }

    public boolean isThere(int d)
    {
            Node check=firstNode;
            while(check!=null){
            if(check.data==d){
                return true;
            }
            else{
                check= check.nextNode();
            }

        }
            return false;
    }

    public void printList()
    {
        Node check = firstNode;
        while(check!=null){
            System.out.print(check.getData()+ " ");

            check = check.nextNode();
        }

    }
    
    public int getLength()
    {
        return length; 
    }

    public Integer[] toArray()
    {
        int i=0;
        Integer[]arr = new Integer[length];
        Node check = firstNode;
        while(check!=null){
            arr[i]=check.getData();
            i++;
            check = check.nextNode();
        }
        return arr;
    }




}
