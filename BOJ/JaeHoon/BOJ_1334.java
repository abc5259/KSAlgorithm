package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1334 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String N = br.readLine();
    StringBuffer newStr = new StringBuffer(N);


    int left = 0;
    int right = N.length() -1;

    while(left < right) {
      newStr.setCharAt(right, N.charAt(left));
      left++;
      right--;
    } 
    boolean maxFlag = false;
    // System.out.println("992".compareTo("999"));
    if(N.compareTo(newStr.toString()) >= 0) {
      
      if(N.length() % 2 == 0) { //짝수라면 

        if(N.charAt(right) == '9') {
          newStr.setCharAt(right, '0');
          newStr.setCharAt(left, '0');
        }else {
          newStr.setCharAt(right, (char)(newStr.charAt(right) + 1));
          newStr.setCharAt(left, (char)(newStr.charAt(left) + 1));
        }

        while(newStr.charAt(right) == '0' && newStr.charAt(left) == '0') {
          right--;
          left++;
          if(right < 0) {
            maxFlag = true;
            break;
          }
          if(N.charAt(right) == '9') {
            newStr.setCharAt(right, '0');
            newStr.setCharAt(left, '0');
          }else {
            newStr.setCharAt(right, (char)(newStr.charAt(right) + 1));
            newStr.setCharAt(left, (char)(newStr.charAt(left) + 1));
          }
        }
      }
      else { // 홀수라면 
        if(N.charAt(right) == '9') {
          newStr.setCharAt(right, '0');
        }else {
          newStr.setCharAt(right, (char)(newStr.charAt(right) + 1));
        }

        while(newStr.charAt(right) == '0' && newStr.charAt(left) == '0') {
          right--;
          left++;
          if(right < 0) {
            maxFlag = true;
            break;
          }
          if(N.charAt(right) == '9') {
            newStr.setCharAt(right, '0');
            newStr.setCharAt(left, '0');
          }else {
            newStr.setCharAt(right, (char)(newStr.charAt(right) + 1));
            newStr.setCharAt(left, (char)(newStr.charAt(left) + 1));
          }
        }
      }

    }

    if(maxFlag) {
      newStr.setCharAt(newStr.length() - 1, '1');
      String result = "1" + newStr;
      System.out.println(result);
    }else {
      System.out.println(newStr);
    }
  }
  
}
