/**
 * 14469 - 소가 길을 건너간 이유 3 [성공|00:14:43]
 * 실버4, 그리디, 시도1
 * 
 * 어떤 방식으로 선택하든 전체 시간이 같기 때문에,
 * 그냥 정렬 후에 선입선출 식으로 처리해도 된다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_14469 {
    // 시간제한 2초, 메모리제한 512MB
    // N 마리의 소가 농장에 방문
    // 소가 도착한 시간과 검문받는 시간은 소마다 다르다.
    // 5초에 도착했고 7초동안 검문 받으면 8초에 도착한 소는 12초까지 기다려야 검문받을 수 있다.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cow = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cow[i][0] = Integer.parseInt(st.nextToken());
            cow[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cow, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int time = 0;
        for (int i = 0; i < N; i++) {
            if (time < cow[i][0])
                time += (cow[i][0] - time);

            time += cow[i][1];
        }

        System.out.println(time);
    }
}
