package annotations;

import lombok.Data;

@Data
public class AccountManager {

    private String name;
    @BankingSecurityLevel(securityLevel = SecurityLevelType.HIGH)
    public double deposit(int accountId, int amount){
        System.out.println("deposit..." + amount);
        return amount;
    }

    @BankingSecurityLevel(securityLevel = SecurityLevelType.HIGH)
    public boolean withdraw (int accountId, int amount){
        System.out.println("withdraw..." + amount);
        return true;
    }

    @BankingSecurityLevel(securityLevel = SecurityLevelType.LOW)
    public boolean convert (double amount){
        System.out.println("convert..." + amount);
        return true;
    }

    @BankingSecurityLevel
    public boolean transfer (double amount){
        System.out.println("transfer..." + amount);
        return true;
    }
}
