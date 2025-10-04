package TopicWiseProblems;

public class TrieNode
{
    public static void main(String []a)
    {
        longestDupSubstring1("banana");
    }
    TrieNode[] children = new TrieNode[26];

    public String longestDupSubstring(String S) {
        int n = S.length();
        TrieNode root = new TrieNode();
        int maxLen = 0;
        int startIndex = 0;

        // Insert all suffixes into Trie
        for (int i = 0; i < n; i++) {
            int matched = insert(root, S, i);
            if (matched > maxLen) {
                maxLen = matched;
                startIndex = i;
            }
        }

        return S.substring(startIndex, startIndex + maxLen);
    }

    // Insert suffix starting at index `start`, return length of matched prefix
    private int insert(TrieNode root, String s, int start) {
        TrieNode node = root;
        int matched = 0;

        for (int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
                // First mismatch found → stop further duplicate checking
                return matched;
            }
            node = node.children[idx];
            matched++;
        }

        return matched;
    }



    public static String longestDupSubstring1(String S) {
        class Trie {
            Trie[] children;
            final int startPos;
            final int depth;

            Trie(int startPos, int depth) {
                this.startPos = startPos;
                this.depth = depth;
            }
            boolean isLeaf(){
                return children == null;
            }
            int childIndex(int start) {
                return S.charAt(start + depth) - 'a';
            }
            int addNew(int start) {
                if (start + depth == S.length())
                    return depth;
                if (isLeaf()) {
                    children = new Trie[28];
                    children[childIndex(startPos)] = new Trie(startPos, depth+1);
                }
                int newIndex = childIndex(start);
                Trie child = children[newIndex];
                if (child == null) {
                    children[newIndex] = new Trie(start, depth + 1);
                    return depth;
                }
                return child.addNew(start);
            }
            public static void main(String []a)
            {
                System.out.println("value of trie start -->");
            }
        }
        int maxStart = 0, maxLength = 0;
        int length = S.length();
        Trie root = new Trie(0,0);
        for (int i=1; i+maxLength < length; ++i) {
            int len = root.addNew(i);
            if (len > maxLength) {
                maxLength = len;
                maxStart = i;
            }
        }
        return S.substring(maxStart, maxStart + maxLength);
    }
}
