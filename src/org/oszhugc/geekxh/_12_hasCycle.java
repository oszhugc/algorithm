package org.oszhugc.geekxh;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 */
public class _12_hasCycle {

    public static boolean hasCycle(ListNode head){
        //定义一个set
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null){
            //如果nodeSet添加相同节点会返回false
            if (!nodeSet.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针会在环内相遇
     * 当快慢指针再环内相遇时， helper指针从链表头开始和slow指针一起走， 当helper指针和slow指针相遇时， 即为环的入口
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode helper = head;
        if (head == null || head.next == null) return null;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                while (helper != slow){
                    helper = helper.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }



    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
