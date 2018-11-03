import java.util.Iterator;

public class DrawingStack implements StackADT<Node<DrawingChange>> {
  Node<DrawingChange> top;
  int size;

  public DrawingStack() {
    top = null;
    size = 0;
  }

  public class StackException extends RuntimeException {

    /**
     * Create a RuntimeException of type StackException
     * 
     * @param errorMessage
     */
    public StackException(String errorMessage) {
      super(errorMessage); // Calls RuntimeException's constructor
    }
  }

  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws IllegalArgumentException if the input element is null
   */
  @Override
  public void push(Node<DrawingChange> element) throws IllegalArgumentException {
    top.setNext(element);
    top = element;
    size++;
  }

  /**
   * Remove the element on the stack top and return it
   * 
   * @return the element removed from the stack top
   */
  @Override
  public Node<DrawingChange> pop() {
    if (isEmpty()) {
      throw new StackException(
          "WARNING: The Stack is empty. Unable " + "to execute a pop operation.");
    }
    Node<DrawingChange> remove = top;
    top = remove.getNext();
    top.setNext(null);
    size--;
    return remove;
  }

  /**
   * Get the element on the stack top
   * 
   * @return the element on the stack top
   */
  @Override
  public Node<DrawingChange> peek() {
    return top;
  }

  /**
   * Returns true if this stack contains no elements.
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    if (top == null)
      return true;
    else
      return false;
  }

  /**
   * Get the number of elements in the stack
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * 
   * @return iterator of the stack
   */
  public Iterator<DrawingChange> iterator(){
    return new DrawingStackIterator(top);
  }
}
