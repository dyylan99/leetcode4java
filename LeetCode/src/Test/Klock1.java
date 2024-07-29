package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/29 22:13
 * @description TODO
 **/
public class Klock1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String>list=new ArrayList<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(s.length());
            list.add(s);
        }

        int rows=list.size();
        String[] split = list.get(0).split(", ");
        int cols= split.length;
        int[][]matrix=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] split1 = list.get(i).split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j]=Integer.parseInt(split1[j]);
            }
        }
        List<Integer>res=new ArrayList<>();
        int left=0,top=0,right=cols-1,bottom=rows-1;
        while (true){
            for (int i = left; i <=right ; i++) {
                res.add(matrix[top][i]);
            }
            if (top++>bottom) break;
            System.out.println(top);
            System.out.println(bottom);
            for (int i = top; i <=bottom; i++) {
                res.add(matrix[right][top]);
            }
            if(right--<left)break;
            System.out.println(right);
            System.out.println(left);
            for (int i =right; i>=left ; i--) {
                res.add(matrix[bottom][right]);
            }
            if(bottom--<top)break;
            System.out.println(bottom);
            System.out.println(top);
            for (int i = bottom; i>=top ; i--) {
                res.add(matrix[bottom][left]);
            }
            if (left++>right)break;
            System.out.println(left);
            System.out.println(right);
        }
        for (int n = 0; n < res.size(); n++) {
            if (n!=res.size()-1){
                System.out.print(res.get(n)+",");
            }else{
                System.out.print(res.get(n));
            }
        }

    }
}
