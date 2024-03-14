package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class 회문검사
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            String input = br.readLine();

            int answer = isPalindrome(input);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static int isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        if(isEvenLength(input)) {
            for(int i=0; i<input.length()/2; i++) {
                stack.add(input.charAt(i));
            }

            int idx = input.length()/2;
            for(int i=idx; i<input.length(); i++) {
                if(stack.peek() == input.charAt(i)) {
                    stack.pop();
                }
            }
        }else {
            for(int i=0; i<input.length()/2; i++) {
                stack.add(input.charAt(i));
            }

            int idx = input.length()/2+1;
            for(int i=idx; i<input.length(); i++) {
                if(stack.peek() == input.charAt(i)) {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty())return 1;

        return 0;
    }

    static boolean isEvenLength(String input) {
        int length = input.length();

        if(length%2==0)return true;

        return false;
    }
}
