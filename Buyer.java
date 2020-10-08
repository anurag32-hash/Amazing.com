import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    
       int catalogSize;
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
           
           this.catalog=catalog;
           this.lock=lock;
           this.full=full;
           this.empty=empty;
           this.catalogSize=catalogSize;
           setSleepTime(sleepTime);
           setIteration(iteration);
           
        }
     
     public void buy() throws InterruptedException {
	  
        this.lock.lock();
        try {
               while(this.catalog.isEmpty()){
                this.empty.await();
               }
               if(!(this.catalog.isEmpty())){
               Node<V> n=(Node<V>)this.catalog.dequeue();
               //if(n!=null){
               System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
               n.show(); // DO NOT REMOVE (For Automated Testing)
               this.full.signalAll();
           //}   
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            
            this.lock.unlock();
	}
    }
    
}

