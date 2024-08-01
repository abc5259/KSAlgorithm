/**
 * 2109 - 순회강연 [실패|01:19:37]
 * 골드3, 그리디
 * 
 * 문제가 헷갈린다
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109 {
    // n개의 대학에서 강연 요청
    // 각 대학에서 d일 안에 와서 강연하면 p 강연료 줌
    // 가장 많은 돈을 벌 수 있도록 순회 강연할거임.

    // ------- 문제 이해 못함 ---------
    // d일 기준으로 오름차순 정렬한담에.
    // 같은 d일에서 가장 강연료 큰거 집으면 최적아닌가?
    // 근데 정렬이 10000^2 = 10억이니까
    // day를 idx로 쓰면서 더 큰값 입력마다 갱신
    // 그럼 10000에 해결 가능

    static class Pair {
        int d, p;

        Pair(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Pair> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            v.add(new Pair(d, p));
        }

        Collections.sort(v, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.d > p2.d) return 1;
                else if (p1.d < p2.d) return -1;
                else {
                    if (p1.p > p2.p) return 1;
                    else return -1;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(v.get(i).p);
            if (v.get(i).d < pq.size()) pq.poll();
        }

        int ret = 0;
        while (!pq.isEmpty()) ret += pq.poll();

        System.out.println(ret);
    }
}
