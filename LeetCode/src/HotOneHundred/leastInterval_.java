package HotOneHundred;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/14 14:17
 * @description
 *
 *
 * 621. 任务调度器
 **/
public class leastInterval_ {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length<=1|| n<1){
            return tasks.length;
        }

        int[] count=new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i]-'A']++;
        }
        Arrays.sort(count);
        int maxCount=count[25];
        int retCount=(maxCount-1)*n+maxCount;
        int index=24;
        while (index>=0&&count[index]==maxCount){
            retCount++;
            index--;
        }
        return Math.max(retCount,tasks.length);

    }

    @Test
    public void test(){
        System.out.println(leastInterval(new char[]{'A', 'A', 'A'}, 1));
    }
}
