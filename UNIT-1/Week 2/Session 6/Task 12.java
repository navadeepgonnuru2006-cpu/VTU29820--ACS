class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        
        if (fast != null) {
            slow = slow.next;
        }

        
        ListNode secondHalf = reverse(slow);

        
        ListNode firstHalf = head;
        ListNode temp = secondHalf;

        while (temp != null) {
            if (firstHalf.val != temp.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
