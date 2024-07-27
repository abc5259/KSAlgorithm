/**
 * 2529 - 부등호 [성공|00:34:10]
 * 실버1, 완전탐색, 시도1
 * 
 * 시간복잡도는 최악의 경우 o < o < o < ....
 * => 10! = 3628800 = 362만 (완탐 가능)
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2529 {
    // 시간제한 1초, 메모리제한 256MB
    // '<'와 '>'가 k개 나열된 순서열 A가 있다.
    // 모든 부등호 앞 뒤에 서로 다른 0~9 숫자를 넣어서 부등호 순서열을 만족시키고자 함.
    // 이렇게 만족한 숫자 중 부등호를 모두 제거해 숫자로 만들어 최솟값과 최댓값을 구하자.
    // 단, 선택된 숫자는 모두 달라야 함.

    // 2 <= k <= 9 부등호
    static int k;
    static int[] sign;
    static boolean[] visited = new boolean[10];
    static ArrayList<String> list = new ArrayList<>();
    
    static boolean isValid(int n1, int n2, int op) {
        if (n1 > n2 && op == '>') return true;
        if (n1 < n2 && op == '<') return true;
        return false;
    }

    static void dfs(int idx, String num) {
        if (idx == k + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            if (num.length() == 0 || isValid(num.charAt(idx - 1), i + '0', sign[idx-1])) {
                visited[i] = true;
                dfs(idx + 1, num + i);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        sign = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++)
            sign[i] = st.nextToken().charAt(0);

        dfs(0, "");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }
}
