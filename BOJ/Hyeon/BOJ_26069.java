package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        StringTokenizer st;

        set.add("ChongChong");

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (set.contains(A)) {
                set.add(B);
            } else if (set.contains(B)) {
                set.add(A);
            }
        }
        System.out.print(set.size());
    }
}

// S4 붙임성 좋은 총총이
// 처음에 풀었을 때는 플래그를 두어서 Chong이 나올 때까지 플래그로 처리해두고
// 발견했다면 그때부터 포함되었을 경우에만 추가하는 로직을 짰는데
// 다른 풀이를 봤더니 처음부터 Chong을 넣어두고 포함관계 에 따라 add 하는 코드를 확인해봤다.