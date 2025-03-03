package mergetwosortedlists;

class ListNode{
    int data;
    ListNode next;

    public ListNode push(ListNode head, int data){
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
        return head;
    }

    public void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp= temp.next;
        }
        System.out.println("NULL");
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2){
        ListNode mergedHead;
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode temp;
        if(head1.data <= head2.data){
            temp = head1;
            head1 = head1.next;
        }
        else{
            temp = head2;
            head2 = head2.next;
        }
        mergedHead = temp;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                temp = head1;
                head1 = temp.next;
            }
            else{
                temp.next = head2;
                temp = head2;
                head2 = temp.next;
            }
        }
        if(head1 == null){
            temp.next = head2;
        }
        if(head2 == null){
            temp.next = head1;
        }
        return mergedHead;
    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode node = new ListNode();
        for(int i = 1; i <= 10; i += 2){
            head1 = node.push(head1, i);
        }
        System.out.print("First linked list :- ");
        node.display(head1);
        for(int i = 2; i <= 10; i += 2){
            head2 = node.push(head2, i);
        }
        System.out.print("Second linked list :- ");
        node.display(head2);
        ListNode mergedHead = node.mergeTwoLists(head1, head2);
        System.out.print("After merging two sorted linked lists :- ");
        node.display(mergedHead);
    }
}
