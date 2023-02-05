import java.util.LinkedList;

public class Stack { // class used for backtracking; implements stack with a linked list
    private LinkedList<LinkedList<String>> paths;
    int size = 0;
    int top;

    public Stack(int size) {
        paths = new LinkedList<LinkedList<String>>();
        this.size = size;
        top = -1;
    }

    public void push(LinkedList<String> val) {
        paths.push(val);
    }

    public LinkedList<String> pop() {
        return paths.pop();
    }

    public boolean isEmpty() {
        return paths.isEmpty();
    }
}