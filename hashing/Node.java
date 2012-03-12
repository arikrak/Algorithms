/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hashing;

/**
 *
 * @author Ariel Krakowski
 */
public class Node {

    int data;
    Node nextNode;

    public Node(int d, Node whereToPointTo)
    {
        data=d;
        nextNode = whereToPointTo;
    }

    public void changeData(int change)
    {
        data=change;

    }

    public void changePointer(Node change)
    {
        nextNode=change;

    }

    public Node nextNode()
    {
        return nextNode;

    }

    public int getData()
    {
        return data;

    }





}
