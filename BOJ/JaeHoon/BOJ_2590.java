package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2590 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[7];
    for(int i=1; i<=6; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int total = arr[6] + arr[5] + arr[4];
    int ableOneLength = 0;
    int ableTwoLength = 0;
    if(arr[5] > 0) {
      ableOneLength += arr[5]*11;
    }
    if(arr[4] > 0) {
      ableTwoLength += arr[4]*5;
    }
    arr[1] -= ableOneLength;
    ableOneLength = 0;
    if(arr[2] - ableTwoLength < 0) {
      ableOneLength += (ableTwoLength - arr[2])*4;
      arr[2] = 0;
      arr[1] -= ableOneLength;
    }else {
      arr[2] -= ableTwoLength;
    }
    ableTwoLength = 0;

    if(arr[3] > 0) {
      int restThree = 0;
      if(arr[3] / 4 == 0) {
        total += 1;
      }else {
        total += arr[3] / 4;
        if(arr[3] % 4 != 0)
          total += 1; 
      }
      restThree = arr[3] % 4;
      if(restThree == 1) {
        ableOneLength = 7;      
        ableTwoLength = 5;
        if(arr[2] - ableTwoLength < 0) {
          ableOneLength += (ableTwoLength - arr[2])*4;
          arr[2] = 0;
        }else {
          arr[2] -= ableTwoLength;
        }
        arr[1] -= ableOneLength;
      }
      else if(restThree == 2) {
        ableOneLength = 6;      
        ableTwoLength = 3;
        if(arr[2] - ableTwoLength < 0) {
          ableOneLength += (ableTwoLength - arr[2])*4;
          arr[2] = 0;
        }else {
          arr[2] -= ableTwoLength;
        }
        arr[1] -= ableOneLength;
      }
      else if(restThree == 3) {
        ableOneLength = 5;      
        ableTwoLength = 1;
        if(arr[2] - ableTwoLength < 0) {
          ableOneLength += (ableTwoLength - arr[2])*4;
          arr[2] = 0;
        }else {
          arr[2] -= ableTwoLength;
        }
        arr[1] -= ableOneLength;
      }
    }
    int restTwo = 0;
    if(arr[2] > 0) {
      if(arr[2] / 9 == 0) {
        total += 1;
      }else {
        total += arr[2] / 9;
        if(arr[2] % 9 != 0)
          total += 1;
      }
    }
    restTwo = arr[2] % 9;
    if(arr[1] > 0 && restTwo > 0) {
      int able = 36 - restTwo*4;
      arr[1] -= able;
    }
    // System.out.println("arr[1] = " + arr[1] + " arr[2] = " + arr[2] + " total = "+ total);
    if(arr[1] > 0) {
      int rest = 0;
      if(arr[1] / 36 == 0) {
        total += 1;
      }else {
        total += arr[1] / 36;
        rest = arr[1] % 36;
      }
      if(rest > 0) 
        total += 1;
    }
    System.out.println(total);
  }
}
