/**
 * 16637 - 괄호 추가하기 [실패]
 * 골드3, DFS
 * 
 * 얘는 풀이를 봐도 아리송하다.
 * 다음에 다시 풀어보기
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_16637 {
    // 시간제한 0.5초
    // 길이가 N인 수식 -> 0~9와 +,-,x로 이루어짐, 연산자 우선순위 동일
    // 괄호는 중첩될 수 없음.

    // 1 <= N <= 19

    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Integer> oper = new ArrayList<>();
    static int ret = Integer.MIN_VALUE;

    static int operation(int op, int n1, int n2) {
        if (op == '*') return n1 * n2;
        else if (op == '-') return n1 - n2;
        else if (op == '+') return n1 + n2;

        return 0;
    }

    static void go(int here, int _num) {
        if (here == nums.size() - 1) {
            ret = Math.max(_num, ret);
            return;
        }

        go(here + 1, operation(oper.get(here), _num, nums.get(here + 1)));

        if (here + 2 <= nums.size() - 1) {
            int temp = operation(oper.get(here + 1), nums.get(here + 1), nums.get(here + 2));
            go(here + 2, operation(oper.get(here), _num, temp));
        }

        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String exp = br.readLine();
        for (int i = 0; i < N; i++) {
            if (exp.charAt(i) >= '0' && exp.charAt(i) <= '9') nums.add(exp.charAt(i) - '0');
            else oper.add((int)exp.charAt(i));
        }

        go(0, nums.get(0));

        System.out.println(ret);
        
    }
}
