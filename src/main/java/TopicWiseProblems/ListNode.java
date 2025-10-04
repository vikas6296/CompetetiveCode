package TopicWiseProblems;

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

    TreeNode prev = null;
    public void flatten(TreeNode root) { // code to convert the flatten binary tree to linked list
        if(root == null)
            return ;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;

    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalfHead = reverse(slow);

        // Step 3: Compare both halves
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    // to find the middle of the linked list
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Split the list
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    // Function to get the middle and split the list
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        if (prev != null) prev.next = null;
        return slow;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

}

