package creational.factorymethod;

public abstract class MessageBrokerCreator {
    public MessageBroker publishMessage() {
        MessageBroker messageBroker = createMessageBroker();
        messageBroker.encrypt();
        messageBroker.publishMessage();
        return messageBroker;
    }

    public MessageBroker receiveMessage() {
        MessageBroker messageBroker = createMessageBroker();
        messageBroker.decrypt();
        messageBroker.receiveMessage();
        return messageBroker;
    }
    public abstract MessageBroker createMessageBroker();
}
