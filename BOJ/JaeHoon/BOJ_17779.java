package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17779 {
    static int N;
    static int[][] A;
    static int[][] arr;
    static int[] line = new int[4];
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        arr = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }
    public static void dfs(int depth) {
        if(depth == 4) {
            int x = line[0];
            int y = line[1];
            int d1 = line[2];
            int d2 = line[3];
            if(1 <= x && (x + d1 + d2 <= N) && (1 <= y - d1) && (y + d2 <= N)) {

                for(int i=x,j=y; i<=x+d1 && j>=y-d1; i++, j--) {
                    arr[i][j] = 5;
                }


                for(int i=x,j=y; i<=x+d2 && j<=y+d2; i++,j++) {
                    arr[i][j] = 5;
                }

                for(int i=x+d1,j=y-d1; i<=x+d1+d2 && j<=y-d1+d2; i++,j++) {
                    arr[i][j] = 5;
                }

                for(int i=x+d2,j=y+d2; i<=x+d1+d2 && j>=y+d2-d1; i++,j--) {
                    arr[i][j] = 5;
                }



                for(int i=x+1; i<x+d1+d2; i++) {
                    boolean flag = false;
                    for(int j=1; j<=N; j++) {
                        if(arr[i][j] == 5 && !flag) {
                            flag = true;
                            continue;
                        }

                        if(flag && arr[i][j] == 0) arr[i][j] = 5;
                        else if(arr[i][j] == 5) flag = false;
                    }
                }

                int one = 0;
                int two = 0;
                int three = 0;
                int four = 0;
                int five = 0;
                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=N; j++) {
                        if(arr[i][j] == 5) {
                            five += A[i][j];
                        }
                        else if(i < x + d1 && j <= y) {
                            arr[i][j] = 1;
                            one += A[i][j];
                        }
                        else if(i <= x + d2 && y < j) {
                            arr[i][j] = 2;
                            two += A[i][j];
                        }
                        else if(x+d1 <= i && j < y-d1+d2) {
                            arr[i][j] = 3;
                            three += A[i][j];
                        }
                        else if(x+d2 < i && y-d1+d2 <= j) {
                            arr[i][j] = 4;
                            four += A[i][j];
                        }
                    }
                }


                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=N; j++) {
                        arr[i][j] = 0;
                    }
                }

                int max = Math.max(one, Math.max(two,Math.max(three,Math.max(four,five))));
                int min = Math.min(one, Math.min(two,Math.min(three,Math.min(four,five))));

                answer = Math.min(answer,max - min);
            }

            return;
        }

        for(int i=1; i<=N; i++) {
            line[depth] = i;
            dfs(depth+1);
            line[depth] = 0;
        }
    }
}
