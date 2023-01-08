package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11728 {
    static int[] AB;

    public static void mergeSort(int[] ab, int start, int end) {

        if (start == end) return;

        int mid = (start + end) / 2;
        mergeSort(ab, start, mid);
        mergeSort(ab, mid+1, end);

        int left = start;
        int right = mid+1;
        int idx = 0;
        int[] tmp = new int[end-start+1];

        while (left <= mid && right <= end) {
            if (ab[left] > ab[right]) {
                tmp[idx++] = ab[right++];
            } else {
                tmp[idx++] = ab[left++];
            }
        }

        while (left <= mid)
            tmp[idx++] = ab[left++];
        while (right <= end)
            tmp[idx++] = ab[right++];
        
        for (int i = start; i <= end; i++)
            ab[i] = tmp[i-start];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2;

        AB = new int[Integer.parseInt(st1.nextToken()) + Integer.parseInt(st1.nextToken())];

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < AB.length; i++) {
            if (st1.hasMoreTokens())
                AB[i] = Integer.parseInt(st1.nextToken());
            else
                AB[i] = Integer.parseInt(st2.nextToken());
        }

        mergeSort(AB, 0, AB.length-1);
        
        for (int i = 0; i < AB.length; i++)
            bw.write(AB[i] + " ");
        bw.write("\n");
        
        bw.flush();
    }
}
