package Programmers.JaeHoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class 후보키 {
  class Solution {
      static int row,col;
      
      public boolean check(String[][] relation, int subset) {
          for(int i=0; i<row-1; i++) {
              for(int j=i+1; j<row; j++) {
                  boolean isSame = true;
                  for(int k=0; k<col; k++) {
                      if((subset & (1 << k)) == 0) continue;
                      if(relation[i][k].equals(relation[j][k]) == false) {
                          isSame = false;
                          break;
                      }
                  }
                  if(isSame) return false;
              }
          }
          return true;
      }
      public int solution(String[][] relation) {
          int answer = 0;
  
          row = relation.length;
          col = relation[0].length;
          
          ArrayList<Integer> candidates = new ArrayList<>();
          
          for(int i=1; i<1<<col; i++) {
              if(check(relation,i)) {
                  candidates.add(i);
              }
          }
          // 0011
          // 1111
          while(candidates.size() != 0) {
              int n = candidates.remove(0);
              answer++;
              
              for(Iterator<Integer> it = candidates.iterator(); it.hasNext();) {
                  int c = it.next();
                  if((n & c) == n) {
                      it.remove();
                  }
              }
          }
          
          return answer;
      }
  }
}