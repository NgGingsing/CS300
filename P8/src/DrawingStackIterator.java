import java.util.Iterator;

public class DrawingStackIterator implements Iterator<DrawingChange> {
  private Node<DrawingChange> runner, next;

  public DrawingStackIterator(Node<DrawingChange> top) {
    runner = top;
    next = runner.getNext();
  }


  @Override
  public boolean hasNext() {
    if (next == null)
      return false;
    else
      return true;
  }

  @Override
  public DrawingChange next() {
    if (hasNext()) {
      Node<DrawingChange> currentNode = runner;
      runner = runner.getNext();
      next = runner.getNext();
      return currentNode.getData();
    } else
      return null;
  }
}
