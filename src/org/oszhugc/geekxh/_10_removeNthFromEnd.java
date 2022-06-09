package org.oszhugc.geekxh;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 */
public class _10_removeNthFromEnd {


    /**
     * 1. 首先我们定义好哨兵节点result, 指向哨兵节点的目标元素指针cur, 以及目标指针cur的前一个指针pre, 此时pre指向nil
     * 2. 接下来我们开始遍历整个链表
     * 3. 当head移动到距离目标元素cur的距离为n-1时，同时开始移动cur
     * 4. 当链表遍历完成后， 此时head指向nil， 这时的cur就是我们要找的待删除的元素
     * 5. 最后我们通过pre.next=pre.next.next完成删除操作， 就完成了整个解题过程
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n){
       ListNode result = new ListNode(0);
       result.next = head;
       ListNode pre = null;
       ListNode cur = result;
       int i = 1;
       while (head != null){
           if (i >= n){
               pre = cur;
               cur = cur.next;
           }
           head = head.next;
           i++;
       }
       pre.next = pre.next.next;
       return result.next;
    }






    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
