package org.example;

public class DivideAndConquer
{
    public static int longestSubstring(String s, int k) {
        // Base case
        if (s.length() == 0 || k > s.length()) return 0;

        // Count characters
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Go through string and split on invalid characters
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] < k) {
                // Split and apply same logic to left and right
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
        }

        // If all characters are valid (≥ k), return length
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));    // Output: 3 ("aaa")
        System.out.println(longestSubstring("ababbc", 2));   // Output: 5 ("ababb")
    }
}
