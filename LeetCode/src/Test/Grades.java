package Test;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/9 18:25
 * @description TODO
 **/
public class Grades {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        List<String[]>list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] message = line.split(" ");
            list.add(message);
        }
        TreeSet<String[]>set=new TreeSet<>((o1, o2) -> {
            //首先按照总成绩排序
            if(!o1[4].equals("?")&&!o2[4].equals("?")){
                if(!o1[4].equals(o2[4])){
                    return Integer.parseInt(o2[4])-Integer.parseInt(o1[4]);
                }else{
                    //成绩都为空
                    if (!o1[0].equals("?")&&!o2[0].equals("?")){

                        return o1[0].compareTo(o2[0]);
                    }else if(!o1[0].equals("?")||!o2[0].equals("?")){
                        return o2[0].compareTo(o1[0]);
                    }else {
                        return 1;
                    }
                }
            }else if(!o1[4].equals("?")||!o2[4].equals("?")){
                return o1[4].compareTo(o2[4]);
            }else{
                //成绩都为空
                if (!o1[0].equals("?")&&!o2[0].equals("?")){

                    return o1[0].compareTo(o2[0]);
                }else if(!o1[0].equals("?")||!o2[0].equals("?")){
                    return o2[0].compareTo(o1[0]);
                }else {
                    return 1;
                }
            }
        });

        parseMessage1(list,set);
        while (!set.isEmpty()){
            String[] remove = set.pollFirst();
            for (int i = 0; i < remove.length; i++) {
                if (i==remove.length-1){
                    System.out.println(remove[i]);
                }else {
                    System.out.print(remove[i]+" ");
                }

            }
        }
    }
    public static void parseMessage1(List<String[]>list,TreeSet<String[]>set){
        for (String[] strings : list) {
            int count=0;
            int index=0;
            for (int i = 1; i < strings.length; i++) {
                if(strings[i].equals("?")){
                    count++;
                    index=i;
                }
            }
            if(count>1||count==0){
                set.add(strings);
            }else{
                //只有一个?
                if (index==4){
                    int t=Integer.parseInt(strings[1])+Integer.parseInt(strings[2])+Integer.parseInt(strings[3]);
                    strings[index]=String.valueOf(t);
                }else {
                    int grade=Integer.parseInt(strings[4]);
                    for (int i = 1; i <4 ; i++) {
                        if(i!=index){
                            grade-=Integer.parseInt(strings[i]);
                        }
                    }
                    strings[index]=String.valueOf(grade);
                }
                set.add(strings);
            }
        }
    }




    @Test
    public void test(){
        String s1="ayya";
        String s2="aya";
        String s3="?";
        System.out.println("0".compareTo("0"));
        System.out.println(s2.compareTo(s1));
        System.out.println((int)s3.charAt(0));
        System.out.println((int)s1.charAt(0));
    }


}
