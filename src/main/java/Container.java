/**
 * Генерический класс контейнера, реализующий простую связный список.
 *
 * @param <T> тип элементов в этом контейнере
 */
public class Container<T> {

    /**
     * Внутренний приватный класс, представляющий узел в связанном списке.
     */
    class Node {
        T data;
        Node next;


        public Node() {
            this.data = null;
            this.next = null;
        }


        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;   // Количество элементов в контейнере
    private Node head;


    public Container() {
        this.head = null;
        this.size = 0;
    }


    public Container(T data) {
        this.head = new Node(data);
        this.size = 1;
    }

    /**
     * Добавляет новый элемент в конец контейнера.
     *
     * @param data элемент, который нужно добавить
     */
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Получает элемент по указанному индексу.
     *
     * @param index индекс элемента для получения
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс вне диапазона (index < 0 || index >= size)
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Неверный индекс");
        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.data;
    }

    /**
     * Удаляет элемент по указанному индексу из контейнера.
     *
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс вне диапазона (index < 0 || index >= size)
     */
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Неверный индекс");
        if (index == 0)
            head = head.next;
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Возвращает количество элементов в контейнере.
     *
     * @return размер контейнера
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли контейнер.
     *
     * @return true, если контейнер пуст, false в противном случае
     */
    public boolean isEmpty() {
        return size == 0;
    }
}