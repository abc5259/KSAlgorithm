package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int[] totalInCnt = new int[K+1];
        int[] inCnt = new int[K+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++)  {
            arr[i] = Integer.parseInt(st.nextToken());
            totalInCnt[arr[i]]++;
        }

        Set<Integer> pulgSet = new HashSet<>();
        int answer = 0;
        for(int i=0; i<K; i++) {

            int in = arr[i];
            //이미 있다면 걍 ㄱ
            if(pulgSet.contains(in)) {
                inCnt[in]++;
                continue;
            }

            if(pulgSet.size() >= N) { //플러그 다참

                //절대 뒤에 사용안하는 전기용품 부터 찾기

                int plug = findZeroPlug(pulgSet, totalInCnt, inCnt);

                if(plug == -1) {
                    plug = findLastPlug(K, i, pulgSet, arr);
                }

                pulgSet.remove(plug);
                pulgSet.add(in);
                answer++;
            }else { //플러그 다 안찾으면 무조건 ㄱ
                pulgSet.add(in);
            }

            inCnt[in]++;
        }

        System.out.println(answer);
    }

    private static int findZeroPlug(Set<Integer> pulgSet, int[] totalInCnt, int[] inCnt) {
        List<Integer> list = new ArrayList<>(pulgSet);
        for (int plug : list) {
            int dif = totalInCnt[plug] - inCnt[plug];
            if(dif == 0) {
                return plug;
            }
        }

        return -1;
    }

    private static int findLastPlug(int K, int i, Set<Integer> pulgSet, int[] arr) {
        int plug = -1;
        boolean[] isUsed = new boolean[K +1];
        for(int j = i +1; j< K; j++) {
            if(pulgSet.contains(arr[j]) && !isUsed[arr[j]]) {
                isUsed[arr[j]] = true;
                plug = arr[j];
            }
        }

        return plug;
    }

}
