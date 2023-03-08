package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8980 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    
    int M = Integer.parseInt(br.readLine());
    Load[] loads = new Load[M];
    int[] village = new int[N+1];
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int loadCnt = Integer.parseInt(st.nextToken());

      loads[i] = new Load(start,end, loadCnt);
    }

    Arrays.sort(loads);
    Arrays.fill(village, C);
    int answer = 0;
    for(int i=0; i<M; i++) {
      Load load = loads[i];
      int subCnt = load.loadCnt;
      for(int j=load.start; j<load.end; j++) {
        if(village[j] - load.loadCnt < 0) {
          subCnt = Math.min(subCnt, village[j]);
        }
      }

      for(int j=load.start; j<load.end; j++) {
        village[j] -= subCnt;
      }
      answer += subCnt;
    }
    System.out.println(answer);
  } 
  static class Load implements Comparable<Load>{
    int start,end,loadCnt;
    Load(int start,int end, int loadCnt) {
      this.start = start;
      this.end = end;
      this.loadCnt = loadCnt;
    }
    @Override
    public int compareTo(Load o) {
      if(this.end == o.end) return this.start - o.start;
      return this.end - o.end;
    }
  }
}
