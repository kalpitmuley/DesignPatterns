package ATS.Completed;

// { Driver Code Starts

import java.util.Arrays;
import java.util.Scanner;

class InorderPostorderToTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            TreeNode root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }
}
// } Driver Code Ends


/* Tree node structure
class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;

        TreeNode(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/

// Function should construct tree and return
// root of it.  in[] stores inorder traversal
// post[] stores postorder traversal.  n is
// size of these arrays
class GfG {
    // Complete the function
    TreeNode buildTree(int[] in, int[] post, int n) {
        TreeNode root = null;
        if (n == 1) {
            root = new TreeNode(in[0]);
            if (in[0] != post[0])
                root.right = new TreeNode(post[0]);
        }
        if (n > 1) {
            root = new TreeNode(post[n - 1]);
            int i = 0;
            while (in[i] != post[n - 1]) i++;
            int lSize = i;
            int rSize = n - (i + 1);
            root.left = buildTree(Arrays.copyOfRange(in, 0, lSize)
                    , Arrays.copyOfRange(post, 0, lSize), lSize);
            root.right = buildTree(Arrays.copyOfRange(in, lSize + 1, n)
                    , Arrays.copyOfRange(post, lSize, n - 1), rSize);
        }
        return root;
    }
}
