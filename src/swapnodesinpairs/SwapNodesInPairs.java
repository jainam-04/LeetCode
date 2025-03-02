package swapnodesinpairs;

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

    public ListNode swapPairs(ListNode head){
        ListNode p = head;
        while(p != null && p.next != null){
            int temp = p.data;
            p.data = p.next.data;
            p.next.data = temp;
            p = p.next.next;
        }
        return head;
    }
}

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        for(int i = 1; i <= 6; i++){
            node.push(i);
        }
        System.out.print("Before swapping the linked list :- ");
        node.display();
        node.head = node.swapPairs(node.head);
        System.out.print("After swapping the linked list :- ");
        node.display();
    }
}
