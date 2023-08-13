package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10713 {
    static int N,M;
    static int[] P;
    static Road[] roads;
    static boolean[] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        roads = new Road[N];
        P = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i] = new Road(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        long[] roadCnt = new long[N+1];

        for(int i=1; i<M; i++) {
            int curr = P[i];
            int next = P[i+1];

            if(curr < next) {
                roadCnt[curr]++;
                roadCnt[next]--;
            }else {
                roadCnt[next]++;
                roadCnt[curr]--;
            }
        }

        long total = 0;

        for(int i=1; i<N; i++) {
            if(roadCnt[i] == 0) continue;

            long A = roads[i].A * roadCnt[i];
            long B = roads[i].C + roads[i].B * roadCnt[i];

            if(A > B) total += B;
            else total += A;
        }

        System.out.println(total);
    }
    static class Road {
        int A,B,C;

        public Road(int a, int b, int c) {
            A = a;
            B = b;
            C = c;
        }
    }
}
