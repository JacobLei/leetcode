class MyCircularQueue {
    final int[] arr;
    int front, rear = -1, len = 0;
    private MyCircularQueue(int k){
        arr = new int[k];
    }

    public boolean enQueue(int val){
        if(isFull())
            return false;
        rear = (rear + 1) % arr.length;
        len++;
        arr[rear] = val;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty())
            return false;
        front = (front + 1) % arr.length;
        len--;
        return true;
    }

    public int Front(){
        if(isEmpty())
            return -1;
        return arr[front];
    }

    public int Rear(){
        if(isEmpty())
            return -1;
        return arr[rear];
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public boolean isFull(){
        return len == arr.length;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(3));
    }

}
