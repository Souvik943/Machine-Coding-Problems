package questions.Design_Airline_Management_System.entity;

import java.util.UUID;

public class User {
    private String userId;
    private String name;
    private String emailId;

    public User(String name, String emailId) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.emailId = emailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
