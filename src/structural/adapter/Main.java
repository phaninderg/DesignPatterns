package structural.adapter;

public class Main {
    public static void main(String[] args) {
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        populateEmployeeInfo(adapter);
        BusinessCardDesigner cardDesigner = new BusinessCardDesigner();
        cardDesigner.printCard(adapter);
        System.out.println("********************************************");

        Employee employee = new Employee();
        populateEmployeeInfo(employee);
        EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
        cardDesigner.printCard(objectAdapter);
    }

    private static void populateEmployeeInfo(Employee employee) {
        employee.setFirstName("Phaninder");
        employee.setLastName("Gattu");
        employee.setJobTitle("Engineering Manager");
        Address address = new Address();
        address.setStreetAddress("4-121/11/1 TRK Reddy Enclave Saibaba Nagar");
        address.setCity("Hyderabad");
        address.setState("Telangana");
        address.setCountry("India");
        address.setPincode("500030");
        employee.setAddress(address);
    }
}
