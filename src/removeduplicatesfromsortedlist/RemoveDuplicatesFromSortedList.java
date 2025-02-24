package removeduplicatesfromsortedlist;

class ListNode{
    int data;
    ListNode next;

    ListNode head = null;

    public void push(int data){
        ListNode node = new ListNode();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
        }
        else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null){
            if(p1.data == p2.data){
                p1.next = p2.next;
                p2 = p2.next;
            }
            else{
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        return head;
    }
}

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.push(1);
        node.push(1);
        node.push(2);
        node.push(3);
        node.push(4);
        node.push(4);
        System.out.print("Before removing the duplicates from linked list :- ");
        node.display();
        node.head = node.deleteDuplicates(node.head);
        System.out.print("After removing the duplicates from linked list :- ");
        node.display();
    }
}
