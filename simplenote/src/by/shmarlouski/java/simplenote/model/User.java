package by.shmarlouski.java.simplenote.model;


import java.util.ArrayList;

public class User {

    private String name = "";
    private String secondName = "";
    private String email = "";
    private Role role = Role.USER;
    private ArrayList<String> phoneNumbers  = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public User(
            String name, String secondName, String email, Role role,
            ArrayList<String> phoneNumbers) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.role = role;
        this.phoneNumbers = phoneNumbers;

    }

    public User(){}

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        return (email != null ? email.equals(user.email) : user.email == null) && role == user.role
                && (phoneNumbers != null ? phoneNumbers.equals(user.phoneNumbers) : user.phoneNumbers == null);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (phoneNumbers != null ? phoneNumbers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  name + "," + secondName + ","
                + email + "," + role + "," +
                phoneNumbers.toString().replaceAll("\\[|]", "");
    }
}
