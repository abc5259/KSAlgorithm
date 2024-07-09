/**
 * 11655 - ROT13
 * 문자열, 브론즈1
 * 카이사르 암호 알고리즘 문제이다.
 * 소문자 범위와 대문자 범위로 나누어 계산해야 하는데,
 * 13을 더했을 때 범위가 넘어도 좌표 평행 이동한 것과 똑같으므로 알파벳 범위인 26을 빼주면,
 * 원래 출력해야 할 알파벳으로 좌표 이동함.
 */

 package BOJ.GiSeok.Java;

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 
 public class BOJ_11655 {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String plain = br.readLine();
         
         for (int i = 0; i < plain.length(); i++) {
             char w = plain.charAt(i);
 
             if (w >= 'a' && w <= 'z') {
                 w += 13;
                 if (w > 'z') w -= 26;
             }
             else if (w >= 'A' && w <= 'Z') {
                 w += 13;
                 if (w > 'Z') w -= 26;
             }
 
             System.out.print(w);
         }
         System.out.println();
     }
 }
 