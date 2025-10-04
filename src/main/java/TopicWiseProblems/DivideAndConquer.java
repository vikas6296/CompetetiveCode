package TopicWiseProblems;

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



    private static int findMaxIndex(int[][] arr, int col) {
        int maxRow = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][col] > arr[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }

    public static int[] findPeak2D(int[][] arr, int startCol, int endCol) {
        int midCol = (startCol + endCol) / 2;

        // Find max element in this column
        int maxRow = findMaxIndex(arr, midCol);
        int maxElement = arr[maxRow][midCol];

        // Get neighbors (left & right)
        int left = (midCol - 1 >= startCol) ? arr[maxRow][midCol - 1] : Integer.MIN_VALUE;
        int right = (midCol + 1 <= endCol) ? arr[maxRow][midCol + 1] : Integer.MIN_VALUE;

        // Check if it's a peak
        if (maxElement >= left && maxElement >= right) {
            return new int[]{maxRow, midCol, maxElement}; // row, col, value
        }

        // Recurse on the side with bigger neighbor
        if (left > maxElement) {
            return findPeak2D(arr, startCol, midCol - 1); // search left half
        } else {
            return findPeak2D(arr, midCol + 1, endCol);   // search right half
        }
    }
}
