package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2931 {
    static int N,M;
    static char[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[] roads = {'|', '-', '+', '1', '2', '3', '4'};
    static boolean[][] isVisited;
    static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M];
        int[] start = new int[2];
        int[] end = new int[2];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'M') {
                    start[0] = i;
                    start[1] = j;
                    isVisited[i][j] = true;
                }
                else if(map[i][j] == 'Z') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int[] startRoad = findStartRoad(start);
        solve(startRoad[0], startRoad[1], startRoad[2], startRoad[3]);

        System.out.println((answer[0]+1) + " " + (answer[1]+1) + " " + map[answer[0]][answer[1]]);
    }
    public static void solve(int x, int y, int dirX, int dirY) {
        isVisited[x][y] = true;
//        System.out.println("x = " + x + " y = " + y);
        if(map[x][y] == 'Z') {
            System.out.println("end");
            return;
        }

        if(map[x][y] == '.') {
            answer[0] = x;
            answer[1] = y;
            for(int r=0; r<roads.length; r++) {
                map[x][y] = roads[r];
                if(dirX == 0) {
                    if(roads[r] == '|') continue;

                    if(dirY == -1) {
                        if(roads[r] == '3' || roads[r] == '4') continue;
                    }

                    if(dirY == 1) {
                        if(roads[r] == '1' || roads[r] == '2') continue;
                    }
                }

                if(dirY == 0) {
                    if(roads[r] == '-') continue;

                    if(dirX == -1) {
                        if(roads[r] == '2' || roads[r] == '3') continue;
                    }

                    if(dirX == 1) {
                        if(roads[r] == '1' || roads[r] == '5') continue;
                    }
                }

                boolean[][] visited = new boolean[N][M];
                for(int i=0; i<N; i++) {
                    visited[i] = isVisited[i].clone();
                }
//                System.out.println("gogo");
                solve2(x, y, dirX, dirY, visited);

                boolean ok = true;
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        if(map[i][j] != '.' && !visited[i][j]) {
                            ok = false;
                            break;
                        }
                    }
                    if(!ok) break;
                }
                if(ok) return;
            }
            return;
        }

        if(map[x][y] == '|' || map[x][y] == '-' || map[x][y] == '+') { //빙향 못바꿈
            solve(x+dirX, y+dirY, dirX, dirY);
        }

        else if(map[x][y] == '1') {
            if(dirY == 0) {
                solve(x, y + 1, 0, 1);
            }
            else if(dirX == 0) {
                solve(x + 1, y, 1, 0);
            }
        }
        else if(map[x][y] == '2') {
            if(dirY == 0) {
                solve(x, y + 1, 0, 1);
            }
            else if(dirX == 0) {
                solve(x - 1, y, -1, 0);
            }
        }
        else if(map[x][y] == '3') {
            if(dirY == 0) {
                solve(x, y - 1, 0, -1);
            }
            else if(dirX == 0) {
                solve(x - 1, y, -1, 0);
            }
        }
        else if(map[x][y] == '4') {
            if(dirY == 0) {
                solve(x, y - 1, 0, -1);
            }
            else if(dirX == 0) {
                solve(x + 1, y, 1, 0);
            }
        }
    }

    public static void solve2(int x, int y, int dirX, int dirY, boolean[][] visited) {
        if(x < 0 || x >= N || y < 0 || y >= M) return;
//        System.out.println("x = " + x + " y = " + y);
        if(dirX == 0) {
            if(map[x][y] == '|') return;

            if(dirY == -1) {
                if(map[x][y] == '3' || map[x][y] == '4') return;
            }

            if(dirY == 1) {
                if(map[x][y] == '1' || map[x][y] == '2') return;
            }
        }
        visited[x][y] = true;
        if(map[x][y] == 'Z') {
            return;
        }

        if(map[x][y] == '.') {
            return;
        }

        if(map[x][y] == '|' || map[x][y] == '-' || map[x][y] == '+') { //빙향 못바꿈
            solve2(x+dirX, y+dirY, dirX, dirY, visited);
        }


        else if(map[x][y] == '1') {
            if(dirY == 0) {
                solve2(x, y + 1, 0, 1, visited);
            }
            else if(dirX == 0) {
                solve2(x + 1, y, 1, 0, visited);
            }
        }
        else if(map[x][y] == '2') {
            if(dirY == 0) {
                solve2(x, y + 1, 0, 1, visited);
            }
            else if(dirX == 0) {
                solve2(x - 1, y, -1, 0, visited);
            }
        }
        else if(map[x][y] == '3') {
            if(dirY == 0) {
                solve2(x, y - 1, 0, -1, visited);
            }
            else if(dirX == 0) {
                solve2(x - 1, y, -1, 0, visited);
            }
        }
        else if(map[x][y] == '4') {
            if(dirY == 0) {
                solve2(x, y - 1, 0, -1, visited);
            }
            else if(dirX == 0) {
                solve2(x + 1, y, 1, 0, visited);
            }
        }
    }

    public static int[] findStartRoad(int[] start) {
        int[] startRoad = new int[4];
        for(int i=0; i<4; i++) {
            int nx = start[0] + dx[i];
            int ny = start[1] + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            for(int r=0; r<7; r++) {
                if(map[nx][ny] == roads[r]) {
                    startRoad[0] = nx;
                    startRoad[1] = ny;
                    startRoad[2] = dx[i];
                    startRoad[3] = dy[i];
                }
            }
        }

        return startRoad;
    }
}
//3 7
//.......
//.M---Z.
//.......
//6 10
//Z.1----4..
//|.|....|..
//|.|14..M..
//2-+++4....
//..2323....
//..........

//3 3
//M..
//|..
//.-Z

//3 3
//.1Z
//1..
//M..

//3 3
//..Z
//..3
//M3.

//3 5
//..1-M
//1-.4.
//Z.23.