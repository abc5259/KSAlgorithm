package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[N-1][N-1] == 1) {
            System.out.println(0);
            return;
        }
        int result = dfs(new Pipe(new int[]{0,0}, new int[]{0,1}, -1, 0));
        System.out.println(result);
    }

    static int dfs(Pipe pipe) {
        int[] end = pipe.end;
        if(end[0] == N-1 && end[1] == N-1) {
            return 1;
        }

        List<Pipe> pipes = pipe.nextPipes();
        int sum = 0;
        for (Pipe pipe1 : pipes) {
            sum += dfs(pipe1);
        }

        return sum;
    }

    static class Pipe {
        int[] start;
        int[] end;
        int dir; // 가로 : -1, 세로: 0, 대각선 1
        int count;

        public Pipe(int[] start, int[] end, int dir, int count) {
            this.start = start;
            this.end = end;
            this.dir = dir;
            this.count = count;
        }

        public List<Pipe> nextPipes() {
            List<Pipe> pipes = new ArrayList<>();
            if(dir == -1) {
                if(end[1] + 1 < N && map[end[0]][end[1] + 1] == 0) {
                    pipes.add(new Pipe(new int[]{end[0], end[1]}, new int[]{end[0], end[1] + 1}, -1, count+1));
                }

                if(end[0] + 1 < N && end[1] + 1 < N) {
                    if(map[end[0]][end[1] + 1] == 0 &&
                            map[end[0]+1][end[1]] == 0 &&
                            map[end[0]+1][end[1] + 1] == 0) {
                        pipes.add(new Pipe(
                                new int[]{end[0], end[1]},
                                new int[]{end[0]+1,end[1]+1},
                                1,
                                count+1
                        ));
                    }
                }
            }

            else if(dir == 0) {
                if(end[0] + 1 < N && map[end[0]+1][end[1]] == 0) {
                    pipes.add(new Pipe(new int[]{end[0], end[1]}, new int[]{end[0]+1, end[1]}, 0,count+1));
                }

                if(end[0] + 1 < N && end[1] + 1 < N) {
                    if(map[end[0]][end[1] + 1] == 0 &&
                            map[end[0]+1][end[1]] == 0 &&
                            map[end[0]+1][end[1] + 1] == 0) {
                        pipes.add(new Pipe(
                                new int[]{end[0], end[1]},
                                new int[]{end[0]+1,end[1]+1},
                                1,
                                count+1
                        ));
                    }
                }
            }
            else if(dir == 1) {
                if(end[1] + 1 < N && map[end[0]][end[1] + 1] == 0) {
                    pipes.add(new Pipe(new int[]{end[0], end[1]}, new int[]{end[0], end[1] + 1}, -1,count+1));
                }

                if(end[0] + 1 < N && map[end[0]+1][end[1]] == 0) {
                    pipes.add(new Pipe(new int[]{end[0], end[1]}, new int[]{end[0]+1, end[1]}, 0,count+1));
                }

                if(end[0] + 1 < N && end[1] + 1 < N) {
                    if(map[end[0]][end[1] + 1] == 0 &&
                            map[end[0]+1][end[1]] == 0 &&
                            map[end[0]+1][end[1] + 1] == 0) {
                        pipes.add(new Pipe(
                                new int[]{end[0], end[1]},
                                new int[]{end[0]+1,end[1]+1},
                                1,
                                count+1
                        ));
                    }
                }
            }

            return pipes;
        }
    }
}
