/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // ArrayList<Integer> list = new ArrayList<>();
        // ListNode node = new ListNode(0);
        // node = head;

        // if(head == null){
        //     return head;
        // } 

        // while(node != null){
        //     list.add(node.val);
        //     node = node.next;
        // }
        // Collections.reverse(list);
        // ListNode dummy = new ListNode(0);
        // ListNode curr = dummy;
        // for(int i = 0; i < list.size(); i++){
        //     curr.next = new ListNode(list.get(i));
        //     curr = curr.next;
        // }
        // return dummy.next;

        if(head == null){
            return head;
        }

        ListNode previous = null;
        ListNode present = head;
        ListNode next = present.next;
        

        while(present != null){
            present.next = previous;
            previous = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        return previous;
    }
}
