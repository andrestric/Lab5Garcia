import java.util.*;

public class BST<E> implements Tree<E> {
  
  protected TreeNode<E> root;
  protected int size = 0;
  protected java.util.Comparator<E> c; 

  /** Create a default BST with a natural order comparator */
  public BST() {
    this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
  }

  /** Returns the root of the tree */
  public TreeNode<E> getRoot() {
    return root;
  }

  /** Returns a readable path from the root to the specified element */
  public String path(E e) {
    ArrayList<TreeNode<E>> nodes = new ArrayList<>();
    TreeNode<E> current = root;

    while (current != null) {
      nodes.add(current);
      if (c.compare(e, current.element) < 0) {
        current = current.left;
      } else if (c.compare(e, current.element) > 0) {
        current = current.right;
      } else {
        break;
      }
    }

    if (nodes.isEmpty() || c.compare(nodes.get(nodes.size() - 1).element, e) != 0) {
      return "Element not found in the tree.";
    }

    StringBuilder pathString = new StringBuilder();
    for (TreeNode<E> node : nodes) {
      pathString.append(node.element).append(" -> ");
    }

    pathString.setLength(pathString.length() - 4); // Remove last arrow
    return pathString.toString();
  }

  public static class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
      element = e;
    }
  }
}
