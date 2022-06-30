package BOJ.GiSeok;
import java.util.Scanner;
import java.util.Stack;

public class Baek_9093 {
    public static void main(String[] args) {
        Stack<String> stk1 = new Stack<>();
        StringBuffer sb;
        Scanner scan = new Scanner(System.in);
        String str, word;
        int cnt;

        cnt = scan.nextInt();
        scan.nextLine();        // 버퍼 안에 남은 개행문자 삭제
        for (int i = 0; i < cnt; i++) {
            str = scan.nextLine();

            sb = new StringBuffer(str);
            str = sb.reverse().toString();
            // str 문장 반대로 뒤집고

            String[] strToWord = str.split(" ");
            // 단어 별로 분리

            for (String s:strToWord) {
                stk1.push(s);        // 그 후 한 단어씩 스택에 추가
            }

            while (!stk1.empty()) {  // 스택이 빌 때까지 단어 하나씩 pop해서 출력 (스택 원리로 문장 순서는 원래대로, 단어만 뒤집힌 채 나옴)
                word = stk1.pop();
                System.out.print(word + ' ');
            }
            System.out.println("");
        }
    }
}