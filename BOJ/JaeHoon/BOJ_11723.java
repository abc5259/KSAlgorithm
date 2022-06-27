package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11723 {
  public static List<Integer> arr = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      if(s.equals("add")) {
        int n = Integer.parseInt(st.nextToken());
        add(n);
      }
      else if(s.equals("remove")) {
        int n = Integer.parseInt(st.nextToken());
        remove(n);
      }
      else if(s.equals("check")) {
        int n = Integer.parseInt(st.nextToken());
        sb.append(check(n)).append('\n');
      }
      else if(s.equals("toggle")) {
        int n = Integer.parseInt(st.nextToken());
        toggle(n);
      }
      else if(s.equals("all")) {
        all();
      }
      else {
        empty();
      }
    }
    System.out.println(sb);
  }
  public static void add(int item) {
    if(!arr.contains(item)) arr.add(item);
  }
  public static void remove(Integer item) {
    arr.remove(item);
  }
  public static int check(int item) {
    if(arr.contains(item)) return 1;
    return 0;
  }
  public static void toggle(Integer item) {
    if(arr.contains(item)) arr.remove(item);
    else arr.add(item);
  }
  public static void all() {
    arr = new ArrayList<>();
    for(int i=0; i<20; i++) 
      arr.add(i+1);
  }
  public static void empty() {
    arr = new ArrayList<>();
  }
}
