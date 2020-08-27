import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author B Ricks, PhD <bricks@unomaha.edu>
 */
public class SafeAccount extends ABankAccount {

    Lock lock = new ReentrantLock();

    @Override
    public void DepositADollar() {
       lock.lock();
        try {
            balance++;
        } finally {
            lock.unlock();
        }
    }
}