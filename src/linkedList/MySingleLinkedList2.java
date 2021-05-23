package linkedList;

import java.util.Comparator;

public class MySingleLinkedList2<E> {
    class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // 머리 노드
    private Node<E> crnt; // 선택 노드

    public MySingleLinkedList2() {
        head = crnt = null;
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // 머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    // 꼬리에 노드 삽입
    public void addLast(E obj) {
        if (head == null)
            addFirst(obj);
        else {
            Node<E> ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }

    // 머리 노드 삭제
    public void removeFirst() {
        if (head != null)
            head = crnt = head.next;
    }

    // 꼬리 노드 삭제
    public void removeLast() {
        if (head != null) {
            if (head.next == null)
                removeFirst();
            else {
                Node<E> ptr = head; // 스캔 중인 노드
                Node<E> pre = head; // 스캔 중인 노드의 아쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;    // pre 는 삭제 후의 꼬리 노드
                crnt = pre;
            }
        }
    }
}
