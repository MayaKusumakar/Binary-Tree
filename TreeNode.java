public class TreeNode{
   private Comparable val;
   private TreeNode left;
   private TreeNode right;
   
   public TreeNode(Comparable val)
   {
      this.val = val;
      left = right = null;
   }
   
   public TreeNode(Comparable val, TreeNode l, TreeNode r){
      this.val = val;
      left = l;
      right = r;
   }
   
   public Comparable getVal(){
      return val;
   }
   
   public TreeNode getLeft(){
      return left;
   }
   
   public TreeNode getRight(){
      return right;
   }
   
   public void setVal(Comparable v){
      this.val = v;
   }
   
   public void setRight(TreeNode r){
      this.right = r;
   }
   
   public void setLeft(TreeNode l){
      this.left = l;
   }
   
   public String toStrng()
   {
      return val+"";
   }
}