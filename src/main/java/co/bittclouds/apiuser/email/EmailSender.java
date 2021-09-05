package co.bittclouds.apiuser.email;

public interface EmailSender {
    void send(String to, String email);
}
