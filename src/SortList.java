import java.util.Arrays;

class ListNode{
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
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public void sortList(){
        if(head == null || head.next == null){
            return;
        }
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int[] newList = new int[length];
        temp = head;
        for(int i = 0; i < length; i++){
            newList[i] =temp.val;
            temp = temp.next;
        }
        Arrays.sort(newList);
        temp = head;
        for(int val : newList){
            temp.val = val;
            temp = temp.next;
        }
    }
}

public class SortList {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.push(9);
        node.push(1);
        node.push(5);
        node.push(10);
        node.push(4);
        node.push(2);
        System.out.println("Original List :- ");
        node.display();
        node.sortList();
        System.out.println("List after sorting :- ");
        node.display();
    }
}
