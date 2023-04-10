package Test;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/6 15:04
 * @description TODO
 **/
public class shoppingTable {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int money = sc.nextInt();

        int m = sc.nextInt();
        //所属编号-金钱以及满意度
        Goods[]goods=new Goods[m+1];
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            //如果提前遍历到附件,需要提前创建主件

            //附件
            if(q>0){
                if(i+1<q){
                    //提前遍历到附件了
                    //创建主件
                    //判断主件是否被创建过
                    if(goods[q]==null){
                        goods[q]=new Goods(0,0,0);
                    }
                }
                //在主件之后遍历到附件
                if(goods[q].a1==0){
                    //第一个附件
                    goods[q].setA1(i+1);
                }else{
                    goods[q].setA2(i+1);
                }

                goods[i+1]=new Goods(v,p,q);
            }else {
                //主件
                if(goods[i+1]==null){
                    goods[i+1]=new Goods(v,p,q);
                }else {
                    goods[i+1].setALL(v,p,q);
                }
            }


        }
        int[] dp =new int[money+1];
        for (int i = 1; i <=m ; i++) {
            //将所有情况枚举出来
            int v=0,v1=0,v2=0,v3=0;
            v=goods[i].v;
            int tmp=goods[i].p*v;
            int tmp1=0;
            int tmp2=0;
            int tmp3=0;
            if (goods[i].a1!=0){
                //主件加附件1
                v1=goods[goods[i].a1].v+v;
                tmp1=tmp+goods[goods[i].a1].v*goods[goods[i].a1].p;
            }
            if(goods[i].a2!=0){
                //主件加上附件二
                v2=goods[goods[i].a2].v+v;
                tmp2=tmp+goods[goods[i].a2].v*goods[goods[i].a2].p;
            }
            if(goods[i].a2!=0){
                //主件加上两个附件
                v3=v+goods[goods[i].a1].v+goods[goods[i].a2].v;
                tmp3=tmp1+goods[goods[i].a2].v*goods[goods[i].a2].p;
            }
            //所有情况枚举完成
            for (int j = money; j>=goods[i].v ; j--) {
                if(goods[i].q>0){
                    //跳过
                    break;
                }else {
                    dp[j]=Math.max(dp[j],dp[j-v]+tmp);
                    if(j>=v1){
                        dp[j]=Math.max(dp[j],dp[j-v1]+tmp1);
                    }
                    if(j>=v2){
                        dp[j]=Math.max(dp[j],dp[j-v2]+tmp2);
                    }
                    if(j>=v3){
                        dp[j]=Math.max(dp[j],dp[j-v3]+tmp3);
                    }
                }
            }

        }
        System.out.println(dp[money]);

    }

    private static class Goods{
        public int v;
        public int p;
        public int q;

        public int a1=0;
        public int a2=0;

        public void setALL(int v,int p,int q ){
            this.v=v;
            this.p=p;
            this.q=q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }

        public Goods(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }
    }
    @Test
    public void test(){
        String[]strings=new String[5];
        for (String sou : strings) {
            System.out.println(sou);
        }
    }

}
