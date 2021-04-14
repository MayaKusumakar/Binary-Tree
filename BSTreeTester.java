import java.io.*;
import java.util.*;

public class BSTreeTester
{
   public static void main(String[] args)
   {
      BSTree bs = new BSTree();
      bs.add(100);
      bs.add(50);
      bs.add(150);
      bs.add(65);
      bs.add(400);
      bs.add(30);
      bs.add(40);

      bs.inOrder();
      System.out.println();
      bs.preOrder();
      System.out.println();
      bs.postOrder();
      System.out.println();
      bs.reverseOrder();
      System.out.println();


      System.out.println(bs.getNumLevels());
      System.out.println(bs.getHeight());
      System.out.println(bs.getLargest());
      System.out.println(bs.getSmallest());

      System.out.println("Contains 400: "+bs.contains(400));
      System.out.println("Contains 130: "+bs.contains(130));
      System.out.println("Contains 65: "+bs.contains(65));

      System.out.println("Nodes: "+bs.getNumNodes());
      System.out.println("Leaves: "+bs.getNumLeaves());

      bs.remove(50);
      bs.preOrder();
      System.out.println();
      bs.levelOrder();
   }
}