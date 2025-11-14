package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String find = br.readLine();

        int cnt = 0;

        while (str.contains(find)) {
            str = str.substring(str.indexOf(find) + find.length());
            cnt++;
        }
        System.out.println(cnt);
    }
}
// S5 문서 검색 문자열
// 8분
// 다시 푼 문젠데 String 메소드 학습을 통해 개선된 풀이를 제공한다
// 일단 Str 이 주어지고 find 로 찾는 건데
// 중복 없이 찾아야 하기 때문에 문자열을 새로고침 하듯이 객체를 다시 만들어줘야 된다
// 그래서 str에 contains 로 일단 찾고자하는 문자열 find 가 있는지 점검하고
// 있다면 substring 으로 객체 다시 만들어주고 찾은 인덱스 + 길이를 매개변수로 넘겨서 한다
// 그래서 이 카운팅을 통해 정답 추출