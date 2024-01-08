public class StackRealize<Type> {
    private int sizeStack;
    private int capacityStack = 8;
    private Object[] array;

    public StackRealize() {
        array = new Object[capacityStack];
        sizeStack = 0;
    }

    public void push(Type temp) {
        if (size() == capacityStack) {
            capacityStack += 10;
            Object[] newStack = new Object[capacityStack];
            for (int i = 0; i < array.length; i++) {
                newStack[i] = array[i];
            }
            array = newStack;
        } else {
            array[sizeStack] = temp;
        }
        sizeStack++;
    }

    public Type pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!!!");
        } else {
            Type temp = (Type) array[sizeStack - 1];
            array[sizeStack - 1] = null;
            sizeStack--;
            return temp;
        }
    }

    public Type peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!!!");
        }
        return (Type) array[sizeStack - 1];
    }

    public boolean isEmpty() {
        return sizeStack == 0;
    }

    public int size() {
        return sizeStack;
    }

}
