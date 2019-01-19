class tree
{
    
    int key;
    int sum;
    tree left;
    tree right;
    int toBeZero = 0;
    static int count;
    tree(int key)
    {
        this.key = key;
        left = right = null;
    }
    
    tree()
    {
    }
    
    // Left Root Right
    void inorder(tree root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
        
    }
    
    // Left Right Root 
    void postorder(tree root)
    {
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
    }
    
    // Root Left Right
    void preorder(tree root)
    {
        if(root==null)
            return;
        System.out.print(root.key + " ");
        sum=sum+root.key;
        preorder(root.left);
        preorder(root.right);
    }
    
    int maxHeight(tree root)
    {
        if(root==null)
            return 0;
        else
        {
            int leftHeight = maxHeight(root.left);
            int rightHeight = maxHeight(root.right);
            
            if(leftHeight>rightHeight)
                return leftHeight+1;
            else
                return rightHeight+1;
        }
    }
    
    void printNodeByLevels(tree root)
    {
        for(int i = 1 ; i <= maxHeight(root) ; i++)
        {
            levelOrder(root,i);
        }
    }
    
    void printNodeByLevelsinReverse(tree root)
    {
        for(int i = maxHeight(root) ; i >=1  ; i--)
        {
            levelOrder(root,i);
        }
    }
    
    void levelOrder(tree root, int i)
    {
        if(root == null)
            return;
        if(i==1)
            System.out.print(root.key + " ");
        else if(i>1)
        {
            levelOrder(root.left,i-1);
            levelOrder(root.right,i-1);
        }
    }
    
    void printNodeByLevelsinSpiral(tree root)
    {
        boolean b = false;
        for(int i = 1 ; i <= maxHeight(root) ; i++)
        {
            spiralOrder(root,i,b);
            b = !b;
        }
    }
    
    void spiralOrder(tree root, int i, boolean bl)
    {
        if(root == null)
            return;
        if(i==1)
            System.out.print(root.key + " ");
        else if(i>1)
        {
            if(bl==true)
            {
                spiralOrder(root.left,i-1,bl);
                spiralOrder(root.right,i-1,bl);
            }
            else
            {
                spiralOrder(root.right,i-1,bl);
                spiralOrder(root.left,i-1,bl);
            }
        }
    }
    
    void countNodesAtLevel(tree root, int height)
    {
        if(root == null)
            return;
        if(height == 1)
            count++;
        if(height>1)
        {
            countNodesAtLevel(root.left,height-1);
            countNodesAtLevel(root.right,height-1);
        }
    }
    
    void NthNodeAtHeight(tree root, int height, int n)
    {
        if(root == null)
            return;
        if(height == 1)
        {
            toBeZero++;
            if(n == toBeZero)
                System.out.println(root.key);
        }
        if(height>1)
        {
            NthNodeAtHeight(root.left,height-1, n);
            NthNodeAtHeight(root.right,height-1, n);
        }
    }
    
    public static void main(String args[])
    {
        
        tree obj = new tree();
        tree node1 = new tree(1);
        tree node2 = new tree(2);
        tree node3 = new tree(3);
        tree node4 = new tree(4);
        tree node5 = new tree(5);
        tree node6 = new tree(6);
        tree node7 = new tree(7);
        tree node8 = new tree(8);
        tree node9 = new tree(9);
        tree node10 = new tree(10);
        tree node11 = new tree(11);
        tree node12 = new tree(12);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node9;
        node3.right = node5;
        node4.left = node8;
        node4.right = node7;
        node5.left = node6;
        node5.right = node10;
        node6.left = node11;
        node8.left = node12;
        
        /*
                    1 
                   / \
                  2   3
                 / \   \
                4   9   5
               / \     / \
              8   7   6   10
             /       /
            12      11
        */  
        
        System.out.println("Tree Created Successfully");
        System.out.print("preorder  ");
        obj.preorder(node1);
        System.out.print("\npostorder  ");
        obj.postorder(node1);
        System.out.print("\ninorder  ");
        obj.inorder(node1);
        System.out.print("\nsum of all nodes   "+obj.sum);
        System.out.print("\nHeight   ");
        System.out.print(obj.maxHeight(node1));
        System.out.print("\nLevel Order   ");
        obj.printNodeByLevels(node1);
        System.out.print("\nSpiral Order  ");
        obj.printNodeByLevelsinSpiral(node1);
        obj.countNodesAtLevel(node1,obj.maxHeight(node1));
        System.out.print("\nNumber of Nodes at Last Level is : " + obj.count + "\n");
        
        //for finding deepest node from the right, the Only algorithm is LevelOrder Traversal
        System.out.print("deepest node from the right is : ");
        obj.NthNodeAtHeight(node1,obj.maxHeight(node1),obj.count);
        //for finding deepest node from the left, the Only algorithm is LevelOrder Traversal
        System.out.print("deepest node from the left is : ");
        obj.toBeZero = 0;
        obj.NthNodeAtHeight(node1,obj.maxHeight(node1),1);
        
        System.out.print("Bottom Up Traversal of Tree : ");
        obj.printNodeByLevelsinReverse(node1);
        
    }

}
