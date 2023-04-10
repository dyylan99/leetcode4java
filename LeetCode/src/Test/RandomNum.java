package Test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/6 14:18
 * @description TODO
 **/
public class RandomNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        TreeSet<Integer>set=new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            set.add(num);
        }

        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
