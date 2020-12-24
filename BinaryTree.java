class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
class BinaryTree  
{ 
    Node root;
   
    void showDistanceNodeDown(Node node, int k)  
    { 
        
        if (node == null || k < 0) 
            return; 
   
      
        if (k == 0)  
        { 
            System.out.print(node.data); 
            System.out.println(""); 
            return; 
        } 
   
        showDistanceNodeDown(node.left, k - 1); 
        showDistanceNodeDown(node.right, k - 1); 
    } 
  
    int showDistanceNode(Node node, Node target, int k)  
    { 
        if (node == null) 
            return -1; 
   
       
        if (node == target)  
        { 
            showDistanceNodeDown(node, k); 
            return 0; 
        } 
   
      
        int dl = showDistanceNode(node.left, target, k); 
   
       
        if (dl != -1)  
        { 
               
          
            if (dl + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            }
            else
                showDistanceNodeDown(node.right, k - dl - 2); 
            return 1 + dl; 
        } 
        int dr = showDistanceNode(node.right, target, k); 
        if (dr != -1)  
        { 
            if (dr + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            }  
            else 
                showDistanceNodeDown(node.left, k - dr - 2); 
            return 1 + dr; 
        } 
        return -1; 
    } 
 
    public static void main(String args[])  
    { 
        BinaryTree tree = new BinaryTree(); 
  
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        Node target = tree.root.left.right; 
        tree.showDistanceNode(tree.root, target, 2); 
    } 
} 