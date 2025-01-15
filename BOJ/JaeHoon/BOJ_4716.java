package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4716 {
    static int N, A, B;
    static Team[] teams;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if(N == 0 && A == 0 && B == 0) {
                break;
            }
            teams = new Team[N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int cnt = Integer.parseInt(st.nextToken());
                int aDis = Integer.parseInt(st.nextToken());
                int bDis = Integer.parseInt(st.nextToken());
                teams[i] = new Team(cnt, aDis, bDis);
            }

            Arrays.sort(teams);
            int sum = 0;
            for (Team team : teams) {
                if(team.aDis < team.bDis) {
                    if(A >= team.cnt) {
                        sum += team.aDis*team.cnt;
                        A -= team.cnt;
                    } else {
                        team.cnt -= A;
                        sum += team.aDis*A;
                        A = 0;
                        B -= team.cnt;
                        sum += team.bDis*team.cnt;
                    }
                }
                else {
                    if(B >= team.cnt) {
                        sum += team.bDis*team.cnt;
                        B -= team.cnt;
                    } else {
                        team.cnt -= B;
                        sum += team.bDis*B;
                        B = 0;
                        A -= team.cnt;
                        sum += team.aDis*team.cnt;
                    }
                }
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
    static class Team implements Comparable<Team> {
        int cnt, aDis, bDis;

        public Team(int cnt, int aDis, int bDis) {
            this.cnt = cnt;
            this.aDis = aDis;
            this.bDis = bDis;
        }

        @Override
        public int compareTo(Team o) {
            return o.cal() - this.cal();
        }

        public int cal() {
            return Math.abs(aDis - bDis);
        }

    }
}
