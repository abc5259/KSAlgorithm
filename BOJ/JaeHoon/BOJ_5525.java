package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_5525 {
  public static void main(String[] args) throws IOException {
    //11:03
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String S = br.readLine();

    int start = S.indexOf("I");
    boolean isOk = true;
    int length = 1;
    if(start >= 0) {
      Map<Integer,Integer> map = new HashMap<>();
      for(int i=start+1; i<M; i++) {
        if(S.charAt(i) == 'I') isOk = true;
  
        if(isOk) {
          if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' || S.charAt(i-1) == 'O' && S.charAt(i) == 'I') {
            length++;
          }else {
            isOk = false;
            if(S.charAt(i) == 'I') {
              isOk = true;
              if(length >= 3) {
                map.put(length, map.getOrDefault(length, 0)+1);
              }
              length = 1;
            }
            else {
              length--;
              if(length >= 3) {
                map.put(length, map.getOrDefault(length, 0)+1);
              }
              length = 0;
            }
          }
        }
      }
      if(isOk && length >= 3) {
        if(S.charAt(M-1) == 'I')
          map.put(length, map.getOrDefault(length, 0)+1);
        else {
          length--;
          if(length >= 3) {
            map.put(length, map.getOrDefault(length, 0)+1);
          }
        }
      }
      
      int size = N*2+1;
      int answer = 0;
      for( Map.Entry<Integer, Integer> elem : map.entrySet() ){
        if(elem.getKey() >= size) {
          answer += (((elem.getKey() - size) / 2) + 1)*elem.getValue();
        }
      }
      System.out.println(answer);
    }else {
      System.out.println(0);
    }

  }


}
