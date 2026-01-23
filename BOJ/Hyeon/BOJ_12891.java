package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_12891 {
    static int ansA, ansC, ansG, ansT;
    static Map<Character, Integer> pw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        ansA = Integer.parseInt(st.nextToken());
        ansC = Integer.parseInt(st.nextToken());
        ansG = Integer.parseInt(st.nextToken());
        ansT = Integer.parseInt(st.nextToken());

        pw = new HashMap<>();
        pw.put('A', 0);
        pw.put('C', 0);
        pw.put('G', 0);
        pw.put('T', 0);

        // 초기 비밀번호 가능성
        for (int i = 0; i < P; i++) {
            char tmp = arr[i];
            pw.put(tmp, pw.get(tmp) + 1);
        }

        int cnt = 0;

        if (isPw()) {
            cnt++;
        }

        // 슬라이딩 윈도우
        for (int i = 1; i <= S - P; i++) {
            char lo = arr[i - 1];
            pw.put(lo, pw.get(lo) - 1);

            char ri = arr[i - 1 + P];
            pw.put(ri, pw.get(ri) + 1);
            if (isPw()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isPw() {
        return (pw.get('A') >= ansA) && (pw.get('C') >= ansC) && (pw.get('G') >= ansG) && (pw.get('T') >= ansT);
    }
}
// S2 DNA 비밀번호 슬라이딩 윈도우
// 30분
// 일단 문제에서 주어진 P 와 S 에 대한 값이 100만 인거보고 이게 부분 문자열을 구해야되면 완탐으로는 O(N^2)인것을 이해하고
// 무조건 슬라이딩 윈도우 밖에 방법이 없겠다고 판단 앞을 자르고 뒤를 붙여가며 이를 O(N) 번 반복하는것
// 그런데 ACGT 에 해당하는 문자열의 최소 값인 ans 변수를 선언하고 또
// 앞을 잘라야하기때문에 맨 앞기준에는 이를 못할 거 같아서 그냥 초기 비밀번호 가능성일때 isPW 를 통해서 판별을 하고
// 그다음부터 1 인덱스부터 슬라이딩 윈도우 했다 그래서 이 반복문이 조금 어색하다
// 더해서 MAP 자료구조를 사용했는데 내가 지금까지의 값을 어떻게 기억하고 있냐에 따라서 배열로 접근해서 차감을 할까 라는 고민을 못했다
// 그냥 문자와 숫자 의 자료구조를 떠올려서 키밸류로 접근했는데 문자 카운팅 배열로 pw['A']-- 이런거로 했어도 됐긴 했겠네,,