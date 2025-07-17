package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph extends TreeNode {
    public Graph(int x) {
        super(x);
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        String r = "";
        Queue<String> q = new LinkedList<>();
        for (q.add(""); !q.isEmpty(); ) {
            String c = q.poll();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String n = c + ch;
                if (isK(n, s, k)) {
                    r = n;
                    q.add(n);
                }
            }
        }
        return r;
    }

    boolean isK(String s, String t, int k) {
        int c = 0, i = 0;
        for (char ch : t.toCharArray()) {
            if (ch == s.charAt(i)) {
                if (++i == s.length()) {
                    i = 0;
                    if (++c == k) return true;
                }
            }
        }
        return false;
    }

    static public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            solve(i, n, ans);
        return ans;
    }

    static void solve(int prod, int n, List<Integer> ans) {
        if (prod > n) return;
        ans.add(prod);
        for (int j = 0; j < 10; j++) {
            int next = prod * 10 + j;
            if(next > n) return;
            solve(next, n, ans);
        }
    }


    public boolean validTree(int n , int [][]edges)
    {
        if(edges.length != n - 1)
            return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ;i < n ; i++)
            graph.add(new ArrayList<>());

        for(int []edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }

        boolean [] visited = new boolean[n];

        if(!dfs(0,-1,visited,graph))
            return false;

        for(boolean v : visited)
        {
            if(!v)
                return false;
        }
        return true;
    }

    private boolean dfs(int node,int parent, boolean[] visited,List<List<Integer>> graph)
    {
        if(visited[node])return false;

        visited[node] = true;
        for(int niegh : graph.get(node))
        {
            if(niegh == parent)
                continue;
            if(!dfs(niegh,node,visited,graph))
                return false;

        }
        return true;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }

    public int numIslands(char[][] grid)
    {
        if(grid == null || grid.length == 0 )
            return 0;

      int m = grid.length;
      int n = grid[0].length;
      int count = 0;

   int [][] dir ={{0,1}, {1,0}, {0,-1}, {-1,0}};

   for(int i = 0 ; i < m ; i++)
   {
       for(int j = 0 ; j < n ; j++)
       {
           if(grid[i][j] == '1')
           {
               count++;

               Queue<int[]> result = new LinkedList<>();
               result.offer(new int []{i,j});
               grid[i][j] = '0';

               while(!result.isEmpty())
               {
                   int [] cell = result.poll();

                   int x = cell[0];
                   int y = cell[1];

                   for(int [] d : dir)
                   {
                       int nx = x + d[0];
                       int ny = y + d[1];

                       if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1')
                       {
                           result.offer(new int []{nx,ny});
                           grid[nx][ny] = '0'; // mark visited
                       }


                   }




               }



           }

       }

   }


return count;
    }






}
