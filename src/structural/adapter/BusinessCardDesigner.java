package structural.adapter;

public class BusinessCardDesigner {

    void printCard(Customer customer) {
        System.out.println(
                "\n" + customer.getCustomerName() +
                "\n" + customer.getCustomerDesignation() +
                "\n" + customer.getCustomerAddress()
        );
    }
}
