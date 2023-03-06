package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18809 {
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  static int N,M,G,R;
  static int[][] map;
  static Pos[][] visit;
  static ArrayList<int[]> ableGroundList = new ArrayList<>();
  static int answer;
  static class Pos {
    int cnt, color;
    
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 2) ableGroundList.add(new int[]{i,j});
      }
    }
    candidate(0,0,new ArrayDeque<>(),R,G);

    System.out.println(answer);
  }
  public static void candidate(int idx, int cnt,Deque<Ground> q, int RCnt, int GCnt) {
    if(RCnt == 0 && GCnt == 0) {
      Deque<Ground> copuQ = new ArrayDeque<>(q);
      answer = Math.max(answer, bfs(copuQ));
      return;
    }
    if(idx >= ableGroundList.size()) return;

    // 아무것도 선택 x
    candidate(idx+1, cnt, q,RCnt,GCnt);

    int x = ableGroundList.get(idx)[0];
    int y = ableGroundList.get(idx)[1];
    int curr = map[x][y];
    if(GCnt > 0) {
      // 초록색 배양액 선택
      q.offerFirst(new Ground(x, y, 1));
      map[x][y] = 5;
      candidate(idx+1, cnt+1, q, RCnt, GCnt - 1);
      map[x][y] = curr;
      q.pollFirst();
    }

    if(RCnt > 0) {
      // 빨간색 배양액 선택
      q.offerFirst(new Ground(x, y, 2));
      map[x][y] = 6;
      candidate(idx+1, cnt+1, q , RCnt - 1, GCnt);
      map[x][y] = curr;
      q.pollFirst();
    }
  }
  public static int bfs(Deque<Ground> q) {
    visit = new Pos[N][M];
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {  
        visit[i][j] = new Pos();
      } 
    }
    int[][] copyMap = map.clone();
    for(int i=0; i<N; i++) {
      copyMap[i] = map[i].clone();
    }
    int cnt = 0;
    int sum = 0;
    while(!q.isEmpty()) {
      Set<int[]> set = new HashSet<>();
      int size = q.size();
      for(int k=0; k<size; k++) {
        Ground g = q.pollFirst();
        
        for(int i=0; i<4; i++) {
          int nextX = g.x + dx[i];
          int nextY = g.y + dy[i];

          if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || copyMap[nextX][nextY] == 0 || copyMap[nextX][nextY] >= 3) continue;
          if(visit[nextX][nextY].cnt == 0) { //아직 아무것도 없다면 
            visit[nextX][nextY].cnt = cnt+1;
            visit[nextX][nextY].color = g.color;
            set.add(new int[]{nextX,nextY,g.color});
          }
          else if(g.color == 1 && visit[nextX][nextY].cnt == cnt + 1 && visit[nextX][nextY].color == 2) {
            set.remove((new int[]{nextX,nextY,g.color}));
            copyMap[nextX][nextY] = 4;
            sum++;
          }
          else if(g.color == 2 && visit[nextX][nextY].cnt == cnt + 1 && visit[nextX][nextY].color == 1) {
            set.remove((new int[]{nextX,nextY,g.color}));
            copyMap[nextX][nextY] = 4;
            sum++;
          }
        }
      } 

      Iterator<int[]> iter = set.iterator();
      while(iter.hasNext()) {
        int[] arr = iter.next();
        int x = arr[0];
        int y = arr[1];
        int color = arr[2];
        if(copyMap[x][y] >= 3) continue;
        copyMap[x][y] = color + 4;
        q.offer(new Ground(x, y, color));
      }
      cnt++;
    }
    return sum;
  }
  static class Ground {
    int x,y,color;
    Ground(int x, int y, int color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }
  }
}
