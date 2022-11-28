package com.epam.rd.java.basic.practice2;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    private int size;
    private Node head;

    public ListImpl(){
        size = 0;
    }

    public ListImpl(Object value){
        size = 0;
        head = new Node(value);
    }

    private static class Node{
        Object value;
        Node next;

        Node(Object value){
            this.value = value;
            next = null;
        }
        public String toString() {

            return value.toString();
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
        
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Node temp = current;
            current = current.next;
            return temp;
        }

    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if (head == null){
            newNode.next = null;
        }
        else{
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addLast(Object element) {
        Node newNode = new Node(element);
        newNode.next = null;

        if (head == null){
            head = newNode;
        }
        else {
            Node last = head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (size == 0){
            return;
        }
        if (size == 1){
            head = null;
        }
        else {
            head = head.next;
        }
        size--;
    }

    @Override
    public void removeLast() {
        Node current = head;
        while (current.next != null){
            current = current.next;
            if (current.next.next == null){
                current.next = null;
            }
        }
        size--;
    }

    @Override
    public Object getFirst() {
        if (size > 0){
            return head.value;
        }
        return null;
    }

    @Override
    public Object getLast() {
        if (size > 0){
            Node last = head;
            while (last.next != null){
                last = last.next;
            }
            return last.value;
        }
        return null;
    }

    @Override
    public Object search(Object element) {
        Node last = head;
        if (element.equals(head.value)){
            return head.value;
        }
        while (last.next != null){
            last = last.next;
            if (element.equals(last.value)){
                return last.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if (element == null){
            return  removeNull();
        }
        if (head == null){
            return false;
        }
        if (head.value == element){
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null){
            if(element.equals(current.next.value)){
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private boolean removeNull(){
        Node current = head;
        while(current.next != null){
            current = current.next;
            if(current.next.value == null){
                current.next = current.next.next;
            }
        }
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if(size != 0){
            Node last = head;
            while(last.next != null){
                res.append(last.value);
                res.append(", ");
                last = last.next;
            }
            res.append(last.value);
        }
        res.append("]");
        return res.toString();

    }

    public static void main(String[] args) {

    }
}
