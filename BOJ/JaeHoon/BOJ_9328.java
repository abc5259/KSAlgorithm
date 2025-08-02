package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9328 {

    static int N, M;
    static char[][] map;
    static Map<Character, Queue<int[]>> waitingDoors;
    static Set<Character> keys;
    static List<int[]> enters;
    static int answer;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            waitingDoors = new HashMap<>();
            keys = new HashSet<>();
            enters = new ArrayList<>();
            answer = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);
                    if(i == 0 || i == N-1 || j == 0 || j == M-1) {
                        if(map[i][j] == '.') {
                            enters.add(new int[]{i, j});
                        }
                        else if('a' <= map[i][j] && map[i][j] <= 'z') {
                            keys.add(map[i][j]);
                            map[i][j] = '.';
                            enters.add(new int[]{i, j});
                        }
                        else if('A' <= map[i][j] && map[i][j] <= 'Z') {
                            if(keys.contains(Character.toLowerCase(map[i][j]))) {
                                enters.add(new int[]{i, j});
                                map[i][j] = '.';
                            }
                            else {
//                                addWaitingDoors(i, j, map[i][j]);
                            }
                        }
                        else if(map[i][j] == '$') {
                            answer++;
                            map[i][j] = '.';
                            enters.add(new int[]{i, j});
                        }
                    }
                }
            }
            String keyStr = br.readLine();
            char[] keyStrCharArray = keyStr.toCharArray();
            for (char key : keyStrCharArray) {
                keys.add(key);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(i == 0 || i == N-1 || j == 0 || j == M-1) {
                        if('A' <= map[i][j] && map[i][j] <= 'Z') {
                            if(keys.contains(Character.toLowerCase(map[i][j]))) {
                                enters.add(new int[]{i, j});
                            }else {
                                addWaitingDoors(i, j, map[i][j]);
                            }
                        }
                    }

                }
            }
            for(int[] enter : enters) {
                int x = enter[0];
                int y = enter[1];
                if(visited[x][y]) continue;

                if('A' <= map[x][y] && map[x][y] <= 'Z') {
                    if(keys.contains(Character.toLowerCase(map[x][y]))) {
                        bfs(x, y);
                    }else {
                        addWaitingDoors(x, y, map[x][y]);
                    }
                }
                else {
                    bfs(x, y);
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
//            System.out.println("x = " + cur[0] + ", y = " + cur[1]);
            for(int d=0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if(map[nx][ny] == '*') continue;

                if('A' <= map[nx][ny] && map[nx][ny] <= 'Z') { // 문이라면
                    if(keys.contains(Character.toLowerCase(map[nx][ny]))) { //이미 열쇠가 있다면
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }else { //열쇠가 없다면
                        addWaitingDoors(nx, ny, map[nx][ny]);
                    }
                }
                if('a' <= map[nx][ny] && map[nx][ny] <= 'z') { //열쇠라면
                    keys.add(map[nx][ny]);
                    for(char door: waitingDoors.keySet()) {
                        if(keys.contains(Character.toLowerCase(door))) {
                            waitingDoors(door, queue);
                        }
                    }
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
                if(map[nx][ny] == '$') {
                    answer++;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
                if(map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void waitingDoors(char door, Queue<int[]> queue) {
//        if(!waitingDoors.containsKey(door)) return;

        Queue<int[]> waitingQueue = waitingDoors.get(door);
        while(!waitingQueue.isEmpty()) {
            int[] point = waitingQueue.poll();
            visited[point[0]][point[1]] = true;
            queue.add(point);
        }
    }

    private static void addWaitingDoors(int x, int y, char door) {
        if(waitingDoors.containsKey(door)) {
            waitingDoors.get(door).add(new int[]{x, y});
        }else {
            waitingDoors.put(door, new LinkedList<>());
            waitingDoors.get(door).add(new int[]{x, y});
        }
    }
}
