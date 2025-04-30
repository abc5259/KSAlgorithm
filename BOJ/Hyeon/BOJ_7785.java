package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String emp = st.nextToken();
            String state = st.nextToken();

            if (state.equals("enter")) {
                set.add(emp);
            } else {
                set.remove(emp);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(set);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
//
//        List<String> list = new LinkedList<>(set);
//        list.sort(Comparator.reverseOrder());
//
//        StringBuilder sb = new StringBuilder();
//        for (String s : list) {
//            sb.append(s).append("\n");
//        }
        System.out.print(sb);
    }
}

// S5 회사에 있는 사람 SET
// 일단 삽입삭제의 조회가 O(1) 인 SET 을 이용하고 그리고 역순을 만들어야되는데
// PQ를 써서 하려고 했다가 pq에서 그냥 반복문 접근했는데 힙정렬이 되어있어서
// PQ는 그렇게 뺴면 안됐었다
// trouble shooting
// pq.poll 이게 올바른 접근 방법
// String s: pq sout(s) 이거는 잘못된거다
// 그래서 List 로 했었는데 어거지였다.