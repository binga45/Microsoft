package com.assessment.src;

/**
 * @author Dhirane Satvik Kona
 * This class consists of a helper method to compute longestpalindromicsubstring
 */
public class PalindromicSubString {

    /**
     * This method uses dynamic programming paradigm to get the LongestPalindromicSubString
     * @param n Value of the length of inputString
     * @param inputString The inputString on which the longest palindromic substring needs to be computed
     * @return "the string which is the best palindrome"
     * @throws IllegalArgumentException
     */
    public String computeBestPalindrome (int n, String inputString) throws IllegalArgumentException{
        try {
            if(inputString==null || inputString.length() == 0) return null;

            // Initializing resultString with the first char in case of no other larger palindromic substring
            String resultString = inputString.substring(0, 1);
            int resultStringLength = 1;

            /**
             * dp[left][right] stores the length of the maximum palindromic
             * substring between indices left and right of the inputString
             */
            int[][] dp = new int[n][n];

            /**
             * state[left][right] stores if the substring between indices
             * left and right of the inputString is a palindrome
             */
            boolean[][] state = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
                state[i][i] = true;
            }

            /** Our logic only fills the upper diagonals of the below matrix.
             *
             * Initially all the x's in the main diagonal of the
             * below matrix are populated with ones by the above for loop.
             *
             * Now with each iteration of the below for loop, as we increase diff between left
             * and right, we initialize the other diagonals of the matrix.
             *
             *     0 1 2 3 ....... n-1
             *  0  x .             result
             *  1    x .
             *  2      x .
             *  3        x .
             *  .          x .
             *  .
             *  .
             *  .                  x  .
             *  n-1                   x
             *
             *  The final iteration of the below for loop will get us the result cell value in the above matrix.
             ***/
            for (int diff = 1; diff < n; diff++) {
                for (int left = 0; left <= n - 1 - diff; left++) {
                    int right = left + diff;
                    boolean endsMatch = inputString.charAt(left) == inputString.charAt(right);

                    /*
                    If block for handling the case where difference between left and right is 1
                    It is treated as a separate case because dp[left+1][right-1] here will be the lower
                    diagonals in the above illustration which we didn't initialize & don't want to get into.
                     */
                    if (diff == 1) {
                        if (endsMatch) {
                            dp[left][right] = 2;
                            if (resultString.length() < 2) {
                                resultStringLength = 2;
                                resultString = inputString.substring(left, right + 1);
                            }
                            state[left][right] = true;
                        }
                        continue;
                    }

                    // Case when the current substring under consideration
                    // i.e., inputString.substring(left, right+1) is a palindrome
                    if (endsMatch && state[left + 1][right - 1]) {
                        dp[left][right] = 2 + dp[left + 1][right - 1];
                        int currentPalindromeLength = right - left + 1;
                        // Changing resultString if the current subString is the maxPalindromicSubString
                        // We also change the resultStringLength
                        if (currentPalindromeLength > resultStringLength) {
                            resultString = inputString.substring(left, right + 1);
                            resultStringLength = currentPalindromeLength;
                        }
                        state[left][right] = true;
                    }
                    // Case when current string under consideration is not a palindrome
                    else {
                        dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                        state[left][right] = false;
                    }
                }
            }
            return resultString;
        } catch (OutOfMemoryError e){
            throw new IllegalArgumentException("OutOfMemoryError: Number >= Integer.MAX_VALUE is passed");
        }

    }

}
