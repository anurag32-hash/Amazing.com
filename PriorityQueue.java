
public class PriorityQueue<V> implements QueueInterface<V>{

    private volatile Node<V>[] queue;
    private int capacity, currentSize,front,rear;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {    
         queue = new Node[capacity];
         this.rear=-1;
         this.currentSize=0;
         this.capacity=capacity;
    }

    public int size() {
         return this.currentSize;
    }

    public boolean isEmpty() {
         return (this.currentSize==0);
    } 
	
    public boolean isFull() {
        return(this.currentSize==this.capacity);
    }

    public void enqueue(Node<V> node) {
          if(this.isFull()){
         return;
       }
       else if(this.isEmpty()){
        this.rear=0;
        this.front=0;
        this.queue[0]=node;
        this.currentSize+=1;
       
       }
       else{
       this.currentSize+=1;
       this.rear=((this.rear)+1);
       this.queue[this.rear]=node;
       
       
    }
    
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
          int j=0;
          if(this.isEmpty()==true){
            return null;
          }
          Node<V> min = this.queue[0];
          for(int i=1;i<this.currentSize && this.queue[i] != null;i++){
            
            if(this.queue[i].getPriority()<min.getPriority()){
                min=this.queue[i];
                j=i;
            }
          }
           
           for(;j<this.currentSize-1;j++){
            this.queue[j]=this.queue[j+1];
           }
           this.currentSize=this.currentSize-1;
           this.rear=this.rear-1;
           return (NodeBase<V>)min;
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i].show();
	}
    }
}


