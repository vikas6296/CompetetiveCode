package TopicWiseProblems;

public class RollingHash {

    public String shortestPalindrome(String s) {
        int n = s.length();
        int end = n;

        // Find the longest prefix palindrome
        while (end > 0) {
            if (isPalindrome(s, 0, end - 1)) {
                break;
            }
            end--;
        }

        // Reverse the suffix and prepend
        String suffix = s.substring(end);
        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public String shortestPalindromeRollingHash(String s) {
        int n = s.length();
        long mod = 1_000_000_007;
        long base = 131;

        long forward = 0, backward = 0, power = 1;
        int best = -1;

        for (int i = 0; i < n; i++) {
            int val = s.charAt(i);

            // forward hash (like left → right)
            forward = (forward * base + val) % mod;

            // backward hash (like right → left)
            backward = (backward + val * power) % mod;

            if (forward == backward) {
                best = i; // longest prefix palindrome ends here
            }

            power = (power * base) % mod;
        }

        // If the whole string is already palindrome
        if (best == n - 1) return s;

        // Reverse the suffix after best
        String suffix = s.substring(best + 1);
        return new StringBuilder(suffix).reverse().toString() + s;
    }
}
