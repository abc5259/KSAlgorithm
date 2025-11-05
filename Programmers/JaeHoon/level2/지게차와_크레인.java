package Programmers.JaeHoon.level2;
import java.util.*;

public class 지게차와_크레인 {
  // 시작 03:28

  class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    char[][] map;
    boolean[][] used;
    boolean[][] visited;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int N = storage.length;
        int M = storage[0].length();
        map = new char[N+2][M+2];
        used = new boolean[N+2][M+2];
        visited = new boolean[N+2][M+2];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(int i=0; i<N+2; i++) {
            for(int j=0; j<M+2; j++) {
                if(i == 0 || i == N+1 || j == 0 || j == M+1) {
                    used[i][j] = true;
                }
            }   
        }
        
        for(String req: requests) {
            char c = req.charAt(0);
            if(req.length() == 1) {
                visited = new boolean[N+2][M+2];
                Queue<int[]> rq = new LinkedList<>();
                Queue<int[]> q = new LinkedList<>();
                visited[0][0] = true;
                q.offer(new int[]{0,0});
                
                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    
                    for(int i=0; i<4; i++) {
                        int nx = curr[0] + dx[i];
                        int ny = curr[1] + dy[i];
                        
                        if(nx < 0 || nx >= N+2 || ny < 0 || ny >= M+2 || visited[nx][ny]) continue;
                        if(used[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx,ny});
                        }else {
                            if(map[nx][ny] == c) {
                                rq.offer(new int[]{nx,ny});
                            }
                        }
                    }
                }
                
                while(!rq.isEmpty()) {
                    int[] cu = rq.poll();
                    used[cu[0]][cu[1]] = true;
                }
                
            }else {
                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=M; j++) {
                        if(map[i][j] == c) {
                            used[i][j] = true;
                        }
                    }   
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(!used[i][j]) answer++;
            }
        }
        
        return answer;
    }
  }
}
