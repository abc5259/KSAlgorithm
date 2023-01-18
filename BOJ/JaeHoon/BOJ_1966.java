package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(st.nextToken());

    for(int t=0; t<T; t++) {
      st = new StringTokenizer(br.readLine());
      //문서개수
      int N = Integer.parseInt(st.nextToken());
      // 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수
      int M = Integer.parseInt(st.nextToken());
      // 문서 큐 
      Queue<Doc> q = new LinkedList<>();
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
        q.offer(new Doc(i, Integer.parseInt(st.nextToken())));
      }
      int answer = solve(q, M);
      
      sb.append(answer+"\n");
    }
    System.out.println(sb);
  }
  // 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 함수 시간복잡도: O(N^2)
  public static int solve(Queue<Doc> q, int findIdx) {
    // 몇 번째로 인쇄하는지 저장하는 변수 
    int answer = 1;
    while(!q.isEmpty()) {
      // 현재 큐에 제일 앞에있는 문서
      Doc curr = q.poll();
      // 제일 앞에있는 문서의 중요도가 가장 높은지
      boolean isMax = findMax(q, curr);
      // 중요도가 가장 높다면
      if(isMax) {
        // 내가 찾는 문서라면 while문 종료
        if(curr.idx == findIdx) break;
        // 내가 찾는 문서가 아니라면 인쇄+1 
        answer++;
      } else { //중요도가 가장 높지 않다면
        // 다시 큐에 넣기 
        q.offer(curr);
      }
    } 
    return answer;
  }
  // 문서가 큐에 남아있는 문서중 중요도가 가장 높은지 알아내는 함수 시간복잡도: O(N)
  public static boolean findMax(Queue<Doc> q, Doc curr) {
    boolean isMax = true;
    for(int i=0; i<q.size(); i++) {
      Doc next = q.poll();
      if(curr.important < next.important) isMax = false;
      q.offer(next);
    }
    return isMax;
  }
  static class Doc {
    int idx; //몇 번째 문서인지
    int important; // 중요도
    Doc(int idx, int important) {
      this.idx = idx;
      this.important = important;
    }
  }
}
