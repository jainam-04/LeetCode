package intersectionoftwolinkedlists;

class ListNode{
    int data;
    ListNode next;

    ListNode head1 = null;
    ListNode head2 = null;

    public void push(int data){
        ListNode node = new ListNode();
        node.data = data;
        node.next = head1;
        head1 = node;
    }

    public ListNode getIntersectionNode(ListNode head1, ListNode head2){
        int l1 = findLength(head1);
        int l2 = findLength(head2);
        int d = Math.abs(l1 - l2);
        ListNode p1;
        ListNode p2;
        if(l1 > l2){
            p1 = head1;
            p2 = head2;
        }
        else{
            p1 = head2;
            p2 = head1;
        }
        for(int i = 0; i < d; i++){
            if(p1 == null){
                return null;
            }
            p1 = p1.next;
        }
        while(p1 != null && p2 != null){
            if(p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public int findLength(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        for(int i = 1; i <= 6; i++){
            node.push(i);
        }
        node.head2 = new ListNode();
        node.head2.data = 11;

        ListNode newNode = new ListNode();
        newNode.data = 12;
        node.head2.next = newNode;

        newNode = new ListNode();
        newNode.data = 13;
        node.head2.next.next = newNode;

        newNode.next = node.head1.next.next.next;

        System.out.println("At " + node.getIntersectionNode(node.head1, node.head2).data + " is intersection");
    }
}
