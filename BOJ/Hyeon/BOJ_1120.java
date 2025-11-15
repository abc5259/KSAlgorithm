package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int lenA = A.length();
        int lenB = B.length();

        int maxSame = 0;

        for (int i = 0; i <= lenB - lenA; i++) {
            int curSame = 0;
            for (int j = 0; j < lenA; j++) {
                if (A.charAt(j) == B.charAt(i + j)) {
                    curSame++;
                }
            }
            maxSame = Math.max(maxSame, curSame);
        }
        System.out.println(lenA - maxSame);
    }
}
// S4 문자열 슬라이딩 윈도우
// 18분
// 일단 2개의 조건이 있는데 차이가 최소가 되어야 하고 2개의 문자열이 길이가 같아야 한다
// 입력부터 같게 줄 경우 if 로 나눴고 같은 갯수를 증가해서 A의길이에서 뺴주면 이제
// 같은거 제외하고 모자른 자리는 B의 자리로대체한다고 쳤을 때 다른거만 구할 수 있었고
// B가 무조건 길이가 크거나 같기에 B에서 A의 길이만 큼 탐색한다 그래서 같은 경우의 개수가 가장 클때의 값을 통해서 lenA에서 빼줬다.