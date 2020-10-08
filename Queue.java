// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize,rear;
	
    public Queue(int capacity) {    
       queue = new Node[capacity];
       this.capacity=capacity;
       this.rear=-1;
       this.currentSize=0;

    }

    public int size() {
       return this.currentSize;
    }

    public boolean isEmpty() {
       return (this.currentSize==0);
    }
	
    public boolean isFull() {
       return (this.currentSize==this.capacity);
    }

    public void enqueue(Node<V> node) {
       if(this.isFull()){
         return;
       }
       else if(this.isEmpty()){
        this.rear=0;
        this.queue[0]=node;
        this.currentSize+=1;
       
       }
       else{
       this.currentSize+=1;
       this.rear=((this.rear)+1);
       this.queue[this.rear]=node;
    }
    
    }

    public NodeBase<V> dequeue() {
        
          if(this.isEmpty()==true){
            return null;
          }
          NodeBase<V> min = this.queue[0];
           
           for(int j=0;j<this.rear;j++){
            this.queue[j]=this.queue[j+1];
           }
           this.currentSize=this.currentSize-1;
           this.rear=this.rear-1;
           return min;
    }
    public void display(){
 
      if (this.isEmpty()) {
            System.out.println("Queue is empty");
    }
        for(int i =0; i<this.currentSize;i++){
            
            System.out.println(this.queue[i].getValue());

        }
    }

}

