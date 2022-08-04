package wolox.lambdas.demo.model;

public class Wallet {
    private String currency;
    private Double money;

    public Wallet(String currency, Double money) {
        this.currency = currency;
        this.money = money;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
