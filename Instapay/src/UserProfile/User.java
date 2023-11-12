package UserProfile;
import java.util.Date;

public class User {
    String name;
    String mobile;
    String email;
    String city;
    char gender;
    Date dob;
    InstapayProfile instapayProfile = new InstapayProfile();

    public InstapayProfile getInstapayProfile() {
        return instapayProfile;
    }

    public void setInstapayProfile(InstapayProfile instapayProfile) {
        this.instapayProfile = instapayProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
