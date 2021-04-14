import java.util.*;
public class BSTree{
   TreeNode root;
   
   public BSTree(){
      root = null;
   }
   
   public void add(Comparable val){
      root = add(root, val);
   }
   
   public TreeNode getRoot(){
      return root;
   }
   
    
   private TreeNode add(TreeNode node, Comparable val){
      if(node == null)
      {
         node = new TreeNode(val, null, null);
         return node;
      }
      
      int dirTest = node.getVal().compareTo(val);
      
      if(dirTest<0)
         node.setRight(add(node.getRight(), val));
      else
         node.setLeft(add(node.getLeft(), val));
         
      return node;
   }
   
   public int getNumNodes(){
      return getNumNodes(root);
   }
   
   private int getNumNodes(TreeNode t){
      if(t == null)
         return 0;
       
      return 1 + getNumNodes(t.getLeft())+getNumNodes(t.getRight());
   }
   
   public void inOrder(){
      inOrder(root);
   }
   
   private void inOrder(TreeNode node){
      if(node != null){
      inOrder(node.getLeft());
      System.out.print(node.getVal() + " ");
      inOrder(node.getRight());
      }
      
   }
   
   public Comparable getSmallest(){
      return getSmallest(root).getVal();
   }
   
   private TreeNode getSmallest(TreeNode t){
      if(t == null){
         return null;
      }
      if ( t.getLeft()== null)
         return t;
      
      return getSmallest(t.getLeft());
   }
   
   
   private boolean isLeaf(TreeNode node){
      if(node == null)
         return false; 
      if(node.getRight() == null && node.getLeft() == null)
         return true;
      return false;
         
   }
   
   public int getNumLeaves(){
      return getNumLeaves(root);
   }
   
   private int getNumLeaves(TreeNode t){
      if(t == null)
         return 0;
      if(t.getLeft() == null && t.getRight() == null)
         return 1 + getNumLeaves(t.getLeft())+getNumLeaves(t.getRight());;
      return 0 + getNumLeaves(t.getLeft())+getNumLeaves(t.getRight());
   }
   
   
   public void postOrder(){
      postOrder(root);
   }
   
  private void postOrder(TreeNode node){
   if(node != null){
      postOrder(node.getLeft());
      postOrder(node.getRight());
      System.out.print(node.getVal() + " ");   
      }
      
  }
   
   public void reverseOrder(){
      reverseOrder(root);
      //RPL
   }
   
   private void reverseOrder(TreeNode node){
      if(node != null){
         reverseOrder(node.getRight());
         System.out.print(node.getVal() + " ");   
         reverseOrder(node.getLeft());
      }
      
   }
   
   public void levelOrder(){
      levelOrder(root);
   }
   
   private void levelOrder(TreeNode node){
      ArrayList<TreeNode> ar = new ArrayList<TreeNode>();
      ar.add(node);
      TreeNode temp;
      while(ar.size() > 0){
         temp = ar.remove(0); 
         System.out.print(temp.getVal() + " ");
         if(temp.getLeft() != null){
            ar.add(temp.getLeft());
         }
         if(temp.getRight() != null){
            ar.add(temp.getRight());
         }     
      } 
   }
   
   public int getNumLevels(){
      return getNumLevels(root);
   }
   
   private int getNumLevels(TreeNode t){
      if(t == null)
         return 0;
      return 1 + Math.max(getNumLevels(t.getLeft()), getNumLevels(t.getRight()));
   }
   
   public int getWidth(){
      return getWidth(root);
   }
   
   private int getWidth(TreeNode t){
      if(t == null)
         return 0;
      
      return 1 + getWidth(t.getLeft()) + getWidth(t.getRight());
   }
   public boolean isFull(){
      return isFull(root);
   }
   
   private boolean isFull(TreeNode t){
      if(t == null)
         return true;
         
      if(t.getLeft() == null && t.getRight() == null)
         return true;
         
      if(t.getLeft() != null && t.getRight() != null)
         return isFull(t.getRight()) && isFull(t.getLeft());
      
      return false;
   }
   
   public Comparable getLargest(){
      return getLargest(root).getVal();
   }
   
   private TreeNode getLargest(TreeNode node){
      if(node == null)
         return null;
      if(node.getRight() == null)
         return node;
       
      return getLargest(node.getRight());
   
   }
   public String toString(){
      //recursive in order but generates a string
      
      return toString(root);
   }
   private String toString(TreeNode node){
      if(node == null)
         return "";   
      return toString(node.getLeft()) + node.getVal() +" "+ toString(node.getRight());
   }
  
   
   public void remove(Comparable val){
      remove(root, val);
   }
   
   private TreeNode remove(TreeNode t, Comparable val){
      if(t != null){
         int dirTest = t.getVal().compareTo(val);
         if(dirTest<0){
           t.setRight(remove(t.getRight(), val));
         }else if (dirTest > 0){
            t.setLeft(remove(t.getLeft(), val));
         }
         else {
            if(t.getRight() == null){
               return null;
            }
            else{
               TreeNode n = getSmallest(t.getRight());
               t.setVal(n.getVal());
               t.setRight(remove(t.getRight(), n.getVal()));
         }
         }    
        }  
        return t;
   }
   
   public void preOrder(){
      preOrder(root);
   }
   
   public void preOrder(TreeNode t){
      if(t != null){
         System.out.print(t.getVal() + " ");
         preOrder(t.getLeft());
         preOrder(t.getRight());
      }
    }
   
   public boolean contains(Comparable val){
      return contains(val, root);
   }
   
   public int getHeight(){
      return getHeight(root);
   }
   
   private int getHeight(TreeNode t){
      if(t == null)
         return 0;
      if(t == root)
         return 0 + Math.max(getHeight(t.getLeft()),getHeight(t.getRight()));
      
      return 1 + Math.max(getHeight(t.getLeft()),getHeight(t.getRight()));
   }
   
   private boolean contains(Comparable val, TreeNode t){
      if(t == null)
         return false;
      
      if(t.getVal().compareTo(val) == 0)
         return true;
      
      int dir = t.getVal().compareTo(val);
      if(dir < 0)
         return contains(val, t.getRight());
      else
         return contains(val, t.getLeft());
   }
   
   
   public String go(){
      return go(root);
   }
   
   private String go(TreeNode tree){
    if(tree==null)
   return "";
return "" + tree.getVal() + " " +
        go(tree.getLeft())+ go(tree.getRight());

   }
   public static void main(String[] args){
      BSTree bs = new BSTree();
      bs.add(45);
      bs.add(43);
      bs.add(78);
      bs.add(29);
      
      System.out.println(bs.go());
      bs.preOrder();
   }
   
}