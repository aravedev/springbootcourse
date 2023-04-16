import java.util.Arrays;

class BinaryHeap{

    private int[] heap;
    private int size;

    // Constructor
    public BinaryHeap(int capacity){
        heap = new int[capacity];
        size = 0;
    }

    // Checking if is empty
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    // Checking who is the root parent
    public int peek(){

        if(isEmpty()){
            throw new RuntimeException("The Binary Heap is empty");
        }else{
            return heap[0];
        }

    }

    // before inserting we have to check if our heap array has extra capacity for storing numbers
    private void checkCapacity(){
        if(size == heap.length){
            heap = Arrays.copyOf(heap,2*heap.length);
        }
    }

    // Getting parent index
    private int getParentIndex(int index){
        return (index-1)/2;
    }

    // checking if parent exist
    private boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }

    // inserting
    public void add(int value){
        checkCapacity();
        heap[size] = value;
        size ++;
    }
}