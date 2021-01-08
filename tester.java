public class tester{

  public static void main(String[] args) {
    MyLinkedList n = new MyLinkedList();
    n.add("hullo0");    n.add("hullo1");    n.add("hullo2");
    n.add("hullo3");    n.add("hullo4");    n.add("hullo6");
    n.add(5, "hullo5");
    n.set(5, "testing");
    System.out.println(n.toString());
  }
}
