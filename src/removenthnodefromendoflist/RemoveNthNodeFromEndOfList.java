package removenthnodefromendoflist;

class ListNode{
    int val;
    ListNode next;
    ListNode head = null;
    public void push(int data){
        ListNode newNode = new ListNode();
        newNode.val = data;
        newNode.next = null;
        if(head == null){
            head = newNode;
        }
        else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val +" -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 1; i <= n; i++){
            if(p2.next == null){
                return head.next;
            }
            p2 = p2.next;
        }
        while(p2.next != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.push(1);
        node.push(2);
        node.push(3);
        node.push(4);
        node.push(5);
        System.out.print("Linked List before deleting the node :- ");
        node.display();
        node.head = node.removeNthFromEnd(node.head, 3);
        System.out.print("Linked List after deleting the node :- ");
        node.display();
    }
}
