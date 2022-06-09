package org.oszhugc.geekxh;

/**
 * 第2题：两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 */
public class _13_addTwoNumbers {


    /**
     * 1.  由于两个链表都是逆序存储数字的位数， 所以两个链表同一个位置的数字时可以相加的。 可以同时遍历两个链表， 逐位计算他们的和，同时与当前的进位值相加
     * 2. 如果两个链表的长度不同， 则可以认为长度短的链表的后面有若干个0
     * 3. 此外， 如果链表遍历结束后， 有carry>0, 还需要再答案链表的后面附加一个节点， 节点的值为carry
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //初始化头结点和尾结点
        ListNode head = null, tail = null;
        //carry表示进位
        int carry = 0;
        while (l1 != null || l2 != null){
            //如果两个链表的长度不同， 认为短的链表后面有若干个0
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            //初始头节点
            if (head == null){
                head = new ListNode(sum%10);
                tail = head;
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            //计算进位
            carry =  sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        //如果最后进位， 则在链表的最后附加一个节点，为进位值carry
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }




    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
