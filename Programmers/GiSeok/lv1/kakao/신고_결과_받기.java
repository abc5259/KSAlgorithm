package Programmers.GiSeok.lv1.kakao;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class 신고_결과_받기 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Set<String> reportSet = new HashSet<>();
            int[] reportCnt = new int[id_list.length];
            int[] answer = new int[id_list.length];

            for (int i = 0; i < report.length; i++) {
                reportSet.add(report[i]);
            }

            // 신고 횟수 세기
            for (String repo: reportSet) {
                String defendant = repo.split(" ")[1];
                reportCnt[Arrays.asList(id_list).indexOf(defendant)] += 1;
            }

            for (String repo: reportSet) {
                String plaintiff = repo.split(" ")[0];
                String defendant = repo.split(" ")[1];

                if (reportCnt[Arrays.asList(id_list).indexOf(defendant)] >= k) {
                    answer[Arrays.asList(id_list).indexOf(plaintiff)] += 1;
                }
            }
            
            return answer;
        }
    }

    public static void main(String[] args) {
        신고_결과_받기 parent = new 신고_결과_받기();
        신고_결과_받기.Solution sol = parent.new Solution();

        // test case 1
        String[] t1_id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] t1_report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int t1_k = 2;

        int[] result = sol.solution(t1_id_list, t1_report, t1_k);
        for (int i = 0; i < t1_id_list.length; i++)
            System.out.print(Integer.toString(result[i]) + ' '); // 2 2 1 0
        System.out.println();

        // test case 2
        String[] t2_id_list = {"con", "ryan"};
        String[] t2_report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int t2_k = 3;

        result = sol.solution(t2_id_list, t2_report, t2_k);
        for (int i = 0; i < t2_id_list.length; i++)
            System.out.print(Integer.toString(result[i]) + ' '); // 2 2 1 0
        System.out.println();
    }
}
