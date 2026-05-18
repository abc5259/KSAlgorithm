package Programmers.Hyeon.lv1;

public class 신규_아이디_추천 {
    class Solution {
        public String solution(String new_id) {
            new_id = new_id.toLowerCase();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < new_id.length(); i++) {
                char c = new_id.charAt(i);
                if (('a' <= c && 'z' >= c) || ('0' <= c && '9' >= c) || (c == '-' || c == '_' || c == '.')) {
                    sb.append(c);
                }
            }

            new_id = sb.toString();

            while (new_id.contains("..")) {
                new_id = new_id.replace("..", ".");
            }

            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1);
            }

            if (new_id.isEmpty()) {
                new_id = "a";
            } else {
                if (new_id.charAt(new_id.length() - 1) == '.') {
                    new_id = new_id.substring(0, new_id.length() - 1);
                }
            }

            if (new_id.length() > 15) {
                new_id = new_id.substring(0, 15);

                if (new_id.charAt(14) == '.') {
                    new_id = new_id.substring(0, 14);
                }
            }

            while (new_id.length() <= 2) {
                char add = new_id.charAt(new_id.length() - 1);
                new_id = new_id + add;
            }

            return new_id;
        }
    }
}
// lv1 2021 KAKAO BLIND RECRUITMENT 신규 아이디 추천 문자열
// 13분
// 일단 풀었다. 주어진 대로 수행하면되었고
// 소문자는 toLowerCase 쓰고 규칙 내 문자는 StringBuilder 로 가변객체로 만들었다.
// 적절히 문자열 메소드 사용했다 indexOf 로 .. 이상있는 문자열 반복해서 찾고 아 이건 contains 쓰는게 더 나았겠다.
// 맨앞은 0으로 확인 비었으면 a 해주고 아니면 맨끝에 . 떼는거 substring 적절하게 사용.
// 2이하면 반복문 돌려서 확장.