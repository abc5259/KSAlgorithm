package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2751 {
    public static int[] n;

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start+end)/2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        int sortIdx = 0;
        int left = start;
        int right = mid+1;

        int[] tmp = new int[end+1-start];
        while (left < mid+1 && right < end+1) {
            if (n[left] <= n[right]) {
                tmp[sortIdx++] = n[left++];
            } else {
                tmp[sortIdx++] = n[right++];
            }
        }

        while (left < mid+1)
            tmp[sortIdx++] = n[left++];
        while (right < end+1)
            tmp[sortIdx++] = n[right++];
        
        for (int i = start; i < end+1; i++)
            n[i] = tmp[i-start];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        n = new int[N];

        for (int i = 0; i < N; i++)
            n[i] = Integer.parseInt(br.readLine());

        mergeSort(0, N-1);
        for (int i = 0; i < N; i++)
            bw.write(n[i]+"\n");

        bw.flush();
        bw.close();
    }
}
