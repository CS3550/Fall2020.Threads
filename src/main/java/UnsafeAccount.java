/**
 *
 * @author B Ricks, PhD <bricks@unomaha.edu>
 */
public class UnsafeAccount extends ABankAccount {
    
    @Override
    public void DepositADollar(){
        //balance = balance + 1;
        balance++;
    }
    
    
}