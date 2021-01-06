public class Node {
  private String data;
  private Node next, prev;

  public Node(String value) {
    data = value;
  }

  public Node getNext() {
    return next;
  }

  public String getData() {
    return data;
  }

  public Node getPrev() {
    return prev;
  }

}
