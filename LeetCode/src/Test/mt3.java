package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/16 19:16
 * @description TODO
 **/
public class mt3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int H = in.nextInt();
        int A = in.nextInt();
        int []h=new int[n];
        int []a=new int[n];
        for (int i = 0; i < n; i++) {
            h[i]=in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        List<Monster>list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Monster(h[i],a[i]));
        }
        Collections.sort(list,(m1,m2)->{
           return m1.health*m1.attack-m2.health*m2.attack;
        });
        Map<Integer,Map<Integer,Integer>>map=new HashMap<>();
        for (Monster monster : list) {
            int h1=monster.health;
            int a1=monster.attack;
            for (int i = H; i>=h1 ; i--) {
                Map<Integer,Integer>sub=map.getOrDefault(i,new HashMap<>());
                for (int j = A; j>=a1; j--) {
                    sub.put(j,Math.max(sub.getOrDefault(j,0),sub.getOrDefault(j-a1,0)+1));
                }
                map.put(i,sub);
            }
        }
        System.out.println(map.get(H).get(A));
    }


    public static void test(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int H = in.nextInt();
        int A = in.nextInt();
        int []h=new int[n];
        int []a=new int[n];
        for (int i = 0; i < n; i++) {
            h[i]=in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        List<Monster>list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Monster(h[i],a[i]));
        }
        Collections.sort(list,(m1,m2)->{
            return m1.health*m1.attack-m2.health*m2.attack;
        });
        int[]dp=new int[n+1];
        for (Monster monster : list) {
            int h1=monster.health;
            int a1=monster.attack;
            for (int i = n; i>0; i--) {
                if (h1<H &&a1<A){
                    dp[i]=Math.max(dp[i],dp[i-1]+1);
                }else{
                    dp[i]=dp[i-1];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
class Monster{
    public int health;
    public int attack;
    public Monster(int h,int a){
        this.attack=a;
        this.health=h;
    }
}
