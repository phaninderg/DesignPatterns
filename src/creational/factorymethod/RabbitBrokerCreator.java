package creational.factorymethod;

public class RabbitBrokerCreator extends MessageBrokerCreator {
    @Override
    public MessageBroker createMessageBroker() {
        return new RabbitBroker();
    }
}
