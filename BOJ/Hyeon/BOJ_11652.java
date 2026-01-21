package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> cards = new HashMap<>();

        while (N-- > 0) {
            long num = Long.parseLong(br.readLine());
            cards.put(num, cards.getOrDefault(num, 0) + 1);
        }

        long res = 0;
        long ans = Long.MAX_VALUE;

        for (Map.Entry<Long, Integer> entry : cards.entrySet()) {
            long key = entry.getKey();
            long cnt = entry.getValue();

            if (res < cnt || (res == cnt && key < ans)) {
                res = cnt;
                ans = key;
            }
        }

        System.out.println(ans);
    }
}
// S4 카드 Map
// 16분
// 일단 내 고민은 10만이 주어져서 이게 최악이 됐을 경우 정렬하면 10^2 이게 될거같은거야 이럴때는 그러면
// 컬렉션을 써서 정렬을 하면 N log n 이 되는건가??? 싶은데 Map 자료구조로 N번 연산하는게 더 낫다 생각.
// Map 자료구조로 접근을 하고 key 값으로 비교를 하려고 했는데 생각해보니 KeySet은 Set 자료구조를 통해 구현된거라
// 순서가 보장이 안돼서 내가 가지고있는 갯수보다 같은 수가 나와도 이게 키값이 순차적인게 아니라서
// 나보다 키값이 큰지 작은지 모른채로 대입이 되는 문제가 발생한다고 생각
// 그래서 내가 가지고 있는 갯수랑 같은 경우 이 키값이 나보다 작은지 조건을 덧붙였다.