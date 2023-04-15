package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/12 17:14
 * @description TODO
 **/
public class mergeStr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String s = sc.nextLine();
        String[] strings = s.split(" ");
        //第一步,合并两个字符串
        String str=strings[0]+strings[1];
        //第二步,对合并完的字符串进行排序
        PriorityQueue<Character>pq1=new PriorityQueue<>();
        PriorityQueue<Character>pq2=new PriorityQueue<>();

        for (int i = 0; i < str.length(); i+=2) {
            pq1.add(str.charAt(i));
        }
        for (int i = 1; i < str.length(); i+=2) {
            pq2.add(str.charAt(i));
        }
        List<Character>list=new ArrayList<>();
        int index=0;
        while (!pq1.isEmpty()&&!pq2.isEmpty()){
            if(index%2==0){
                list.add(pq1.remove());
            }else{
                list.add(pq2.remove());
            }
            index++;
        }
        if(!pq1.isEmpty()){
            list.add(pq1.remove());
        }
        if(!pq2.isEmpty()){
            list.add(pq2.remove());
        }
        traverse(list);
        Character[] characters = list.toArray(new Character[0]);
        StringBuilder sb=new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }
        System.out.println(sb);
    }

    public static void traverse(List<Character>list){
        for (int i = 0; i < list.size(); i++) {
            Character character = list.get(i);
            if(Character.toUpperCase(character)>'F'&&Character.toUpperCase(character)<='Z'){
                //不需要处理
                continue;
            }
            //拿到二进制数位同时反转,同时转化
            int[]index=new int[4];
            char target=getBin(character,index);
            list.set(i,target);
        }
    }
    public static char getBin(char c,int[]nums){
        int num;
        boolean isNum=false;
        if(c-'0'>=0&&c-'9'<=0){
            isNum=true;
        }
        if(isNum){
            num=Integer.parseInt(String.valueOf(c));
        }else{
            c = Character.toUpperCase(c);
            num=10+(c-'A');
        }
        int index=0;
        while (num!=0&&index<4){
            nums[index]=num&1;
            num=num>>>1;
            index++;
        }
        //将二进制数转化为十六进制代表的字符
        num=0;
        for (int i = nums.length-1; i>=0; i--) {
            num+=Math.pow(2,nums.length-1-i)*nums[i];
        }
        if(num<10){
            return String.valueOf(num).charAt(0);
        }else{
            return (char) ('A'+(num-10));
        }
    }

}
