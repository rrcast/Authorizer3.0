package main.java.com;


import java.util.List;

public class OutPut {
    private Account account;
    private List<String> violations;

    public OutPut() {

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setViolations(List<String> violations) {
        this.violations = violations;
    }

    @Override
    public String toString() {
        return "OutPut{" +
                "account=" + account +
                ", violations=" + violations +
                '}';
    }
}
