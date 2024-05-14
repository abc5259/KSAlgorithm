package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 회문22 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++){
            int T = Integer.parseInt(br.readLine());

            map = new char[100][100];
            for(int i=0; i<100; i++){
                map[i] = br.readLine().toCharArray();
            }

            int max = Integer.MIN_VALUE;
            for(int i=0; i<100; i++){

                for(int j=0; j<99; j++){
                    for(int k=j+1; k<100; k++){
                        if(isPalindrome1(i, j, k)){
                            max = Math.max(max, k-j+1);
                        }

                        if(isPalindrome2(i, j, k)){
                            max = Math.max(max, k-j+1);
                        }
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+max);
        }
    }

    static boolean isPalindrome1(int row , int start, int end){
        List<Character> part1 = new ArrayList<>();
        for(int i=start; i<=end; i++){
            part1.add(map[row][i]);
        }

        List<Character> part2 = new ArrayList<>(part1);
        Collections.reverse(part2);

        return part1.equals(part2);
    }

    static boolean isPalindrome2(int col , int start, int end){
        List<Character> part1 = new ArrayList<>();
        for(int i=start; i<=end; i++){
            part1.add(map[i][col]);
        }

        List<Character> part2 = new ArrayList<>(part1);
        Collections.reverse(part2);

        return part1.equals(part2);
    }
}
