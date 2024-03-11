package creational.factorymethod;

public class RabbitBroker extends MessageBroker{
    @Override
    public void publishMessage() {
        System.out.println("RabbitMQ publishing message");
    }

    @Override
    public void receiveMessage() {
        System.out.println("Received message on Rabbit");
    }
}
