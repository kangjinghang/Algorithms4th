package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.DoubleNode;

/**
 * 实现一个嵌套类 DoubleNode 用来构造双向链表，其中每个结点都含有一个指向前驱元素的引用
 * 和一项指向后续元素的引用（如果不存在则为 null）。为以下任务实现若干静态方法：在表头
 * 插入结点、在表尾插入结点、从表头删除结点、从表尾删除结点、在指定结点之前插入新结点、
 * 在指定结点之后插入新结点、删除指定结点。
 */
public class Ex31<Item> {

    private DoubleNode<Item> first;

    private DoubleNode<Item> last;

    public void insertAsFirst(Item item) {
        DoubleNode<Item> node = new DoubleNode<>();
        node.item = item;
        node.prev = null;
        node.next = first;

        if (first == null) {
            last = node;
        } else {
            first.prev = node;
        }

        first = node;
    }

    public void insertAsLast(Item item) {
        DoubleNode<Item> node = new DoubleNode<>();
        node.item = item;
        node.prev = last;
        node.next = null;

        if (last == null) {
            first = node;
        } else {
            last.next = node;
        }

        last = node;
    }

    public void deleteFirst() {
        if (first == null) {
            return;
        }
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
            if (first.prev != null) {
                first.prev.next = null;
            }
        }

    }

    public void deleteLast() {
        if (last == null) {
            return;
        }
        if (first == last) {
            first = last = null;
        } else {
            last = last.prev;
            if (last.next != null) {
                last.next.prev = null;
            }
            last.next = null;
        }
    }

    public void insertBefore(DoubleNode<Item> node, Item item) {
        if (node == null) {
            return;
        }
        if (first == node) {
            insertAsFirst(item);
        } else {
            DoubleNode<Item> newNode = new DoubleNode<>();
            newNode.item = item;
            newNode.next = node;
            newNode.prev = node.prev;

            node.prev.next = newNode;
            node.prev = newNode;
        }
    }

    public void insertAfter(DoubleNode<Item> node, Item item) {
        if (node == null) {
            return;
        }
        if (last == node) {
            insertAsLast(item);
        } else {
            DoubleNode<Item> newNode = new DoubleNode<>();
            newNode.item = item;
            newNode.prev = node;
            newNode.next = node.next;

            node.next.prev = newNode;
            node.next = newNode;
        }
    }

    public void deleteNode(DoubleNode<Item> node) {
        if (node == null) {
            return;
        }
        if (node == first) {
            deleteFirst();
        } else if (node == last) {
            deleteLast();
        } else {
            final DoubleNode<Item> next = node.next;
            final DoubleNode<Item> prev = node.prev;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
    }

    public void display() {
        DoubleNode<Item> current = first;
        while (current != null) {
            System.out.print(current.item + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        testInsertAsFirst();
        testInsertAsLast();
        testDeleteFirst();
        testDeleteLast();
    }

    public static void testInsertAsFirst() {
        System.out.println("--------------------");
        System.out.println("testInsertAsFirst:");
        Ex31<String> dl = new Ex31<>();
        dl.insertAsFirst("a");
        dl.insertAsFirst("b");
        dl.insertAsFirst("c");
        dl.insertAsFirst("d");
        System.out.println("After insert a, b, c, d:");
        dl.display();
    }

    public static void testInsertAsLast() {
        System.out.println("--------------------");
        System.out.println("testInsertAsLast:");
        Ex31<String> dl = new Ex31<>();
        dl.insertAsLast("a");
        dl.insertAsLast("b");
        dl.insertAsLast("c");
        dl.insertAsLast("d");
        System.out.println("After insert a, b, c, d:");
        dl.display();
    }

    public static void testDeleteFirst() {
        System.out.println("--------------------");
        System.out.println("testDeleteFirst:");
        Ex31<String> dl = new Ex31<>();
        dl.insertAsLast("a");
        dl.insertAsLast("b");
        dl.insertAsLast("c");
        dl.insertAsLast("d");
        System.out.println("list is: ");
        dl.display();
        System.out.println("After deleteFrist:");
        dl.deleteFirst();
        dl.display();

        System.out.println("After deleteFrist again:");
        dl.deleteFirst();
        dl.display();

        System.out.println("After deleteFrist again:");
        dl.deleteFirst();
        dl.display();

        System.out.println("After deleteFrist again:");
        dl.deleteFirst();
        dl.display();

        System.out.println("After deleteFrist again:");
        dl.deleteFirst();
        dl.display();
    }

    public static void testDeleteLast() {
        System.out.println("--------------------");
        System.out.println("testDeleteLast:");
        Ex31<String> dl = new Ex31<>();
        dl.insertAsLast("a");
        dl.insertAsLast("b");
        dl.insertAsLast("c");
        dl.insertAsLast("d");
        System.out.println("list is: ");
        dl.display();
        System.out.println("After deleteLast:");
        dl.deleteLast();
        dl.display();

        System.out.println("After deleteLast again:");
        dl.deleteLast();
        dl.display();

        System.out.println("After deleteLast again:");
        dl.deleteLast();
        dl.display();

        System.out.println("After deleteLast again:");
        dl.deleteLast();
        dl.display();

        System.out.println("After deleteLast again:");
        dl.deleteLast();
        dl.display();
    }


}
