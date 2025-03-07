package removeduplicatesfromunsortedlinkedlist;

import java.util.HashSet;
import java.util.Set;

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

    public ListNode removeDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode p = head;
        ListNode prev = head;
        set.add(head.data);
        p = p.next;
        while(p != null){
            if(set.contains(p.data)){
                prev.next = p.next;
                p = p.next;
            }
            else{
                set.add(p.data);
                p = p.next;
                prev = prev.next;
            }
        }
        return head;
    }
}

public class RemoveDuplicatesFromUnsortedLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.push(12);
        node.push(12);
        node.push(23);
        node.push(23);
        node.push(45);
        System.out.print("Before removing the duplicates from linked list :- ");
        node.display();
        node.head = node.removeDuplicates(node.head);
        System.out.print("After removing the duplicates from linked list :- ");
        node.display();
    }
}
