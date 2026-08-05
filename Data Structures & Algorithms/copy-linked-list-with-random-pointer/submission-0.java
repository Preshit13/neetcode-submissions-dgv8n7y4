/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        // Step 1 - create HashMap
        HashMap<Node, Node> map = new HashMap<>();

        // Step 2 - first pass: create all new nodes
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 3 - second pass: set next and random pointers
        curr = head;
        while(curr != null){
            if(curr.next != null){
                map.get(curr).next = map.get(curr.next);
            }
            if(curr.random != null){
                map.get(curr).random = map.get(curr.random);
            }
            curr = curr.next;
        }

        return map.get(head);
    }
}
