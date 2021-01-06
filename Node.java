public class Node {
  public Node(String value) {
    data = value;
  }
  private String data;
  private Node next, prev;

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
