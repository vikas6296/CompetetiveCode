package org.example;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeNode
{
    public int val;
   public TreeNode left ;
   public TreeNode right ;

    public TreeNode(int x)
    {
        this.val = x;
    }

    public static void preorder(TreeNode node)
    {
         if(node == null)
             return;

        System.out.println(node.val + " ");
         preorder(node.left);
         preorder(node.right);

    }

    public static void main (String s[])
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        /*root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);*/

       // preorderTraversal(node);

       // System.out.println(maximumPathSum(root));
        //System.out.println(pathSum(root,8));

       // System.out.println(invertTree(root));

    }

    static List<Integer> li = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root)
    {
        if(root != null)
            li.add(root.val);

        preorderTraversal(getValue(root.left,li));
        preorderTraversal(root.right);


        return li;
    }

    public static TreeNode getValue(TreeNode root ,List<Integer> li) {
        if (root != null) {
            li.add(root.val);
            return root;
        }

        return root;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        preorder1(root, res);
        return res;
    }

    private void preorder1(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        preorder1(node.left, res);
        preorder1(node.right, res);
    }



    public static List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> response = new ArrayList<>();

        postOrder(root,response);

        return response;


    }

    private static void postOrder(TreeNode root , List<Integer> response)
    {
        if(root == null)
            return;

        postOrder(root.left,response);
        postOrder(root.right,response);
        response.add(root.val);

    }

    public int countNodes1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans.size();
    }
    private void inorder(TreeNode root,List<Integer>ans){
        if(root == null)return;
        inorder(root.left,ans);

        ans.add(root.val);
        inorder(root.right,ans);
    }




    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (leftDepth == rightDepth) {
            // Left subtree is full (2^leftDepth - 1), count it + root + recurse on right
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // Right subtree is full, one level smaller than left
            return (1 << rightDepth) + countNodes(root.left);
        }
    }
    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }







    public List<Integer> preorderTraversal2(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        addNode(root,result);


        return result;
    }

    public void addNode(TreeNode root,List<Integer> result)
    {
        if(root == null)
            return ;

        result.add(root.val);
        addNode(root.left,result);
        addNode(root.right,result);


    }


    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        addNode1(root,result);

        return result;

    }

    public static void addNode1(TreeNode root,List<List<Integer>> result)
    {
        if(root == null)
            return ;

        result.add(new ArrayList<>(Arrays.asList(root.val)));
        addNode1(root.left,result);
        addNode1(root.right,result);


    }




    public static int maximumPathSum(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        postOrderTraversal2(root,result);

        return getMaximumSum(result);

    }

    public static void postOrderTraversal2(TreeNode root, List<Integer> result)
    {
        if(root == null)
            return ;

        postOrderTraversal2(root.left,result);
        postOrderTraversal2(root.right,result);
        result.add(root.val);

    }

    public static int getMaximumSum(List<Integer> result)
    {
        int max = 0;
        int sum = 0;
        for(int i : result)
        {
            sum = sum + i;

            max = Math.max(max,sum);

        }

        return max;
    }





    public static int maxSum = Integer.MIN_VALUE;

    public static int maximumPathSum1(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // Reset for each call
        maxGain(root);
        return maxSum;
    }

    private static int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max gain from left and right, ignoring negative paths
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Compute price of the path passing through this node
        int priceNewPath = node.val + leftGain + rightGain;

        // Update global max
        maxSum = Math.max(maxSum, priceNewPath);

        // Return max gain if continue the same path upwards
        return node.val + Math.max(leftGain, rightGain);
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);

        return leftSum || rightSum;
    }


    public static int pathSum(TreeNode root, int targetSum)
    {
        int count = 0;

        pathSumCount(root,targetSum,count);

        return count;
    }

    public static void pathSumCount(TreeNode root, int targetSum, int count )
    {
        if (root == null)
            return ;

        if(root.left == null && root.right == null)
        {
             if(targetSum == root.val)
                count++;
        }

     pathSumCount(root.left,targetSum - root.val,count);
      pathSumCount(root.right,targetSum - root.val,count);

    }


   

    public static  boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // Helper function to compute height and check balance
    private static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // height of empty tree
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // left subtree not balanced
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // right subtree not balanced
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // current node not balanced
        }

        // Return height if balanced
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        getInorder(root,result);
        return result;

    }

    public void getInorder(TreeNode root,List<Integer> result)
    {
        if(root == null)
            return ;

        getInorder(root.left,result);
        result.add(root.val);
        getInorder(root.right,result);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
      List<Integer> treeA = new ArrayList<>();
      List<Integer> treeB = new ArrayList<>();
        preorderTraversal6(p,treeA);
        preorderTraversal6(q,treeB);

        if(treeA.size() != treeB.size())
            return false;

        else
        {
            for (int i = 0 ; i < treeA.size(); i++)
            {
                if(treeA.get(i) != treeB.get(i))
                    return false;
            }


        }

        return true;
    }

    public void preorderTraversal6(TreeNode root,List<Integer> result)
    {
        if(root == null)
            return;

        result.add(root.val);
        preorderTraversal6(root.left,result);
        preorderTraversal6(root.right,result);

    }


    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static List<List<Integer>> pathSum1(TreeNode root, int targetSum)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        getPathSum(root,targetSum,result,paths);

        return result;
    }
    public static void getPathSum(TreeNode root, int targetSum,List<List<Integer>> result, List<Integer> paths)
    {
        if(root == null)
            return ;

        paths.add(root.val);

        if(root.left == null && root.right == null && root.val == targetSum)
            result.add(new ArrayList<>(paths));

        else
        {
            getPathSum(root.left,targetSum - root.val , result,paths);
            getPathSum(root.right,targetSum - root.val, result,paths);

        }

        // backtrack for DFS

        paths.remove(paths.size() - 1);

    }

// 

    public static boolean isSymmetric(TreeNode node)
    {
        if(node == null)
            return true ;

        return isMirror(node.left,node.right);

    }

    public static boolean isMirror(TreeNode A, TreeNode B)
    {
        if(A == null && B == null)
            return  true;

        if(A == null || B == null)
            return false;

        return (A.val == B.val) && isMirror(A.left,B.right) && isMirror(A.right,B.left);

    }

    public static void levelOrder1(TreeNode root)
    {
        int h = hieghtOfTree1(root);

        for(int i = 1; i <= h ; i++)
        {
            printLevel(root,i);
        }
    }
    public static int hieghtOfTree1(TreeNode root)
    {
        if(root == null)
            return  0;

        int left = hieghtOfTree1(root.left);
        int right = hieghtOfTree1(root.right);

        return Math.max(left,right) + 1;

    }

    public static void printLevel(TreeNode root,int level)
    {
        if(root == null)
            return;
        if(level == 1)
            System.out.println(root.val + " ");

        else {
            printLevel(root.left, level - 1);

            printLevel(root.right, level - 1);
        }
    }

    // convert array  to binary search tree

    public TreeNode convert(int []nums,int left,int right)
    {
        if(left > right)
            return null;

        int mid = left + (right - left) /2 ;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = convert(nums,left, mid - 1);
        node.right = convert(nums,mid + 1,right);

        return node;

    }

// level order traversal binary tree
public List<List<Integer>> levelOrder2(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    int h = hieghtOfTree(root);

    for(int i = 1; i <= h; i++) {
        List<Integer> levelNodes = new ArrayList<>();
        addLevel(root, i, levelNodes);
        result.add(levelNodes);
    }

    return result;
}

    public int hieghtOfTree(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = hieghtOfTree(root.left);
        int right = hieghtOfTree(root.right);

        return Math.max(left,right) + 1;

    }

    public static void addLevel(TreeNode root, int level, List<Integer> levelNodes)
    {
        if(root == null)
            return;

        if(level == 1) {
            levelNodes.add(root.val);
        } else {
            addLevel(root.left, level - 1, levelNodes);
            addLevel(root.right, level - 1, levelNodes);
        }

    }

    public  static TreeNode invertTree(TreeNode root)
    {
        if(root == null)
            return root;

        TreeNode node = new TreeNode(root.val);

        node.right = invertTree(root.left);
        node.left = invertTree(root.right);

        return node;
    }

    public static int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right) + 1;

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int sum = 0;

        // If left child exists
        if (root.left != null) {
            // If left child is a leaf, add its value
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                // Otherwise, recurse on the left child
                sum += sumOfLeftLeaves(root.left);
            }
        }

        // Always recurse on the right child
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    private int sum = 0;
    private void rec(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            if (isLeft) {
                sum += root.val;
            }

            return;
        }

        rec(root.left, true);
        rec(root.right, false);
    }



}
