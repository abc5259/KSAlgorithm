package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2980 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    Light[] lights = new Light[L];
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken());
      lights[idx] = new Light(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    int answer = 0;
    for(int i=1; i<L; i++) {
      if(lights[i] == null)  {
        answer++;
      }else {
        int[] redWithRest = lights[i].isRed(answer);
        if(redWithRest[0] == 0) answer++;
        else {
          answer += redWithRest[1];
          answer++;
        }
      }
    }
    System.out.println(answer);
  }
  static class Light {
    int redTime, blueTime;
    Light(int redTime, int blueTime) {
      this.redTime = redTime;
      this.blueTime = blueTime;
    }
    public int[] isRed(int time) {
      int rest = time % (redTime + blueTime);
      if(rest <= redTime){
        return new int[]{1,redTime - rest};
      }
      return new int[]{0,blueTime + redTime - rest};
    }
  }
}
