package linkedList;


import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * SingleLinkedList : 단방향 리스트 (DoubleLinkedList도 있음)
 - 주로 하는 건 '삽입,삭제,검색'
 - 연결리스트가 Node들을 데이터로 저장하고 있는 개념은 아님 (연결리스트를 구현하려면 Node가 필수적으로 필요)
 - 연결리스트를 다루는 프로그램에서 가장 주의할 점은 내가 작성한 코드가 일반적인 경우만이 아니라 특수한 경우에도 문제 없이 작동하는지
   철저히 확인하는 것이다. ex) 기존의 연결 리스트 크기가 0인 경우, 즉 head가 null인 경우에도 문제가 없는가?
 - Interface 6개를 제외하곤 전부 private으로 만들어서 외부에서 알 수 없게 한다.
 *  T get(int index);
 *  void add(int index, T item);
 *  boolean remove(int index);
 *  boolean remove(T item);
 *  int indexOf(T item);
 *  int size();
 * Iterable<T> iterator()
 - 이 6개의 메소드들은 이게 연결리스트다 라는 사실이 드러나지 않고 있음
 *  (implementation이 연결리스트가 아니라 배열or ArrayList 수도 있고..)
 - Java API는 List<E> 인터페이스를 정의하고 있다. (이 6개보다 더 많음)
 */
public class MySingleLinkedList<T> {
    private Node<T> head; // 첫번째 노드 주소
    private int size = 0; // 현 노드의 개수

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    // inner class : 외부에서는 이 Node의 존재를 알 수 없도록
    private static class Node<T> {
        public T data;
        public Node<T> next; // next Field의 주소

        public Node(T item) {   // 생성자
            data = item;
            next = null;
        }
    }

    private void addFirst(T item) { // 현재 연결리스트의 맨 앞에 새 노드를 넣음
        // (1) 새로운 노드를 만들고 추가할 데이터를 저장한다.
        Node<T> newNode = new Node<T>(item);

        // (2) 새로운 노드의 next 필드가 현재의 head 노드를 가리키도록 한다.
        newNode.next = head;

        // (3) 새로운 노드를 새로운 head 노드로 한다.
        head = newNode;
        size++;

        // (체크사항) 아무 노드도 없는 상태였어도 괜찮은가? -> head가 null이 됨 -> 괜찮음
    }

    private void addAfter(Node<T> before, T item) {  // 어떤 노드 뒤에 새 노드를 넣음
        Node<T> temp = new Node<>(item);
        temp.next = before.next;
        before.next = temp;
        size++;
    }

    // 단순연결리스트에 새로운 노드를 삽입할 때 삽입할 위치의 바로 앞 노드의 주소가 필요하다.
    // 즉 어떤 노드의 뒤에 삽입하는 것은 간단하지만, 반대로 어떤 노드의 앞에 삽입하는 것은 쉽지 않다.
    // (노드들이 '다음주소'만 가지고 있기 때문에)
    private void addBefore(Node<T> after, T item) {
        // (1) after를 head로 가지고 있는 노드를 찾는다
        // (2) 그 노드.next = temp
        // (3) temp.next = after
    }

    // 연결리스트의 index번째 위치에 새로운 데이터를 삽입한다.
    public void add(int index, T item) {  // insert

        if (index < 0 || index > size) { // 새로추가되는노드까지 포함한 범위이므로 index=size인 경우도 괜찮음
            // 유효하지 않은 index를 줬을 때, 예외처리 해줘야 함
            throw new IndexOutOfBoundsException();
        }

        // (체크사항) index가 0이면.. index-1 노드가 존재하지 않음
        if (index == 0) {
            addFirst(item);
        } else {
            Node<T> q = getNode(index - 1); //index-1 번째 뒤에 새로운 노드를 만들면 됨
            addAfter(q, item);
        }
    }

    // index번째 노드를 삭제하고, 그 노드에 저장된 데이터를 반환한다.
    // 단방향 연결형 리스트에서는 어떤 노드를 삭제할 때, 그 삭제할 노드의 주소만 가지고 삭제하는건 어려움.
    // -> removeAfter 메소드같은걸 이용
    public T remove(int index) { // delete
        // 예외처리
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0)
            return removeFirst();

        // 노드를 삭제하려면.. 그의 앞 노드 주소를 알아야함
        Node<T> prev = getNode(index - 1);
        return removeAfter(prev);
    }

    // item을 가지고 있는 노드를 삭제해라
    // 두 개 이상의 참조변수를 사용
    // q는 항상 p의 직전 노드를 가리킴. p가 첫번째 노드일 경우 q는 null 임
    public T remove(T item) {
        Node<T> p = head, q = null;
        // p 가 null이라는건 끝까지 다 갔다는 거니깐
        while (p != null && !p.data.equals(item)) {
            q = p;
            p = p.next;
        }
        // item과 동일한 데이터를 가지고 있는 node가 없다면
        if (p == null) {
            return null;
        }
        // 찾으려는 노드가 맨 첫번째에 있다면 q가 가리키는건 null 이니깐
        if (q == null) {
            return removeFirst();
        }
        // empty list에서도 오류를 일으키지 않은가? ok. null을 리턴함
        return removeAfter(q);
    }

    private T removeFirst() {
        // head가 null이 아니라면 head가 현재 head 노드의 다음 노드를 가리키게 만든다.
        if (head == null)
            return null;
        T temp = head.data;
        head = head.next;
        return temp;
    }

    // before 노드의 다음 노드를 연결리스트에서 삭제해라
    // 단순연결리스트에 어떤 노드를 삭제할 때는 정작 필요한 건 삭제할 노드의 바로 앞 노드의 주소가 필요하다. 삭제할 노드의 주소만으로는 삭제할 수 없다.
    private T removeAfter(Node<T> before) {
        if (before.next == null)
            return null;
        T temp = before.next.data;
        before.next = before.next.next;
        return temp;
    }

    // 연결리스트의 노드들을 처음부터 순서대로 방문하는 것을 순회(traverse)한다고 말한다. indexOf 메서드는 입력된 데이터 item과 동일한 데이터를
    // 저장한 노드를 찾아서 그 노드번호(index)를 반환하다. 그것을 위해서 연결리스트를 순회한다.
    public int indexOf(T item) {     // search (index 반환)
        Node<T> p = head; // 참조변수 p가 첫번째 노드를 가리킨다
        int index = 0;
        while (p != null) { // 모든 노드를 지나고 나면 p에는 null이 들어갈 것임
            if (p.data.equals(item)) {
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }

    // index번째 노드에 저장된 데이터를 반환한다.
    public T get(int index) {
        // 유효성 체크를 위해 살려놔야함
        if (index < 0 || index >= size) {
            return null;
        }
//        Node<T> p = head;
//        for (int i = 0; i < index; i++) {
//            p = p.next;
//        }
        return getNode(index).data;
    }

    // 연결리스트의 index번째 노드의 주소를 반환한다. (traverse)
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    // Iterator 는 java API가 제공하는 객체
    // iterator 를 구현하는 일을 하는 것임 (iterable 인터페이스를)
    public Iterable<T> iterator() {
        return (Iterable<T>) new MyIterator(); // polymophism에 의해서 Iterator를 밯놘해도 됨
    }

    // Java가 정의한 Iterator 인터페이스를 구현하는 클래스
    // 3가지 public method가 있어야 함
    private class MyIterator implements Iterator<T> {
        private Node<T> nextNode;
        public MyIterator() {
            nextNode = head; // iterator는 맨 첫번째노드의 앞을 가리킴
        }
        public boolean hasNext() {
            return (nextNode != null);
        }
        public T next() {
            if (nextNode == null) {
                throw new NoSuchElementException();
            }
            T val = nextNode.data;  // 현재 데이터 반환
            nextNode = nextNode.next; // 한 칸 앞으로 전진
            return val;
        }

        // 단방향 연결리스트에서 특정 노드를 삭제하려면
        // 그 이전 노드의 주소를 알아야 함
        public void remove() {

        }
    }

    // Test용
    public static void main(String[] args) {
        MySingleLinkedList<String> list = new MySingleLinkedList<>();

        list.add(0, "Saturday");
        list.add(1, "Friday");
        list.add(0, "Mondeay");
        list.add(2, "Tuesday"); // M, S, T, F

        String str = list.get(2);
        list.remove(2); // M S F
        int pos = list.indexOf("Friday"); // pos = 2
    }


}
