package ge.mais.api.dto;

public class TestPerson {
    String firstName;
    String lastName;

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

    public TestPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
