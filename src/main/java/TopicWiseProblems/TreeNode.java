package TopicWiseProblems;

import java.util.*;

public class TreeNode
{
    public int val;
   public TreeNode left ;
   public TreeNode right ;
    public List<TreeNode> neighbors;

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


    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return checkValid(root,k,s);



    }

    public boolean checkValid(TreeNode root, int k,Set<Integer> s)
    {
        if(root == null)
            return false ;

        if(s.contains(k - root.val))
            return true;

        s.add(root.val);

        return checkValid(root.left,k,s)|| checkValid(root.right,k,s);


    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = Integer.MIN_VALUE;
        int level = 1, maxLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentSum += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            buildPaths(root, "", result);
        }
        return result;
    }

    private void buildPaths(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            // It's a leaf node, path is complete
            result.add(path + node.val);
        }

        if (node.left != null) {
            buildPaths(node.left, path + node.val + "->", result);
        }

        if (node.right != null) {
            buildPaths(node.right, path + node.val + "->", result);
        }
    }

// merge 2 binary trees

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    // Returns the height of the subtree rooted at node
    private int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Update diameter if path through current node is larger
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return height of the current node
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isSameTree2(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method to compare two trees
    private boolean isSameTree2(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;

        return isSameTree2(s.left, t.left) && isSameTree2(s.right, t.right);
    }

   // int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val >= low && root.val <= high)
            sum += root.val;

        if (root.val > low)
            rangeSumBST(root.left, low, high);

        if (root.val < high)
            rangeSumBST(root.right, low, high);

        return sum;


    }

    TreeNode prev = null; // To keep track of the last node
    TreeNode newRoot = null;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return newRoot;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Process current node
        if (prev == null) {
            newRoot = node;  // First (smallest) node becomes new root
        } else {
            prev.right = node;
        }
        node.left = null;  // Remove left child
        prev = node;       // Move the pointer

        inorder(node.right);

    }

    public int[] findMode(TreeNode root)
    {
        // Frequency map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        addMode(root, freqMap);

        // Find max frequency
        int maxFreq = 0;
        for (int freq : freqMap.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Collect all values with max frequency
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        // Convert list to array
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;

    }
    public void addMode(TreeNode root,HashMap<Integer,Integer> m)
    {
        if(root == null)
            return ;

        m.put(root.val,m.getOrDefault(root.val,0) + 1);

        addMode(root.left,m);
        addMode(root.right,m);



    }

    public static boolean isConsist(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        // If it's a leaf node
        if (root.left == null && root.right == null)
            return root.val == targetSum;

        // Otherwise, recurse down
        return isConsist(root.left, targetSum - root.val) ||
                isConsist(root.right, targetSum - root.val);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }

        // Build the current number
        current = current * 10 + node.val;

        // If it's a leaf, return the current path number
        if (node.left == null && node.right == null) {
            return current;
        }

        // Sum of left and right subtrees
        return dfs(node.left, current) + dfs(node.right, current);
    }

    public static class Node
    {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }


        public List<Integer> postorder(Node root) {
            // If the root is null, return an empty list
            if (root == null) return new ArrayList<>();

            List<Integer> res = new ArrayList<>();

            // Start DFS from the root
            dfs(root, res);

            // Return the result list containing node values in post-order
            return res;
        }

        private void dfs(Node root, List<Integer> res) {
            // Recursively call dfs for each child of the current node
            for (Node child : root.children) {
                dfs(child, res);
            }
            // Append the value of the current node to the result list
            res.add(root.val);
        }

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leaves1 = new ArrayList<>();
            List<Integer> leaves2 = new ArrayList<>();

            collectLeaves(root1, leaves1);
            collectLeaves(root2, leaves2);

            return leaves1.equals(leaves2);
        }

        private void collectLeaves(TreeNode node, List<Integer> leaves) {
            if (node == null) return;
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            }
            collectLeaves(node.left, leaves);
            collectLeaves(node.right, leaves);
        }

    }
    int min = Integer.MAX_VALUE;
    Integer prevv = null;  // store last visited node value

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder5(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prevv);
        }
        prevv = root.val;

        inorder(root.right);
    }


    public List<Integer> preorder(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        dfs(root,res);

        return res;

    }

    public void dfs(Node root,List<Integer> res)
    {
        res.add(root.val);

        for(Node child : root.children)
        {
            dfs(child,res);
        }


    }




    Stack<TreeNode> stack;
    public void BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        updateStack(node);                                      // update stack
    }
    public int next() {
        TreeNode toRemove = stack.pop();
        updateStack(toRemove.right);                             // before return node, first update stack further
        return toRemove.val;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    // -------------------
    public void updateStack(TreeNode node){
        while(node != null){
            stack.add(node);
            node = node.left;
        }
    }


    // univalued binary tree which has same value in all of the nodes
    public boolean isUnivalTree(TreeNode root) {
        return dfsForUniValuedTree(root, root.val);
    }

    private boolean dfsForUniValuedTree(TreeNode node, int val) {
        if (node == null) return true;
        if (node.val != val) return false;
        return dfsForUniValuedTree(node.left, val) && dfsForUniValuedTree(node.right, val);
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(sum / size);  // average for this level
        }

        return result;
    }


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null) return null;
        if(original==target) return cloned;
        TreeNode left= getTargetCopy(original.left,cloned.left,target);
        if(left!=null) return left;
        return getTargetCopy(original.right,cloned.right,target);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths starting from this node
        int count = dfsFromNode(root, targetSum);

        // Also count paths starting in left and right subtrees
        count += pathSum2(root.left, targetSum);
        count += pathSum2(root.right, targetSum);

        return count;
    }

    private int dfsFromNode(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == targetSum) {
            count++;
        }

        // Continue path down left and right
        count += dfsFromNode(node.left, targetSum - node.val);
        count += dfsFromNode(node.right, targetSum - node.val);

        return count;
    }



    class Solution {
        int moves = 0;

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return moves;
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;

            int left = dfs(node.left);
            int right = dfs(node.right);

            // Count moves needed for balancing children
            moves += Math.abs(left) + Math.abs(right);

            // Net balance to pass to parent
            return node.val + left + right - 1;
        }
    }
}
