package org.oszhugc.geekxh;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class _11_mergeTwoLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        //通过一个哨兵节点来连接两个链表的节点
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (list1 != null && list2 != null){
            //比较大小， 谁小谁就是pre的后继节点， 并且更新该引用的指向
            if (list1.val >= list2.val){
                pre.next = list2;
                list2 = list2.next;
            }else {
                pre.next = list1;
                list1 = list1.next;
            }
            //更新pre的指向
            pre = pre.next;
        }
        //需要注意剩下来为追加的部分节点
        pre.next = list1 == null ? list2 : list1;
        return dummy.next;
    }



    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
