package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nA; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            A.remove(Integer.parseInt(st.nextToken()));
        }

        int res = A.size();

        if (res == 0) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Integer value : A) {
            pq.offer(value);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(res);
        System.out.println(sb);
    }
}
// S4 차집합 Set
// 6분
// 그냥 말그대로 차집합인데 A 에 있는게 B 에 없어야 되는 것들의 개수이다.
// 그래서 A 를 Set 자료구조에 넣었다 O(1) 이기에 그리고 B 에 있는거를 remove 시키고
// 남는 A 에 대해서 PQ를 통해서 오름차 진행시키고 res 는 A 의 size 로 O(1) 로 사용
// 시간복잡도는 각각 50만인데 그래서 O(1) 연산들이 필요하다고 생각.