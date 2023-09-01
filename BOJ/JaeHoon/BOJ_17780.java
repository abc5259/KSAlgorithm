package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17780 {
    static int N,K;
    static int[] dx = {0,0,0,-1,1};
    static int[] dy = {0,1,-1,0,0};

    static int[] rDx = {0,0,1,-1};
    static int[] rDy = {-1,1,0,0};
    static ArrayList<ArrayList<Deque<Horse>>> map = new ArrayList<>();
    static int[][] colorMap;
    static class Horse {
        int x,y,dir,id;

        public Horse(int x, int y, int dir, int id) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.id = id;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        colorMap = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            map.add(new ArrayList<>());
            for(int j=0; j<N; j++) {
                map.get(i).add(new ArrayDeque<>());
                colorMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            map.get(x).get(y).offerLast(new Horse(x,y,dir,i));
        }

        int turn = 1;
        int startId = 1;
        WLoop: while (turn <= 1000) {

//            boolean isFind = false;
            Loop: for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map.get(i).get(j).isEmpty()) continue;

                    if(map.get(i).get(j).peekLast().id == startId) {
//                        isFind = true;


                        Horse horse = map.get(i).get(j).peekLast();

                        int nextX = horse.x + dx[horse.dir];
                        int nextY = horse.y + dy[horse.dir];

                        if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                            horse.dir = reverseDir(horse.dir);

                            nextX = horse.x + dx[horse.dir];
                            nextY = horse.y + dy[horse.dir];

                            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                                break Loop;
                            }

                            Deque<Horse> dq = map.get(i).get(j);
                            Deque<Horse> nextDq = map.get(nextX).get(nextY);
                            int color = colorMap[nextX][nextY];


                            if(color == 0) { //흰색
//                                System.out.println("id = " + horse.id + " nextX = " + nextX + " nextY = " + nextY);
                                while (!dq.isEmpty()) {
                                    Horse pHorse = dq.pollLast();
                                    pHorse.x = nextX;
                                    pHorse.y = nextY;
                                    nextDq.offerFirst(pHorse);
                                }

                            }
                            else if(color == 1) { //빨간색
//                                System.out.println("id = " + horse.id + " nextX = " + nextX + " nextY = " + nextY);
                                while (!dq.isEmpty()) {
                                    Horse pHorse = dq.pollFirst();
                                    pHorse.x = nextX;
                                    pHorse.y = nextY;
                                    nextDq.offerFirst(pHorse);
                                }

                            }
                            else if(color == 2) break Loop;
                            if(nextDq.size() >= 4) break WLoop;
                            break Loop;
                        }

                        int color = colorMap[nextX][nextY];

                        Deque<Horse> dq = map.get(i).get(j);
                        Deque<Horse> nextDq = map.get(nextX).get(nextY);
                        if(color == 0) { //흰색
//                            System.out.println("id = " + horse.id + " nextX = " + nextX + " nextY = " + nextY);
                            while (!dq.isEmpty()) {
                                Horse pHorse = dq.pollLast();
                                pHorse.x = nextX;
                                pHorse.y = nextY;
                                nextDq.offerFirst(pHorse);
                            }
                        }
                        else if(color == 1) { //빨간색
//                            System.out.println("id = " + horse.id + " nextX = " + nextX + " nextY = " + nextY);
                            while (!dq.isEmpty()) {
                                Horse pHorse = dq.pollFirst();
                                pHorse.x = nextX;
                                pHorse.y = nextY;
                                nextDq.offerFirst(pHorse);
                            }
                        }
                        else if(color == 2){// 파란색
                            horse.dir = reverseDir(horse.dir);

                            nextX = horse.x + dx[horse.dir];
                            nextY = horse.y + dy[horse.dir];

                            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                                break Loop;
                            }

                            nextDq = map.get(nextX).get(nextY);
                            color = colorMap[nextX][nextY];


                            if(color == 0) { //흰색
//                                System.out.println("id = " + horse.id + " nextX = " + nextX + " nextY = " + nextY);
                                while (!dq.isEmpty()) {
                                    Horse pHorse = dq.pollLast();
                                    pHorse.x = nextX;
                                    pHorse.y = nextY;
                                    nextDq.offerFirst(pHorse);
                                }

                            }
                            else if(color == 1) { //빨간색
//                                System.out.println("id = " + horse.id + " nextX = " + nextX + " nextY = " + nextY);
                                while (!dq.isEmpty()) {
                                    Horse pHorse = dq.pollFirst();
                                    pHorse.x = nextX;
                                    pHorse.y = nextY;
                                    nextDq.offerFirst(pHorse);
                                }

                            }
                            else if(color == 2) break Loop;

                        }

                        if(nextDq.size() >= 4) break WLoop;

                        break Loop;
                    }
                }
            }

            startId++;
            if(startId > K) {
                startId = 1;
                turn++;
            }
        }

        if(turn > 1000) {
            System.out.println(-1);
        }else {
            System.out.println(turn);
        }
    }

    static int reverseDir(int dir) {
        if(dir == 1) return 2;
        if(dir == 2) return 1;
        if(dir == 3) return 4;
        return 3;
    }
}
