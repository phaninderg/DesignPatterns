package creational.factorymethod;

public abstract class MessageBroker {
    public abstract void publishMessage();

    public abstract void receiveMessage();

    public void encrypt() {
        System.out.println("Encrypting....");
    }

    public void decrypt() {
        System.out.println("Decrypting....");
    }
}
