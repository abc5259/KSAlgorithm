/**
 * 3986 - 좋은 단어 [성공/13:03]
 * 스택, 실버4, 시도1
 * 
 * 선의 교차없이 같은 문자로 쌍이 지어지는 단어를 찾는 문제
 * 즉, 중간에 A, B의 방해없이 AA, BB가 된다면 좋은 단어가 된다.
 * 후위표기식처럼 스택을 활용해 결국에 A*A, B*B로 만난다면 스택을 비우는 방법으로 풂
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_3986 {
    // 모든 글자가 A, B
    // A는 A끼리 B는 B끼리 짝을 지음.
    // 선끼리 교차하지 않으면서 서로 짝이 지어지면 좋은 단어
    // ABAB -> 좋은 단어x
    // AABB -> 좋은 단어o
    // ABBA -> 좋은 단어o

    // 후위표기식을 푸는 방법인 스택으로 해결할 수 있을 것 같다.

    static ArrayDeque<Character> box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String words = br.readLine();
            box = new ArrayDeque<>();

            for (int x = 0; x < words.length(); x++) {
                char word = words.charAt(x);
                if (!box.isEmpty()) {
                    if (box.peek() == word)
                        box.removeFirst();
                    else
                        box.addFirst(word);
                } else { box.addFirst(word); }
            }

            if (box.size() == 0) cnt++;
        }

        System.out.println(cnt);
    }
}
