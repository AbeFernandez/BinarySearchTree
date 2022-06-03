import java.util.Arrays;

/**
 * This class is a Binary Search Tree that manage duplicates
 *
 * @author Jose(Abe) Fernandez
 * @version 11/23/2021
 * @param <E>
 */
public class BstDup<E extends Comparable<E>> implements BstDupInterface<E>{

    private BstNode<E> root;
    private int size;
    private int index;

    /**
     * Constructor
     */
    public BstDup(){
        root = null;
        size = 0;
        index = 0;
    }

    /**
     * Adds data to the tree, incrementing match count as necessary (if data already exists), or adding
     * new data to the tree (if data does not already exist)
     *
     * @param data the data to add to the tree
     */
    @Override
    public void add(E data) {
        root = add(root, data);
        size++;
    }

    private BstNode<E> add(BstNode<E> startNode, E data){
        BstNode<E> newNode = new BstNode<>(data);
        if (startNode == null) {
            startNode = newNode;
        }
        else {
            if (data.compareTo(startNode.data) < 0) {
                // go to the left
                startNode.left = add(startNode.left, data);

            }
            else{
                // go to the right
                startNode.right = add(startNode.right, data);
            }
        }
        return startNode;
    }

    /**
     * Removes data from the tree, decrementing match count as necessary (if count is above 0),
     * or deleting the data entirely if match count reaches 0
     *
     * @param data the data to delete from the tree
     */
    @Override
    public void delete(E data) {
        root = delete(root, data);
        size--;
    }

    private BstNode<E> delete(BstNode<E> startNode, E data){
        if (startNode == null) {
            return null;
        }
        else if (data.compareTo(startNode.data) < 0){
            startNode.left = delete(startNode.left, data);
        }
        else if (data.compareTo(startNode.data) > 0){
            startNode.right = delete(startNode.right, data);
        }
        else {
            if (startNode.left != null && startNode.right != null){
                BstNode<E> minNodeRight = minimumElement(startNode.right);
                startNode.data = minNodeRight.data;
                startNode.right = delete(startNode.right, minNodeRight.data);
            }
            else if (startNode.left != null) {
                startNode = startNode.left;
            }
            else if (startNode.right != null){
                startNode = startNode.right;
            }
            else {
                startNode = null;
            }

        }
        return startNode;
    }

    /**
     * Removes data from the tree, including all matches
     *
     * @param data the data to delete from the tree
     */
    @Override
    public void deleteAll(E data) {

    }

    /**
     * Retrieves the match count for the provided data
     *
     * @param data the data to search for
     * @return the match count, or -1 if the data is not found in the tree
     */
    @Override
    public int getMatchCount(E data) {
        return getMatchCount(root,data);
    }

    private int getMatchCount(BstNode<E> startNode, E data){
        if (startNode == null) {
            return 0;
        }else{
            return 1 + getMatchCount(startNode.left, data) + getMatchCount(startNode.right, data);
        }
    }

    /**
     * Retrieves all data from the tree, using an in-order traversal
     *
     * @param template an array of the right datatype; can be of 0 length
     * @return an array containing the tree data
     */
    @Override
    public E[] getAllDataInOrder(E[] template) {
        template = Arrays.copyOf(template, size);
        return getAllDataInOrder(root, template);
    }

    private E[] getAllDataInOrder(BstNode<E> startNode, E[] template){
        if (startNode != null) {
            template = getAllDataInOrder(startNode.left,template);
            template[index] = startNode.data;
            System.out.print(template[index] + ", ");
            index++;
            template = getAllDataInOrder(startNode.right, template);
        }
        return template;
    }

    /**
     * This is a helper that will retrieve minimum of elements
     *
     * @param startNode holds the node data
     * @return retrieve the minimum of elements
     */
    public BstNode<E> minimumElement(BstNode<E> startNode) {
        if (startNode.left == null)
            return startNode;
        else {
            return minimumElement(startNode.left);
        }
    }

    /**
     * This class is the Binary Search Tree Node
     *
     * @param <T> a generic
     */
    private static class BstNode<T>{
        T data;
        BstNode<T> left;
        BstNode<T> right;
        int count;

        public BstNode(T data){
            this.data = data;
            left = right = null;
            count = 1;
        }
    }
}
