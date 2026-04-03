package Programmers.Hyeon.lv2;

import java.util.Arrays;

public class 전화번호_목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);

            for (int i = 1; i < phone_book.length; i++) {
                if (phone_book[i].startsWith(phone_book[i - 1])) {
                    return false;
                }
            }
            return true;
        }
    }
}

// lv2 전화번호 목록 문자열
// 20분
// trouble shooting
// 12, 115, 123 에 대해서 정렬했다고 생각했는데 "12" , "115", "123" 의 정렬은 "115", "12", "123" 이어서
// 잘못 생각해서 풀이가 오래걸렸다. AI 덕에 해결
// 그래서 정렬한다음 인접 접두를 비교하기에 startsWith 메소드로 슬라이딩 윈도우처럼 해결
