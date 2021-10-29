package org.humor.zxc.simple.algorithm;

/**
 * Date: 2021/9/27
 * Time: 10:48 上午
 * <p>
 * 链表反转
 *
 * @author xuzz
 */
public class LinkedListReverse {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        ListNode nextTemp;
        while (cur != null) {
            nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

}
