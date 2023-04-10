package Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/8 13:51
 * @description TODO
 **/
public class SimpleWrongRecord {
    static Map<String,Integer>map=new HashMap<>();

    static Queue<String>queue=new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine()){
            String file = sc.nextLine();
            filenameAnalysis(file);
        }
        //输出
        Iterator<String> iterator = queue.iterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next+" "+map.get(next));
        }
    }

    public static void filenameAnalysis(String file){
        String[] s = file.split(" ");
        String filename=s[0];
        Integer lineNum=Integer.parseInt(s[1]);

        //取出文件名
        filename=filename.substring(filename.lastIndexOf("\\")+1);
        if(filename.length()>16){
            //取最后十六个字符
            filename=filename.substring(filename.length()-16);
        }
        //新key为文件名+" "+lineNum
        String key=filename+" "+lineNum;
        if (!map.containsKey(key)){
            map.put(key,1);
            //不包含说明之前队列也不包含
          if(queue.size()>=8){
              queue.poll();
          }
          queue.add(key);
        }else{
            //之前已经有添加过相同错误
            map.put(key,map.get(key)+1);
        }


    }





}
