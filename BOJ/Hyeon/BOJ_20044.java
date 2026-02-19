package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int s = 2 * n; // 총 학생 수는 2n명

        int[] skills = new int[s];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            skills[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(skills);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int teamSkill = skills[i] + skills[s - 1 - i];
            min = Math.min(min, teamSkill);
        }

        System.out.println(min);
    }
}
// S4 Project Teams 그리디
// 30분
// 다시 풀어보기 몸상태가 안좋아서 오래걸림