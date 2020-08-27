
/**
 * 
 * @author B Ricks, PhD <bricks@unomaha.edu>
 */
public class Main {

    public static void main(String[] args) {
        try {
            
            serialDeposit();
            
            unsafeThreadedDeposit();
                        
            safeThreadedDeposit();
            
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
    }

	
	private static void serialDeposit() {
		ABankAccount b = new UnsafeAccount();            
		b.DepositCash();            
		b.DepositCash();            
		System.out.println("Two sequential for loops:");            
		b.PrintBalance();
	}

	private static void unsafeThreadedDeposit() throws InterruptedException {
		//Thread code with unlocked code underneath.
		
		final ABankAccount b2 = new UnsafeAccount();
		
		//Create two runnable instances pointing to b2
		Runnable unsafeRunnable1 = ()->b2.DepositCash();
		Runnable unsafeRunnable2 = ()->b2.DepositCash();
		
		
		//Create two threads pointing to these runnables
		
		Thread unsafeThread1 = new Thread(unsafeRunnable1);
		Thread unsafeThread2 = new Thread(unsafeRunnable2);
		
		//Start these threads
		
		unsafeThread1.start();
		unsafeThread2.start();
		
		//Wait for these threads to finish
		
		unsafeThread1.join();
		unsafeThread2.join();
		
		//Print the sum
		
		System.out.println("Two threads unlocked");
		b2.PrintBalance();
	}
	
	private static void safeThreadedDeposit() throws InterruptedException {
		//Threaded code with locked code underneath
		final ABankAccount b3 = new SafeAccount();
		
         //Create two runnable instances pointing to b2
		
		Runnable safeRunnable1 = ()->b3.DepositCash();
		Runnable safeRunnable2 = ()->b3.DepositCash();
		
		//Create two threads pointing to these runnables
		
		Thread safeThread1 = new Thread(safeRunnable1);
		Thread safeThread2 = new Thread(safeRunnable2);
		
		//Start these threads
		
		safeThread1.start();
		safeThread2.start();
		
		//Wait for these threads to finish
		
		safeThread1.join();
		safeThread2.join();
		
		//Print the sum
		
		System.out.println("Two threads locked");
		b3.PrintBalance();
	}

    
}