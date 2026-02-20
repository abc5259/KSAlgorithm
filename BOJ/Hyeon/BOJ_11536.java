package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> increase = new ArrayList<>();
        List<String> decrease = new ArrayList<>();
        List<String> input = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            increase.add(name);
            decrease.add(name);
            input.add(name);
        }

        Collections.sort(increase);
        Collections.sort(decrease, Collections.reverseOrder());

        if (increase.equals(input)) {
            System.out.println("INCREASING");
        } else if (decrease.equals(input)) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
// S5 줄 세우기 정렬
// 6분
// 그냥 쉽게 풀었다. 순서와 값이 같은지를 비교해야됐고 이는 순서가 있는 List 썻고 뒤에 계속 추가하니
// Array 쓴다음 Collections 으로 정렬 해버렷다 그리고
// 리스트간 순서와 값이 같은지를 판단하는 equals 로 분기했다.