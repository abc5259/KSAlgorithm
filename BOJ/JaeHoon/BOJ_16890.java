package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int length = arr1.length;

        arr1 = Arrays.copyOfRange(arr1, 0, length % 2 == 0 ? length / 2 : length / 2 + 1);
        arr2 = Arrays.copyOfRange(arr2, length % 2 == 0 ? length / 2 : length / 2 + 1, length);

        Character[] name = new Character[length];

        boolean flag = true;
        int idx1 = 0;
        int idx11 = arr1.length - 1;
        int idx2 = arr2.length - 1;
        int idx22 = 0;
        int front = 0;
        int back = length - 1;
        for(int i=0; i<length; i++) {
//            System.out.println(Arrays.toString(name));
            if(flag) {
                if(idx2 > -1 && arr1[idx1] - arr2[idx2] >= 0) {
                    name[back--] = arr1[idx11--];
                }else {
                    name[front++] = arr1[idx1++];
                }
            }else {
                if(idx1 < arr1.length && arr2[idx2] - arr1[idx1] <= 0) {
                    name[back--] = arr2[idx22++];
                }else {
                    name[front++] = arr2[idx2--];
                }
            }

            flag = !flag;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append(name[i]);
        }

        System.out.println(sb);
    }
}
