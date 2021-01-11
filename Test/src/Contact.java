
public class Contact {
    private String telNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dob;
    private String email;

    public Contact( String telNumber, String group, String name, String gender, String address, String dob, String email) {
        this.telNumber = telNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setGroup(String group) {
        this.group = group;
    }


    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCVS() {
        return String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", telNumber, group, name, gender, address, dob, email);
    }

    @Override
    public String toString() {
        return "Contact{" +
                ", telNumber='" + telNumber + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
