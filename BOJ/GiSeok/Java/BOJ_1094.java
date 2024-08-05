/**
 * 1094 - 막대기 [성공|00:19:23]
 * 실버5, 구현, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1094 {
    // 시간제한 2초, 메모리제한 128MB
    // 64cm인 막대를 가짐. 길이가 Xcm인 막대가 가지고 싶은 상태
    // 64cm를 더 작은 막대로 잘라 길이가 Xcm인 막대를 만들려고 함.
    // 자르는 과정
    // 1. 지민이가 가진 막대의 길이를 모두 더한다. 처음엔 64cm 막대 하나만 가짐.
    //    이때, 합이 X보다 크다면, 아래와 같은 과정을 반복.
    //    1. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
    //    2. 위에서 자른 막대 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른
    //       막대의 절반 중 하나를 버린다.
    // 2. 남아있는 모든 막대를 풀로 붙여 Xcm를 만든다.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);
        int sum = 64;
        
        while (sum != x) {
            int stk = pq.poll();
            stk >>= 1;

            pq.add(stk);
            sum = 0;
            for (int s : pq) sum += s;
            if (sum < x) pq.add(stk);
        }

        System.out.println(pq.size());
    }
}
