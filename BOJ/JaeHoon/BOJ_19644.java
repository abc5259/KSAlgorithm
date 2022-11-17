package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19644 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    int L = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int ML = Integer.parseInt(st.nextToken());
    int MK = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(br.readLine());
    int[] zombies = new int[L+1];
    boolean[] isUseC = new boolean[L+1];
    for(int i=1; i<=L; i++) {
      zombies[i] = Integer.parseInt(br.readLine());
    }
    int needC = 0;
    for(int i=1; i<=ML; i++) {
      if(i > L) break;
      int damage = MK * i;
      if(zombies[i] - damage > 0) {
        needC++;
        isUseC[i] = true;
      }
    }
    if(L > ML) {
      for(int i=ML+1; i<=L; i++) {
        if(zombies[i] - ML * MK > 0) {
          needC++;
          isUseC[i] = true;
        }
      }
    }
    if(needC <= C) {
      int plusBlood = 0;
      needC = 0;
      int limit = -1;
      for(int i=1; i<=ML; i++) {
        if(i > L) break;
        if(zombies[i] == 0) continue;
        if(isUseC[i]) {
          plusBlood += MK;
          limit = i + ML - 1;
          needC++;
          continue;
        }
        int damage = MK * i;
        if(limit == -1) {
          if(zombies[i] - damage > 0) {
            plusBlood += MK;
            limit = i + ML - 1;
            needC++;
          }
        }
        else {
          if(i <= limit) {
            if(zombies[i] + plusBlood - damage > 0) {
              plusBlood += MK;
              limit = i + ML - 1;
              needC++;
            }
          }else {
            if(zombies[i] - damage > 0) {
              plusBlood += MK;
              limit = i + ML - 1;
              needC++;
            }
          }
        }
      }
      if(L > ML) {
        for(int i=ML+1; i<=L; i++) {
          if(zombies[i] == 0) continue;
          if(isUseC[i]) {
            plusBlood += MK;
            limit = i + ML - 1;
            needC++;
            continue;
          }
          int damage = MK * ML;
          if(limit == -1) {
            if(zombies[i] - damage > 0) {
              plusBlood += MK;
              limit = i + ML - 1;
              needC++;
            }
          }
          else {
            if(i <= limit) {
              if(zombies[i] + plusBlood - damage > 0) {
                plusBlood += MK;
                limit = i + ML - 1;
                needC++;
              }
            }else {
              if(zombies[i] - damage > 0) {
                plusBlood += MK;
                limit = i + ML - 1;
                needC++;
              }
            }
          }
        }
      }
      // System.out.println("needC = " +needC);
      System.out.println(needC > C ? "NO" : "YES");
    }else {
      System.out.println("NO");
    }
  }
}
