import java.util.*;
public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList(){
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    if(size == 0) {
      Node created = new Node(value);
      start = created;
      end = created;
      size++;
      return true;
    }
    else {
      Node created = new Node(value);
      end.setNext(created);
      created.setPrev(end);
      end = created;
      size++;
      return true;
    }
  }

  public void add(int index, String value) {
    if(index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    else{
      Node added = new Node(value);
      if(index == 0) {
        start.setPrev(added);
        added.setNext(start);
        start = added;
        size++;
      }
      else if(index == size) {
        add(value);
      }
      else {
        Node current = start;
        for(int i = 1; i < index; i++) {
            current = current.getNext();
        }
        current.setNext(added);
        added.setPrev(current);
        current = end;
        for(int i = size - 1; i > index; i--) {
          current = current.getPrev();
        }
        current.setPrev(added);
        added.setNext(current);
        size++;
      }
    }
  }

  public String get(int index) {
    Node current = start;
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    else{
      for(int i = 0; i < index; i++) {
        current = current.getNext();
      }
      return current.getData();
    }
  }

  public String set(int index, String value) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    else {
      Node old = atIndex(index);
      String oldvalue = old.getData();
      old.setData(value);
      return oldvalue;
    }
  }

  public String remove(int index) {
    Node removed = atIndex(index);
    if(size == 1) {
      size = 0;
    }
    else if(index == 0) {
      start = start.getNext();
      size--;
    }
    else if(index == size - 1) {
      end = end.getPrev();
      size--;
    }
    else {
      Node curbefore = atIndex(index - 1);
      Node curafter = atIndex(index + 1);
      curbefore.setNext(curafter);
      curafter.setPrev(curbefore);
      size--;
    }
    return removed.getData();
  }

  public void extend(MyLinkedList other) {
    Node first = other.atIndex(0);
    Node last = atIndex(size-1);
    last.setNext(first);
    first.setPrev(last);
    end = other.atIndex(other.size() - 1);
    size = size + other.size();
    other.size = 0;
    other.end = null;
    other.start = null;
  }

  public String toString() {
    String result = "[";
    if(size == 0) {
      result = result + "]";
    }
    else {
      for(int i = 0; i < size-1; i++) {
        Node current = atIndex(i);
        result = result + current.getData() + ", ";
      }
      Node current = atIndex(size - 1);
      result = result + current.getData() + "]";
    }
    return result;
  }

  public String toStringReversed() {
    String result = "[";
    if(size == 0) {
      result = result + "]";
    }
    else {
      for(int i = size-1; i > 0; i--) {
        Node current = atIndex(i);
        result = result + current.getData() + ", ";
      }
      Node current = atIndex(0);
      result = result + current.getData() + "]";
    }
    return result;
  }

  private Node atIndex(int index) {
    Node current = start;
    for(int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }

}
