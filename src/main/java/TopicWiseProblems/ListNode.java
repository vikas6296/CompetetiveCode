package org.example;

import java.util.List;

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


    public  static  void main(String []s)
    {
        ListNode root = new ListNode();


    }
    public static ListNode partition(ListNode head, int x)
    {
        ListNode current = head;

        while(current != null && current.next != null)
        {
            if(current.val > x && current.next.val < x)
            {
                current.val = current.next.val;
                current = current.next;
            }

            else
            {
                current.next = current.next.next;
            }


        }

        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // Save next node
            curr.next = prev;              // Reverse the link
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }
        return prev;
    }


    public ListNode reverseList1(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head;

        while(current != null)
        {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

        }
     return prev;
    }



    public boolean hasCycle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return  false;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            // If this node is a start of duplicates
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with this value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Remove them by linking prev to head.next
                prev.next = head.next;
            } else {
                // No duplicate, move prev
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }


    public ListNode removeElements(ListNode head, int val)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                // Remove current.next
                current.next = current.next.next;
            } else {
                // Move forward only if we did not remove
                current = current.next;
            }
        }

        return dummy.next;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // Either both are null (no intersection), or both point to intersection
        return a;
    }

}

