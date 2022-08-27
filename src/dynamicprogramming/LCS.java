package dynamicprogramming;

import java.util.HashMap;

public class LCS {

    private String s1;
    private String s2;
    private int[][] solutions;

    public LCS(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;

        this.solutions = new int[s1.length() + 1][s2.length() + 1];
    }

    public void findSolutionUsingTabulation() {
        for (int s1Idx = 1; s1Idx < this.s1.length() + 1; s1Idx++) {
            for (int s2Idx = 1; s2Idx < this.s2.length() + 1; s2Idx++) {
                if (s1.charAt(s1Idx - 1) == s2.charAt(s2Idx - 1)) {
                    this.solutions[s1Idx][s2Idx] = this.solutions[s1Idx - 1][s2Idx - 1] + 1;
                } else {
                    this.solutions[s1Idx][s2Idx] = Math.max(this.solutions[s1Idx - 1][s2Idx], this.solutions[s1Idx][s2Idx - 1]);
                }
            }
        }

        this.showSolution();
    }

    private void showSolution() {
        StringBuilder sb = new StringBuilder();

        int s1Idx = s1.length();
        int s2Idx = s2.length();

        while (s1Idx > 0 && s2Idx > 0) {
            if (s1.charAt(s1Idx - 1) == s2.charAt(s2Idx - 1)) {
                sb.append(s1.charAt(s1Idx - 1));
                s1Idx--;
                s2Idx--;
            } else if (this.solutions[s1Idx - 1][s2Idx] > this.solutions[s1Idx][s2Idx - 1]) {
                s1Idx--;
            } else {
                s2Idx--;
            }
        }

        System.out.println("The longest common subsequence is '" + sb.reverse().toString() + "'");
    }

    public void findSolutionUsingMemoization() {
        HashMap<String,Integer> solutions = new HashMap<>();
        int m = this.s1.length();
        int n = this.s2.length();
        int longestSubSequenceValue = findSolutionRecursively(this.s1, this.s2, m, n, solutions);
        String chars = longestSubSequenceValue == 1 ? " character" : " characters";
        System.out.println("The longest subsequence has " + longestSubSequenceValue + chars + ".");
    }

    private int findSolutionRecursively(String s1, String s2, int m, int n, HashMap<String, Integer> solutions) {
        // check for memoized solution
        String key = "s1Idx-" + (m-1) + "-s2Idx-" + (n-1);
        if (solutions.containsKey(key)) return solutions.get(key);

        // base case
        if (m == 0 || n == 0) return 0;

        // compute options
        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            int value = 1 + findSolutionRecursively(s1, s2, m-1, n-1, solutions);
            solutions.put(key, value);
            return value;
        } else {
            int x = findSolutionRecursively(s1, s2, m-1, n, solutions);
            int y = findSolutionRecursively(s1, s2, m, n-1, solutions);
            int maxValue = Math.max(x, y);
            solutions.put(key, maxValue);
            return maxValue;
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdefffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggeeeeeeeeeeeeeeeeeeeeeeefffffffffffffffffffffffffffffffffffff";
        String s2 = "axxxxxxxxxxxxxxxxxxxxbddddddddddddddddddcccccccccffffffffffffffxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxggggggggggggggggggggggggggggggg";

        LCS lcs = new LCS(s1, s2);
        lcs.findSolutionUsingTabulation();
        lcs.findSolutionUsingMemoization();
    }
}
