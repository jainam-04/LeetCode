package linkedlistcycle2;

class ListNode{
    int data;
    ListNode next;

    ListNode head = null;
    ListNode last = null;

    public void push(int data){
        ListNode node = new ListNode();
        node.data = data;
        if(last == null){
            last = node;
        }
        node.next = head;
        head = node;
    }

    public void display(){
        ListNode temp = head;
        while(temp != last){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

public class LinkedListCycle2 {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        for(int i = 1; i <= 6; i++){
            node.push(i);
        }
        System.out.print("Linked list :- ");
        node.display();
        node.last.next = node.head.next.next.next;
        ListNode temp = node.detectCycle(node.head);
        System.out.println("Tail connects to node data :- " + temp.data);
    }
}
