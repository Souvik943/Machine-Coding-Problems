package questions.Design_Uber.entity;

import java.util.UUID;

public class Fare {
    private String fareId;
    private double amount;
    private double ttl;
    private double createdAt;

    public Fare(double amount, double ttl) {
        this.fareId = UUID.randomUUID().toString();
        this.amount = amount;
        this.ttl = ttl;
        this.createdAt = System.currentTimeMillis();
    }

    public String getFareId() {
        return fareId;
    }

    public double getAmount() {
        return amount;
    }

    public double getTtl() {
        return ttl;
    }

    public double getCreatedAt() {
        return createdAt;
    }

    public boolean isFareValid() {
        return System.currentTimeMillis() <= this.createdAt + (ttl*1000);
    }
}
