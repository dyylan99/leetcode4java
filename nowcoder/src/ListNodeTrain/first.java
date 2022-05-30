package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/23 21:26
 * @description 反转链表:头结点带值,空间复杂度为O(1),时间复杂度为O(n):
 * 时间复杂度为O(n),则根据头结点依次往下找,(相对于当前表)第二个节点指向第一个,第三个指向第二个,头结点next为null
 **/

/**
 * 随笔小记:常量池:包括:
 * 一.class文件常量池:包括
 * 1.字面量:文本字符串,也就是java.lang.String
 * 用final修饰的成员变量，包括静态变量、实例变量和局部变量
 * 而对于基本类型数据(甚至是方法中的局部变量)，也就是private int value = 1；常量池只保留了他的字段描述I和字段的名称value，他们的字面量不会存在与常量池。
 *
 * 2.符号引用:
 * 符号引用主要涉及编译原理方面的概念，包括下面三类常量:
 * 类和接口的全限定名
 * 字段的名称和描述符，字段也就是类或者接口中声明的变量，包括类级别变量和实例级的变量
 * 方法中的名称和描述符
 * 也就是参数类型和返回值
 *
 * 二.运行时常量池:
 *  运行时常量池的作用是存储java class文件常量池中的符号信息，
 *  运行时常量池中保存着一些class文件中描述的符号引用
 *  ，同时在类的解析阶段还会将这些符号引用翻译成直接引用(直接指向实例对象的指针，内存地址)，
 *  翻译出来的直接引用也是存储在运行时常量池中。
 *
 *  三.
 * 全局字符串常量池
 * 全局字符串常量池存在于方法区
 *
 * 四.基本类型常量池:
 * Java中基本类型的包装类大部分都实现了常量池技术，
 * 这些类Byte，Short，Integer，Long，Character，Boolean，
 * 另外两种浮点数类型的包装类则没有实现。另外上面这五种整型的包装类也只是在对应值小于等于127时才可使用对象池，也就是对象不负责创建和管理大于127的这些类的对象。
 */

public class first {

    //无头结点
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode next=null;
        ListNode pre=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }

        return pre;
    }
    //有头结点
    public static ListNode reveereList1(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode cur=preHead.next;
        ListNode next;
        while(cur.next!=null){
            next=cur.next;
            cur.next=next.next;
            next.next=preHead.next;
            preHead.next=next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1=null;
        reveereList1(node1);
    }


}
