package TopicWiseProblems;

import java.util.*;

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

    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        // make adjacency list
        boolean visited [] = new boolean[n];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)
        {
            graph.add(new ArrayList<>());
        }
// adding the list into graph


        for(int edge[] : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }

        System.out.println("undriected graph -->"+graph);

// undirected graph

        Queue<Integer> node = new LinkedList<>();
        node.add(source);
        visited[source] = true;

// JGSG
        while(!node.isEmpty())
        {
            int node1 = node.poll();

            if(node1 == destination)
                return true;

            for(int nieghbour : graph.get(node1))
            {
                if(!visited[nieghbour])
                {

                    visited[nieghbour] = true;

                    node.add(nieghbour);

                }
            }

        }

        return false;


    }

    public int findCenter(int[][] edges) {
        // Determine max node value to size the graph correctly
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        // Build adjacency list for undirected graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= maxNode; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // BFS from any node (say edges[0][0])
        boolean[] visited = new boolean[maxNode + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(edges[0][0]);
        visited[edges[0][0]] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // If a node has n-1 connections, it’s the center
            if (graph.get(node).size() == edges.length) {
                return node;
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return -1; // Should never happen in valid star graph
    }







// find judge problem


    public int findJudge(int n, int[][] trust) {
        int start = 0;
        int end = n;
        int maxNode = 0;

        for(int []edge : trust)
            maxNode = Math.max(maxNode,Math.max(edge[0],edge[1]));


        // mark visisted nodes
        boolean [] visited = new boolean[maxNode + 1];

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i <= maxNode ; i++)
        {
            result.add(new ArrayList<>());
        }

        // make directed graph

        for(int edge[] : trust)
        {
            result.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> node = new LinkedList<>();
        visited[trust[0][0]] = true;
        node.add(trust[0][0]);

        while(!node.isEmpty())
        {
            int ans = node.poll();

            if(ans != 1 || ans != 2)
                return ans;

            for(int res : result.get(ans))
            {
                if(!visited[res])
                {
                    visited[res] = true;
                    node.add(res);

                }

            }

        }

        return -1;

    }


    public TreeNode cloneGraph(TreeNode node) {
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new TreeNode(node.val);

        HashMap<TreeNode, TreeNode> cp = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();

        cp.put(node, new TreeNode(node.val));
        qu.offer(node);

        while(!qu.isEmpty()) {
            TreeNode curr = qu.poll();
            for(TreeNode nei: curr.neighbors) {
                if(!cp.containsKey(nei)) {
                    cp.put(nei, new TreeNode(nei.val));
                    qu.add(nei);
                }
                cp.get(curr).neighbors.add(cp.get(nei));
            }
        }
        return cp.get(node);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int originalColor = image[sr][sc];

        if (originalColor == color) return image; // no need to process

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols &&
                        image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return image;

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        dfs(rooms,visited,0);

        for(boolean v : visited)
        {
            if(!v)
                return false;
        }

        return true;
    }


    public void dfs(List<List<Integer>> rooms,boolean [] visited,int key)
    {
        if(visited[key])
            return ;

        visited[key] = true;

        for(int k : rooms.get(key))
        {
            dfs(rooms,visited,k);
        }
    }

    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] min_rolls = new int[n * n + 1];
        Arrays.fill(min_rolls, -1);
        Queue<Integer> q = new LinkedList<>();
        min_rolls[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i <= 6 && x + i <= n * n; i++) {
                int t = x + i;
                int row = (t - 1) / n;
                int col = (t - 1) % n;
                int v = board[n - 1 - row][(row % 2 == 1) ? (n - 1 - col) : col];
                int y = (v > 0 ? v : t);
                if (y == n * n) return min_rolls[x] + 1;
                if (min_rolls[y] == -1) {
                    min_rolls[y] = min_rolls[x] + 1;
                    q.offer(y);
                }
            }
        }
        return -1;
    }


    int[][] dirs = new int[][]{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    int[][] grid;
    int m, n;

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        this.grid = grid;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, 1);
                    res = Math.max(res, dfs(i, j, 0, 2, false));
                    res = Math.max(res, dfs(i, j, 1, 2, false));
                    res = Math.max(res, dfs(i, j, 2, 2, false));
                    res = Math.max(res, dfs(i, j, 3, 2, false));
                }
            }
        }
        return res;
    }

    public int dfs(int i, int j, int dir, int target, boolean turned) {

        int x = i + dirs[dir][0], y = j + dirs[dir][1];
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != target) {
            return 1;
        }

        int straight = 1 + dfs(x, y, dir, target == 2 ? 0 : 2, turned);
        int turn = 0;
        if (!turned) {
            turn = 1 + dfs(x, y, (dir + 1) % 4, target == 2 ? 0 : 2, true);
        }


        return Math.max(straight, turn);
    }


    public int findCircleNum(int[][] isConnected) {
        int maxNode = 0;

        for(int [] edge : isConnected)
            maxNode = Math.max(maxNode,Math.max(edge[0],edge[1]));

        boolean visited[] = new boolean[maxNode + 1];

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i <= maxNode ; i++)
            result.add(new ArrayList<>());

        for(int []edge : isConnected)
            result.get(edge[0]).add(edge[1]);


        Queue<Integer> node = new LinkedList<>();
        visited[isConnected[0][0]] = true;
        node.add(isConnected[0][0]);
        int count = 0;

        while(!node.isEmpty())
        {
            int ans = node.poll();

            if(ans == 1)
                count++;

            for(int res : result.get(ans))
            {
                if(!visited[res] )
                {
                    visited[res] = true;
                    node.add(res);
                }
            }


        }

        return count;


    }

}
