import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int Length;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.Length = 0;
    }

    public boolean isEmpty() {
        return Length == 0;// or head ==null
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        Length++;
    }

    public void insertEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        Length++;
    }


        public void displayForward(){
            if (head == null) {
                return;
            }
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + "0->");
                temp = temp.previous;
            }
            System.out.println("null");
        }
        public void displayBackward() {
        if(head==null){
            return;
        }
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "0->");
            temp = temp.previous;
        }
        System.out.println("null");
    }
    public ListNode deleteFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if(head == tail){
            tail = null;
        } else {
            head.next.previous = null;
        }
        head =head.next; temp.next = null; Length--;
        return temp;
    }
        public static void main (String[]args){
            DoublyLinkedList dll = new DoublyLinkedList();
            dll.insertFirst(1);
            dll.insertEnd(10);
            dll.displayForward();
            dll.displayBackward();
        }
    }
