package creational.factorymethod;

public class KafkaBroker extends MessageBroker{
    @Override
    public void publishMessage() {
        System.out.println("Kafka publishing message");
    }

    @Override
    public void receiveMessage() {
        System.out.println("Received message on Kafka");
    }
}
