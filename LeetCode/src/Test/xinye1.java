package Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/19 19:18
 * @description TODO
 **/
public class xinye1 {
    public static void main(String[] args) throws InterruptedException {
        Thread A=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print("A");
            }
        });
        Thread B=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print("B");
            }
        });
        Thread C=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print("C");
            }
        });
        A.start();
        B.start();
        C.start();
        A.join();
        B.join();
        C.join();
    }
}
