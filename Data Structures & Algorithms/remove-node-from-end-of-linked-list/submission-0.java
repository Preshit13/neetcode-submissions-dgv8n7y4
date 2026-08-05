class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode pres = head;
        ListNode prev = null;
        ListNode next = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }

        ListNode dummy = new ListNode(0);
        dummy.next = prev;
        ListNode temp = dummy;
        for(int i = 0; i < n - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        // Step 3 - reverse back
        ListNode curr = dummy.next;  // ✅ fixed!
        ListNode p = null;
        ListNode nxt = curr.next;

        while(curr != null){
            curr.next = p;
            p = curr;
            curr = nxt;
            if(nxt != null){
                nxt = nxt.next;
            }
        }

        return p;
    }
}