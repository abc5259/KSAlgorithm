package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1541 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] expression = br.readLine().split("-");
    ArrayList<Integer> arrayList = new ArrayList<>();
    for(int i=0; i<expression.length; i++) {
      String[] arr = expression[i].split("\\+");
      int sum = 0;
      for(int j=0; j<arr.length; j++) {
        sum += Integer.parseInt(arr[j]);
      }
      arrayList.add(sum);
    }
    int result = 0;
    for(int i=0; i<arrayList.size(); i++) {
      if(i == 0) result += arrayList.get(i);
      else result -= arrayList.get(i);
    }
    System.out.println(result);
  }
}

// [55,-,50,+,40,-90]
