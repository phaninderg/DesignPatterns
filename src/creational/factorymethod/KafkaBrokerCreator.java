package creational.factorymethod;

public class KafkaBrokerCreator extends MessageBrokerCreator {
    @Override
    public MessageBroker createMessageBroker() {
        return new KafkaBroker();
    }
}
