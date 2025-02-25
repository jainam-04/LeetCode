package insertatendofcircularlinkedlist;

class ListNode{
    int data;
    ListNode next;

    ListNode head = null;

    public void push(int data){
        ListNode node = new ListNode();
        node.data = data;
        if(head == null){
            head = node;
        }
        else{
            ListNode temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = node;
        }
        node.next = head;
    }

    public void display(){
        ListNode temp = head;
        while(temp.next != head){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}

public class InsertAtEndOfCircularLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.push(1);
        node.push(2);
        node.push(3);
        node.push(4);
        node.push(5);
        System.out.print("Linked list :- ");
        node.display();
    }
}
