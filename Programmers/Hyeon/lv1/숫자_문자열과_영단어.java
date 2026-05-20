package Programmers.Hyeon.lv1;

public class 숫자_문자열과_영단어 {
    class Solution {
        public int solution(String s) {

            String[] n = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < 10; i++) {
                s = s.replace(n[i], Integer.toString(i));
            }
            return Integer.parseInt(s);
        }
    }
}
// lv1 2021 카카오 채용연계형 인턴십 숫자 문자열과 영단어 문자열
// 8분
// 그냥 풀었다. 문자열로 주어진 파라미터에 대해서 숫자가 영어단어로 번역되었다 예를들어 one4six 를 146으로 출력하기위해선?
// 문자열 배열에 zero ~ nine 까지 저장해둔다음
// 주어진 s에 contains 를 확인하고 replace 로 s에 갱신한다 불변객체라서 덮어쓴다. -> 그냥 replace 로 해서 없으면 그대로 가져가게함.