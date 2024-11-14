/**
 * 1983. 조교의 성적 매기기 (D2|구현) [O|00:18:06]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1983 {

    static int[] percent = {35, 45, 20};
    static String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] student = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    int score = Integer.parseInt(st.nextToken());
                    student[i] += (score * percent[j] / 100);
                }
            }

            String[] studentGrade = new String[n];
            for (int idx = 0; idx < 10; idx++) {
                for (int i = 0; i < n/10; i++) {
                    int max = 0;
                    int maxIdx = -1;
                    for (int j = 0; j < n; j++) {
                        if (max < student[j] && studentGrade[j] == null) {
                            max = student[j];
                            maxIdx = j;
                        }
                    }
                    studentGrade[maxIdx] = grade[idx];
                }
            }

            System.out.println("#" + t + " " + studentGrade[k-1]);
        }
    }
}