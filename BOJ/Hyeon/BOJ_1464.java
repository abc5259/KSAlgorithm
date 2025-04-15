package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();
        deque.offer(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur > deque.peekFirst()) {
                deque.offerLast(cur);
            } else {
                deque.offerFirst(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : deque) {
            sb.append(c);
        }
        System.out.print(sb);
    }
}

// G4 뒤집기 덱
// 문자열의 순서에 있어서 덱을 사용해서 앞뒤로 왓따갔다 근데 비교하는 방식이 deque의 맨 앞을 비교해서
// 그보다 현재값이 크면 덱의 맨 끝으로 , 맨 앞보다 작을경우에만 offerFirst 한다.

// 생각하는 접근이 어려웠떤 문제
// 비교대상이 가장 맨앞에 있는 숫자 -> 나보다 작아야만 나앞이고 나랑 같거나 보다 크면 맨뒤로 보낸다.
