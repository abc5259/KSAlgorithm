package BOJ.JaeIk.retry;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_25501 {
    static int n;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for(int i=0; i<num; i++){
            n = 0;
            String str = scanner.next();
            System.out.println(isPalindrome(str)+" "+n);

        }


    }
    static int recursion(String s, int l, int r){
        n++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
