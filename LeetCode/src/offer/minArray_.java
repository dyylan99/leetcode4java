package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/16 13:55
 * @description TODO
 **/
public class minArray_ {
    public int minArray(int[] numbers) {
        if(numbers.length==1){
            return numbers[0];
        }
        int index=1;
        //判断是否将数组完全倒序了
        for (int i = 1; i <numbers.length ; i++) {
            if(numbers[i]<numbers[i-1]){
                index++;
                continue;
            }
        }
        //若是,则完全倒序
        if(index==numbers.length){
            return numbers[numbers.length-1];
        }

        //没有完全倒序
        index=1;
        while (index<numbers.length){
            if(numbers[index]>=numbers[index-1]){
                index++;
                continue;
            }else{
                return numbers[index];
            }
        }
        if(index==numbers.length){
            return numbers[0];
        }
        return -1;
    }
}
