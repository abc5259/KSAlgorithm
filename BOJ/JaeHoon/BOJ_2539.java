package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ_2539 {
  static int N,M,paperCnt,dirtyCnt,maxHight;
  static int[] papers;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken().trim());
    M = Integer.parseInt(st.nextToken().trim());

    paperCnt = Integer.parseInt(br.readLine().trim());

    dirtyCnt = Integer.parseInt(br.readLine().trim());

    papers = new int[M+1];
    for(int i=0; i<dirtyCnt; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      maxHight = Math.max(maxHight, x);
      papers[y]+=1;
    }

    int low = 0;
    int high = Math.min(N, M)+1;
    while(low + 1 < high) {
      int mid = (low + high) / 2;
      if(check(mid)) {
        high = mid;
      }else {
        low = mid;
      }
    }
    System.out.println(high);
  }
  public static boolean check(int size) {
    if(size < maxHight) {
      return false;
    }
    int useCnt = 0;
    int i = 1;    
    while(i <= M) {
      if(papers[i] > 0) { // 잘못 칠해진 칸이 있다면 
        useCnt++; //종이 갯수 + 1
        i += size; //종이를 붙이면 종이 사이즈만큼 붙이니 + size
      }else {
        i++;
      }
    }

    if(useCnt > paperCnt) return false;
    return true;
  }
}
