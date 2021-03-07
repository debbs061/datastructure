package Chap4.LinkedList;

/*
직접 연결리스트 만들어보기
 */
public class Node<T> {
    public T data;
    public Node<T> next; // next Field의 주소

    public Node(T item) {   // 생성자
        data = item;
        next = null;
    }
}
