package structural.adapter;

public class EmployeeObjectAdapter implements Customer{

    private Employee employee;

    public EmployeeObjectAdapter(Employee employee) {
        this.employee = employee;
    }
    @Override
    public String getCustomerName() {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public String getCustomerAddress() {
        return employee.getAddress();
    }

    @Override
    public String getCustomerDesignation() {
        return employee.getJobTitle();
    }
}
