package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[N];
            for(int i=0; i<N; i++) {
                teams[i] = new Team(i+1, new Score[K]);
            }

            for(int c=0; c<m; c++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken()) - 1; //id
                int j = Integer.parseInt(st.nextToken()) - 1; //문제번호
                int s = Integer.parseInt(st.nextToken()); //획득 점수
                teams[i].setScore(j, s, c);
            }

            Arrays.sort(teams);
            int cnt = 0;
            for (Team team : teams) {
                cnt++;
                if(team.id == id) {
                    sb.append(cnt).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    static class Score {
        int score;
        int count;

        public Score() {
        }

        public Score(int score, int count) {
            this.score = score;
            this.count = count;
        }
    }

    static class Team implements Comparable<Team> {
        int id;
        Score[] scores;
        int cnt;
        int lastTime;

        public Team(int id, Score[] scores) {
            this.id = id;
            this.scores = scores;
        }

        public void setScore(int idx, int score, int idx2) {
            if(scores[idx] == null) {
                scores[idx] = new Score(score, 1);
                cnt++;
                lastTime = idx2;
                return;
            }
            if(scores[idx].score < score) {
                scores[idx].score = score;
            }
            cnt++;
            lastTime = idx2;
        }

        private int totalScore() {
            int total = 0;
            for (Score score : scores) {
                if(score == null) {
                    continue;
                }
                total += score.score;
            }
            return total;
        }

        @Override
        public int compareTo(Team o) {
            int totalScore = totalScore();
            int totalScore2 = o.totalScore();
            if(totalScore == totalScore2) {
                if(o.cnt == cnt) {
                    return lastTime - o.lastTime;
                }
                return cnt - o.cnt;
            }
            return totalScore2 - totalScore;
        }
    }
}
