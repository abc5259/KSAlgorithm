package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class BOJ_21942 {
  static int[] addDays;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    String L = st.nextToken();
    int F = Integer.parseInt(st.nextToken());
    HashMap<String,HashMap<String,Integer>> hashMap = new HashMap<>();
    int[] days = {
      31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    addDays = new int[12];
    for(int i=1; i<12; i++) {
      addDays[i] = days[i-1] + addDays[i-1];
    }
    String[] ss = L.split("/");
    String[] t = ss[1].split(":");
    long limitMinutes = 
      Integer.parseInt(ss[0]) * 24 * 60 + Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    
    ArrayList<String[]> arr = new ArrayList<>();
    HashMap<String,Long> answer = new HashMap<>();
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      String[] date = st.nextToken().split("-");
      String[] time = st.nextToken().split(":");
      String device = st.nextToken();
      String id = st.nextToken();

      int minutes = covertTime(
        Integer.parseInt(date[1]), 
        Integer.parseInt(date[2]), 
        Integer.parseInt(time[0]), 
        Integer.parseInt(time[1])
        );
      
      if(hashMap.containsKey(id)) {
          if(hashMap.get(id).containsKey(device)) {
            int m = hashMap.get(id).get(device);
            long dif = minutes - m;
            if(dif > limitMinutes) {
              if(answer.containsKey(id)) {
                answer.put(id, answer.get(id) + (dif-limitMinutes)*F);
              }else {
                answer.put(id, (dif-limitMinutes)*F);
              }
            }
            hashMap.get(id).remove(device);
          }else {
            hashMap.get(id).put(device,minutes);
          }
      }else {
        HashMap<String,Integer> h = new HashMap<>();
        h.put(device, minutes);
        hashMap.put(id, h);
      }
    }
    answer.forEach((String id, Long value) -> {
      arr.add(new String[]{id,String.valueOf(value)});
    });
    Collections.sort(arr,(String[] o1, String[] o2) -> {
      return o1[0].compareTo(o2[0]);
    });
    StringBuffer sb = new StringBuffer();
    for(String[] result: arr) {
      sb.append(result[0] + " " + result[1]).append("\n");
    }
    System.out.println(arr.size() == 0 ? -1 : sb);
  }
  static public int covertTime(int month, int date, int h, int m) {
    return addDays[month-1] * 24 * 60 + date * 24 * 60 + h * 60 + m;
  }
}