package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375 {
  static int answer = 1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();

    int T = Integer.parseInt(st.nextToken());

    for(int i=0; i<T; i++) {
      HashMap<String,Integer> hashMap = new HashMap<>();
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());

      for(int k=0; k<n; k++) {
        st = new StringTokenizer(br.readLine());
        st.nextToken(); 
        String kind = st.nextToken(); 
        if(hashMap.containsKey(kind))
          hashMap.put(kind, hashMap.get(kind) + 1);
        else 
          hashMap.put(kind, 2);
      }
              
      hashMap.forEach((key,value) -> {
        answer *= value;
      });
      answer--;
      sb.append(answer).append('\n');
      answer = 1;
    }
    System.out.println(sb);
  }
}