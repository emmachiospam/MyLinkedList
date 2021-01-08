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
      size++;
      Node created = new Node(value);
      start = created;
      end = created;
      return true;
    }
    else {
      size++;
      Node created = new Node(value);
      end.setNext(created);
      created.setPrev(end);
      end = created;
      return true;
    }
  }

  public void add(int index, String value) {
    Node current = start;
    Node added = new Node(value);
    if(index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    else{
      for(int i = 0; i < index-1; i++) {
        current = current.getNext();
      }
      current.setNext(added);
      added.setPrev(current);
      current = end;
      for(int i = size - 1; i > index+1; i--) {
        current = end.getPrev();
      }
      current.setPrev(added);
      added.setNext(current);
      size++;
    }
  }

  public String get(int index) {
    Node current = start;
    if(index < 0 || index > size) {
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
    if(index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }
    else {
      Node old = atIndex(index);
      String oldvalue = old.getData();
      old.setData(value);
      return oldvalue;
    }
  }

  public String toString() {
    String result = "";
    for(int i = 0; i < size; i++) {
      Node current = atIndex(i);
      result = result + current.getData() + "\n";
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
