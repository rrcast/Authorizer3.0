package main.java.com;


public class Transaction {
    //This class exists only in case that we need to save data of every transaction
    private String merchant;
    private Integer ammount;
    private String time;

    public Transaction(String merchant, Integer ammount, String time) {
        this.merchant = merchant;
        this.ammount = ammount;
        this.time = time;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
