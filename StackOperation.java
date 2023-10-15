import java.util.*;

public class StackOperation {
    private int top;
    private Integer[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public StackOperation() {
        int top = 0;
        array = new Integer[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public void push(Integer value) {
        if (size == capacity) {
            increaseCapacity();
        }
        array[top++] = value;
        size++;
    }

    private void increaseCapacity() {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }

    private Integer pop() {
        if (size == 0) {
            return null;
        }
        Integer answer = array[--top];
        array[top] = null;
        size--;
        return answer;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int getMinAndRecoverStack() {
        int[] recoverArr = new int[size];

        int index = 0;
        int min = Integer.MAX_VALUE;
        while (!this.isEmpty()) {
            int temp = this.pop();
            recoverArr[index++] = temp;
            if (temp < min) {
                min = temp;
            }
        }
        System.out.println(this);
        for (int i = recoverArr.length - 1; i >= 0; i--) {
            this.push(recoverArr[i]);
        }
        return min;
    }


    @Override
    public String toString() {
        return "StackOperation{" + "top=" + top + ", array=" + Arrays.toString(array) + ", size=" + size + ", capacity=" + capacity + '}';
    }

    public static void main(String[] args) {


        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<Integer> numbers = new Stack<>();
        System.out.println(numbers);
        numbers.push(1);
        numbers.push(5);
        numbers.push(3);
        numbers.push(4);
        numbers.push(2);
        System.out.println(numbers);
        System.out.println(numbers.size());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers);
        System.out.println(linkedList);
        linkedList.push(1);
        linkedList.push(5);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(2);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        StackOperation stackOperation = new StackOperation();
        System.out.println(stackOperation);
        System.out.println(stackOperation.isEmpty());
        stackOperation.push(1);
        stackOperation.push(5);
        stackOperation.push(3);
        stackOperation.push(4);
        stackOperation.push(2);
        System.out.println(stackOperation);
        System.out.println(stackOperation.isEmpty());
        System.out.println(stackOperation.getMinAndRecoverStack());

        System.out.println(stackOperation);


    }
}
