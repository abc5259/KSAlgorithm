package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] switchs = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      switchs[i] = Integer.parseInt(st.nextToken());
    }

    int cnt = Integer.parseInt(br.readLine());
    for(int c=0; c<cnt; c++) {
      st = new StringTokenizer(br.readLine());
      int sex = Integer.parseInt(st.nextToken());
      int idx = Integer.parseInt(st.nextToken());

      if(sex == 1) { //남학생이라면 
        for(int i=1; idx*i<=N; i++) {
         int currIdx = idx * i;
          changeSwitch(switchs, currIdx); 
        }
      }
      else if(sex == 2) { //여학생이라면 
        changeSwitch(switchs, idx); // 받은 번호 스위칭 

        int left = idx - 1;
        int right = idx + 1;
        while(left > 0 && right <= N) {
          if(switchs[left] == switchs[right]) {
            changeSwitch(switchs,left);
            changeSwitch(switchs,right);
            left--;
            right++;
          }else {
            break;
          }
        }
        
      }
    }
    StringBuffer sb = new StringBuffer();
    for(int i=1; i<=N; i++) {
      sb.append(switchs[i] + " ");
      if(i % 20 == 0) sb.append("\n");
    }
    System.out.println(sb);

  }

  private static void changeSwitch(int[] switchs, int currIdx) {
    if(switchs[currIdx] == 1) switchs[currIdx] = 0;
    else switchs[currIdx] = 1;
  }
}
