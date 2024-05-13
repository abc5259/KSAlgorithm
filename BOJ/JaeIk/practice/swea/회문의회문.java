package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class 회문의회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String input = br.readLine();

            List<Character> list = new ArrayList<>();
            for(char c : input.toCharArray()){
                list.add(c);
            }

            List<Character> part1 = new ArrayList<>();
            for(int i=0; i<input.length()/2; i++){
                part1.add(list.get(i));
            }

            List<Character> part2 = new ArrayList<>();
            for(int i=input.length()/2+1; i<input.length(); i++){
                part2.add(list.get(i));
            }


            String answer = (isPalindrome(list) && isPalindrome(part1) && isPalindrome(part2))?"YES":"NO";

            System.out.println("#"+(tc+1)+" "+answer);
        }


    }

    static boolean isPalindrome(List<Character> list1){
        List<Character> list2 = new ArrayList<>(list1);
        Collections.reverse(list1);

        return list1.equals(list2);
    }
}
