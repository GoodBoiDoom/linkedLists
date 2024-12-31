package datastructures.linkedLists;

public class linkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public linkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0){
            System.out.println("The Linked List is empty");
            return head;
        }
        else {
            Node temp = head;
            Node pre=head;
            while (temp.next!= null) {
                pre=temp;
                temp = temp.next;
            }
            tail =pre;
            tail.next=null;
            length--;
            if(length==0){
                head=null;
                tail=null;
            }
            return temp;
        }
    }

    /*
     public void removeLast() {
        if (length == 0)
            System.out.println("The Linked List is empty");
        else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            length--;
        }
    }
*/
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0)
            return (null);
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0)
            tail = null;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        else {
            Node temp=head;
            for(int i=0;i<index;i++)
                temp=temp.next;
            return temp;
        }
    }
    public boolean set(int index,int value){
        Node temp=get(index);
        if(temp==null){
            System.out.println("null index");
            return false;
        }else{
            temp.value=value;
            return true;
        }
    }
    public boolean insert(int index,int value) {
        if (index < 0 || index > length) {
            System.out.println("Null");
            return false;
        }
        if(index==(length)) {
            append(value);
            return true;
        }
        if(index==0){
            prepend(value);
            return true;
        }
        Node temp = get(index-1);
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index>=length||index<0)
            return null;
        if(index==0){
            return removeFirst();
        }
        if(index==length){
            return removeLast();
        }
        Node temp=get(index-1);
        Node next=temp.next;
        temp.next=temp.next.next;
        next.next=null;
        length--;
        return next;
    }
    public void reverse(){
        Node temp=head;
        head=tail;
        tail=temp;
        Node before=null,after=temp.next;
        for(int i=0;i<length;i++){
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
    }
    public Node findMiddleNode(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean hasLoop() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast) {
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
}

}