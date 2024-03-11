package structural.adapter;

//2- way adapter, can be used as object for adaptee as well as client interface
public class EmployeeClassAdapter extends Employee implements Customer{
    @Override
    public String getCustomerName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String getCustomerAddress() {
        return this.getAddress();
    }

    @Override
    public String getCustomerDesignation() {
        return this.getJobTitle();
    }
}
