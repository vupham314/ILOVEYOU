public class FullName {
    private String firstName;
    private String surname;

    public FullName(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String toString(){
        return surname + " " + firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

}
