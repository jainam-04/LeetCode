package addtwonumbers;

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
        if(head == null){
            System.out.println("No linked list exists!");
            return;
        }
        else{
            ListNode temp = head;
            while(temp != null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
    }

    public ListNode addTwoNumbers(ListNode n1, ListNode n2){
        ListNode result = null;
        ListNode tail = null;
        int carry = 0;
        int sum;
        while(n1 != null || n2 != null){
            int a;
            int b;
            if(n1 == null){
                a = 0;
            }
            else{
                a = n1.data;
            }
            if(n2 == null){
                b = 0;
            }
            else{
                b = n2.data;
            }
            sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode();
            temp.data = sum;
            temp.next = null;
            if(result == null){
                result = temp;
            }
            else{
                tail.next = temp;
            }
            tail = temp;
            if(n1 != null){
                n1 = n1.next;
            }
            if(n2 != null){
                n2 = n2.next;
            }
        }
        if(carry > 0){
            ListNode node = new ListNode();
            node.data = carry;
            node.next = null;
            tail.next = node;
        }
        return result;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode num1 = null;
        ListNode num2 = null;
        ListNode node = new ListNode();
        for(int i = 1; i <= 3; i++){
            num1 = node.push(num1, i);
        }
        System.out.print("Number 1 :- ");
        node.display(num1);
        for(int i = 4; i <= 6; i++){
            num2 = node.push(num2, i);
        }
        System.out.print("Number 2 :- ");
        node.display(num2);
        ListNode addNumbers = node.addTwoNumbers(num1, num2);
        System.out.print("After adding two numbers :- ");
        node.display(addNumbers);
    }
}
