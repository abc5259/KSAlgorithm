package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_19583 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int S = millis(st.nextToken());
    int E = millis(st.nextToken());
    int Q = millis(st.nextToken());

    Map<String,Boolean> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    String str = null;
    while((str = br.readLine()) != null) {
      String[] arr = str.split(" ");
      if(arr[0].equals("")) break;
      int time = millis(arr[0]);
      String name = arr[1];

      if(time <= S) { // 개강총회 시작 시간 전
        map.put(name, true); // 입장 완료 
      }
      else if(time >= E && time <= Q) { // 개강총회 끝나고 채팅 남겼다면 
        if(map.containsKey(name)) { // 개강총회 시작 시간 전에 채팅을 남긴 사람이라면 
          set.add(name); // 출석부에 기록! 
        }
      }
    }
    System.out.println(set.size()); 
  }
  public static int millis(String time) { // 22:33 String을 밀리세컨드로 구해주는 함수 
    String[] t = time.split(":");
    int hour = Integer.parseInt(t[0]);
    int m = Integer.parseInt(t[1]);
    return hour * 100 + m;
  }
}
