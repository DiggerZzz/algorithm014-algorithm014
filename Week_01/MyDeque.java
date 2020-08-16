public class MyDeque<E> {

    private int size = 0;
    private Node<E> first, rear = null;

    public void addFirst(E e) {
        Node<E> node = new Node<E>(e, null, first);

        if(isEmpty()) {
            first = rear = node;
        } else {
            first.pre = node;
            first = node;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> node = new Node<E>(e, rear, null);

        if(isEmpty()) {
            first = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public E removeFirst() {
        if(isEmpty())
            return null;

        size--;
        Node<E> node = first;
        first = node.next;
        if(first != null) first.pre = null;
        return node.item;
    }

    public E removeLast() {
        if(isEmpty())
            return null;

        size--;
        Node<E> node = rear;
        rear = node.pre;
        if(rear != null) rear.next = null;
        return node.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> node = first;
        while(node != null) {
            sb.append(node.item.toString());
            if(node.next != null) sb.append(",");

            node = node.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    private final static class Node<E> {
        E item;
        Node<E> pre, next;

        Node(E item, Node<E> pre, Node<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<Integer>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addFirst(5);
        deque.addLast(6);
        deque.print();

        System.out.println("==============================================");

        System.out.println("remove first: " + deque.removeFirst());
        System.out.println("remove last: " + deque.removeLast());
        deque.print();

        System.out.println("==============================================");

        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
        deque.removeFirst();
        deque.print();

        System.out.println("==============================================");

        deque.addFirst(10);
        deque.print();
    }

}
