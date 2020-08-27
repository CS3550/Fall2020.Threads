/**
 *
 * @author bricks
 */
public abstract class ABankAccount {
    
    protected int balance = 0;
    
    public abstract void DepositADollar();
    
    public void DepositCash(){
        for(int i = 0; i < 10000; i++){
            DepositADollar();
        }
    }
    
    public void PrintBalance(){
        System.out.println("Balance = " + balance);
    }
    
}