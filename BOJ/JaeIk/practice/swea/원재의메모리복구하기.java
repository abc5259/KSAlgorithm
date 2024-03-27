package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 원재의메모리복구하기
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int tc=0; tc<n; tc++) {
            String original = br.readLine();
            char[] originalArr = original.toCharArray();

            int[] bitArr = new int[originalArr.length];
            for(int i=0; i<originalArr.length; i++) {
                bitArr[i] = Character.getNumericValue(originalArr[i]);
            }

            System.out.println("#"+(tc+1)+" "+getAnswer(bitArr));
        }
    }

    static int getAnswer(int[] bitArr) {
        int answer = 0;
        int[] basic = new int[bitArr.length];
        Arrays.fill(basic, 0);

        for(int i=0; i<bitArr.length; i++) {
            if(bitArr[i] != basic[i]) {
                if(bitArr[i] == 1) {
                    answer++;
                    for(int j=i; j<basic.length; j++) {
                        basic[j] = 1;
                    }
                }
                else if(bitArr[i] == 0) {
                    answer++;
                    for(int j=i; j<basic.length; j++) {
                        basic[j] = 0;
                    }
                }

                if(isSame(basic, bitArr)){
                    break;
                }
            }
        }

        return answer;
    }

    static boolean isSame(int[] basic, int[] bitArr) {
        for(int i=0; i<basic.length; i++) {
            if(basic[i] != bitArr[i])return false;
        }

        return true;
    }
}
