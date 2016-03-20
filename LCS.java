import java.io.*;
import java.util.*;
import java.lang.Math.*;

class Solution {
  public static int LCS(char[] s1, char[] s2) {
    int[][] L = new int[s1.length + 1][s2.length + 1];
    ArrayList<Character> sec = new ArrayList<Character>();
    
    for (int i = 0; i <= s1.length; i++) {
      for (int j = 0; j <= s2.length; j++) {
        if (i == 0 || j == 0) {
          L[i][j] = 0;
        } else if (s1[i - 1] == s2[j - 1]) {
          L[i][j] = 1 + L[i - 1][j - 1];
          sec.add(s1[i - 1]);
        } else {
          L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
        }
      }
    }
    
    System.out.println(sec);
    return L[s1.length][s2.length];
  }
   
  public static void main(String[] args) {
    System.out.println("LCS: " + LCS(new char[]{ 'a', 'd', 'c' }, new char[]{ 'a', 'b', 'c' }));
  }
}
