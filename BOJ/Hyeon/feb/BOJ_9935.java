package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        String bomb = br.readLine();
        int len = bomb.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
            if (stack.size() >= len) {
                boolean check = false;
                for (int j = 0; j < len; j++) {
                    if (stack.get(stack.size() - len + j) == bomb.charAt(j)) {
                        check = true;
                    } else {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int k = 0; k < len; k++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
// G4 스택
// 일단 전체적으로 문자들을 순서대로 스택에 넣는다. 그 스택에서 폭탄 문자열 갯수만큼을 검사해나간다. 근데 현재 스택 개수가 폭탄보다 커야
// 폭탄의 유무를 알 수 있고 현재 스택개수 - 문자열의 개수 하면 제일 끝 문자열만 비교할 수 있는 인덱스를 구할 수 있다.
// 예를들면 123을 스택에 넣었고 폭탄 문자열이 23이라면 12일때는 23과 달라서 폭탄을 감지못하지만 size가 3일경우
// 3 - 2를 통해 1인덱스인 2와 2인덱스인 3을 비교하여 폭탄을 감지 할 수 있다.