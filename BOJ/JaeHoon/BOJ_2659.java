package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2659 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[4];
    for(int i=0; i<4; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int answer = 1;
    int num = 1111;
    int limit = solve(arr);
    Set<Integer> set = new HashSet<>();
    while(num < 9999){
      int n = solve(num);
      if(n != -1 && n < limit && !set.contains(n)) {
        set.add(n);
        answer++;
      }
      num++; 
    }
    // System.out.println(set);
    System.out.println(answer);
  }
  public static int solve(int[] arr) {
    if(arr[0] == 0 || arr[1] == 0 || arr[2] == 0 || arr[3] == 0) return -1;
    int one = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
    int two = arr[1] * 1000 + arr[2] * 100 + arr[3] * 10 + arr[0];
    int three = arr[2] * 1000 + arr[3] * 100 + arr[0] * 10 + arr[1];
    int four = arr[3] * 1000 + arr[0] * 100 + arr[1] * 10 + arr[2];
    return Math.min(one, Math.min(two, Math.min(three, four)));
  }

  public static int solve(int num) {
    int a = num / 1000;
    num %= 1000;
    int b = num / 100;
    num %= 100;
    int c = num / 10;
    int d = num % 10;
    if(a == 0 ||b == 0 || c == 0 || d == 0) return -1;
    int one = a * 1000 +b * 100 + c * 10 + d;
    int two =b * 1000 + c * 100 + d * 10 + a;
    int three = c * 1000 + d * 100 + a * 10 +b;
    int four = d * 1000 + a * 100 +b * 10 + c;
    return Math.min(one, Math.min(two, Math.min(three, four)));
  }

}
