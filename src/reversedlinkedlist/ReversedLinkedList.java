package reversedlinkedlist;

class ListNode {
    int val;
    ListNode next;
    ListNode head = null;

    public void push(int val){
        ListNode node = new ListNode();
        node.val = val;
        node.next = head;
        head = node;
    }

    public void display(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void reversedList(){
        if(head == null){
            return;
        }
        ListNode previous = null;
        ListNode next;
        ListNode current = head;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
}

public class ReversedLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.push(1);
        node.push(2);
        node.push(3);
        node.push(4);
        node.push(5);
        System.out.print("Original linked list :- ");
        node.display();
        node.reversedList();
        System.out.print("Reversed linked list :- ");
        node.display();
    }
}
