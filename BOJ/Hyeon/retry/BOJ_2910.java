package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Sequence> map = new HashMap<>();
        List<Sequence> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (!map.containsKey(value)) {
                Sequence s = new Sequence(value, 0, i);
                map.put(value, s);
                list.add(s);
            }
            map.get(value).cnt++;
        }
        Collections.sort(list);
        for (Sequence s : list) {
            while (s.cnt-- > 0) {
                sb.append(s.num).append(" ");
            }
        }
        System.out.println(sb);

    }

    static class Sequence implements Comparable<Sequence> {
        int num;
        int cnt;
        int prior;

        public Sequence(int num, int cnt, int prior) {
            this.num = num;
            this.cnt = cnt;
            this.prior = prior;
        }

        @Override
        public int compareTo(Sequence o) {
            if (o.cnt == this.cnt) {
                return this.prior - o.prior;
            }
            return o.cnt - this.cnt;
        }
    }
}

// S3 빈도 정렬 해시
// 메모리 초과났음 왜냐하면 C가 10억까지 되니까 인트 인덱스가 수도 없이 커짐 그래서 숫자를 인덱스로 관리하면안된다.
// 4바이트 * 3 * 10억 == 120억바이트라서 크기가 128메가 바이트보다 현저히 크다.
// 다른 풀이 if 조건을 걸었고 map과 정렬된 list를 사용