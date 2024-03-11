package creational.factorymethod;

public class Main {
    public static void main(String[] args) {
        publishMessage(new KafkaBrokerCreator());
        publishMessage(new RabbitBrokerCreator());
    }

    private static void publishMessage(MessageBrokerCreator messageBrokerCreator) {
        MessageBroker messageBroker = messageBrokerCreator.publishMessage();
        messageBroker.receiveMessage();
    }
}
