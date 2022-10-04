package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472 {
  static class Node implements Comparable<Node>{
		int to;
		int from;
		int value;
		
		public Node(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
		
	}
  static PriorityQueue<Node> pq = new PriorityQueue<>(); ;
  static int[][] board;
  static boolean[][] isVisit;
  static int total = 0;
  static int N,M;
  static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
  static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
  static int[] parents;
  static int land;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    isVisit = new boolean[N][M];
    land = 2;
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(board[i][j] == 1 && !isVisit[i][j]) {
          bfs(i, j, land);
          land++;
          total++;
        }
      }
    }
    for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j]!=0) {
					makeBridge(j, i, board[i][j]);
				}
			}
		}
    land--;
    parents = new int[land];
    for(int i=1; i<land; i++) {
			parents[i] = i;
		} 
		int answer = shortestPath();
		System.out.println(answer == 0 ? -1 : answer);
  }
  static int shortestPath() {
    int sum =0;
    int size = pq.size();
    for(int i=0; i< size; i++) {
      Node node = pq.poll();
      int x = node.from;
      int y = node.to;
      
      if(find(x) != find(y)) {
        sum += node.value;
        union(x,y);
      }
    }
    
    int rx = parents[1];
    for(int i=2; i<land; i++) {
      if(rx != find(parents[i])) {
        return 0;
      }
    }
    
    return sum;
  }
  static int find(int x) {
		if(parents[x] == x) return x;
		int rx = find(parents[x]);
		return rx;
		
	}
  static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) {
			parents[y]=x;
		}
		else {
			parents[x] =y;
		}
	}
  static void makeBridge(int x, int y, int idx) {
		Queue<int[]> q = new LinkedList<>();	
		boolean[][] check = new boolean[N][M];
		for(int d=0; d<4; d++) {
			q.add(new int[] {x,y,0});
			check[y][x] = true;
			
			while(!q.isEmpty()) {
				int[] p = q.poll();
				int px = p[0];
				int py = p[1];
				int move = p[2];
				
				int nx = px + dx[d];
				int ny = py + dy[d];
				
				if(nx<0 || ny <0 || nx > M-1 || ny > N-1 || check[ny][nx]) continue;
				
				if(board[ny][nx]!=idx) {
					if(board[ny][nx] !=0) {
						int from = idx-1;
						int to = board[ny][nx]-1;
						int bridgeLen = move;
						if(bridgeLen>1) {		
							pq.add(new Node(from, to, bridgeLen));
							break;
						}
					}else {
						check[ny][nx] = true;
						q.add(new int[] {nx, ny, move+1});
					}
				}
			}
			q.clear();
		}
	}
  public static void bfs(int row, int col, int land) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{row,col});
    ArrayList<int[]> arr = new ArrayList<>();
    arr.add(new int[]{row,col});
    board[row][col] = land;
    isVisit[row][col] = true;
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      arr.add(new int[]{curr[0],curr[1]});
      for(int i=0; i<4; i++) {
        int nextX = curr[0] + dir[i][0];
        int nextY = curr[1] + dir[i][1];
        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || isVisit[nextX][nextY]) continue;
        if(board[nextX][nextY] != 1) continue;
        board[nextX][nextY] = land;
        isVisit[nextX][nextY] = true;
        q.offer(new int[]{nextX,nextY});
      }
    }
  }
}
