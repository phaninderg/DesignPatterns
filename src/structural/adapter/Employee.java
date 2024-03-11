package structural.adapter;

public class Employee {
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddress() {
        return address.getStreetAddress() +
                "\n" + address.getCity() +
                "\n" + address.getState() +
                "\n" + address.getCountry() +
                "\n" + address.getPincode();
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
