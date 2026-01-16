package questions.Design_Uber.entity;

import java.util.UUID;

public class Rider {
    private String riderId;
    private String riderName;

    public Rider(String riderName) {
        this.riderId = UUID.randomUUID().toString();
        this.riderName = riderName;
    }

    public String getRiderName() {
        return riderName;
    }

    public String getRiderId() {
        return this.riderId;
    }
}
