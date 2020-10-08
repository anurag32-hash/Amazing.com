import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	int catalogSize;
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        this.catalog=catalog;
        this.inventory=inventory;
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        this.catalogSize=catalogSize;
        setSleepTime(sleepTime);
    }
    
    public void sell() throws InterruptedException {
	
        this.lock.lock();
        try {
               while(this.catalog.isFull()){
                this.full.await();
               }
               if(!(this.catalog.isFull())){
                if(!(this.inventory.isEmpty())){
               this.catalog.enqueue((Node<V>)inventory.dequeue());
               this.empty.signalAll(); 
               }   
           }
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            
               this.lock.unlock();
	}		
    }
    
}
