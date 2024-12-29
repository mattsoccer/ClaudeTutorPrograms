// Node class to represent tree nodes
class Node {
    int data;
    Node left, right;
    
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    
    // Method to print level order traversal
    public void printLevelOrder() {
        if (root == null) return;
        
        // Create a queue for level order traversal
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        queue.add(null);  // null marks end of current level
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current == null) {
                if (!queue.isEmpty()) {
                    System.out.println();  // Move to next line for next level
                    queue.add(null);  // Mark end of next level
                }
            } else {
                System.out.print(current.data + " ");
                
                if (current.left != null)
                    queue.add(current.left);
                    
                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Create the binary tree from the example
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        
        System.out.println("Level Order traversal of binary tree is:");
        tree.printLevelOrder();
    }
}