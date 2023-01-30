package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16434 {
  static class Hero {
    long hp;
    long atk;
    long maxHp;
  }
  static class Room {
    int tag,atk,hp;
    Room(int tag, int atk, int hp) {
      this.tag = tag;
      this.atk = atk;
      this.hp = hp;
    }
  }
  static Hero hero;
  static Room[] rooms;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    int atk = Integer.parseInt(st.nextToken());

    hero = new Hero();
    hero.atk = atk; 

    rooms = new Room[N+1];

    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      rooms[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    long low = 0;
    long high = 999999000001L * 130000;
    while(low + 1 < high) {
      long mid = (low + high) / 2;
      hero.atk = atk;
      if(check(mid)) {
        high = mid;
      }else {
        low = mid;
      }
    }
    System.out.println(high);
  }
  public static boolean check(long maxHp) {
    hero.maxHp= maxHp;
    hero.hp= maxHp;

    for(int i=1; i<=N; i++) {
      if(rooms[i].tag == 1) { // 몬스터일떄
        // 몬스터 죽이기 위한 공격 횟수
        long cnt = rooms[i].hp / hero.atk;
        if(rooms[i].hp % hero.atk > 0) cnt++;

        hero.hp -= rooms[i].atk * (cnt - 1);

        if(hero.hp <= 0) return false;
      }
      else if(rooms[i].tag == 2) { // 포션일때
        hero.atk += rooms[i].atk;
        if(hero.hp + rooms[i].hp > hero.maxHp) {
          hero.hp = hero.maxHp;
        }else {
          hero.hp += rooms[i].hp;
        }
      }
    }


    return true;
  }
}
