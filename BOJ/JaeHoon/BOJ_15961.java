package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 접시 수 
    int D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수 
    int K = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
    int C = Integer.parseInt(st.nextToken()); //쿠폰 

    int[] arr = new int[N+1];
    int[] isChoose = new int[D+1];

    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    
    int cnt = 0;
    for(int i=0; i<K; i++) {
      if(isChoose[arr[i]] == 0) {
        cnt++;
      }
      isChoose[arr[i]] += 1;
    }
    int end = K-1;
    int answer = isChoose[C] == 0 ? cnt+1 : cnt; //쿠폰 이용 

    for(int i=1; i<N; i++) {
      //첫 접시 빼기 
      isChoose[arr[i-1]] -= 1;
      if(isChoose[arr[i-1]] == 0) cnt--;

      //추가로 먹을접시
      end = (end + 1) % N; 
      if(isChoose[arr[end]] == 0) { //추가로 먹을접시가 아직 안먹은 종류라면 
        cnt++; //종류 추가 
      }
      isChoose[arr[end]] += 1;
      answer = Math.max(answer, isChoose[C] == 0 ? cnt+1 : cnt);
    }

    System.out.println(answer);
  }
}
