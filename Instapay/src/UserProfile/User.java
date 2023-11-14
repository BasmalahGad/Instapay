package UserProfile;

public class User {
    String name;
    String mobile;
    String email;

    public User(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    InstapayProfile instapayProfile = new InstapayProfile();

    public InstapayProfile getInstapayProfile() {
        return instapayProfile;
    }

    public void setInstapayProfile(InstapayProfile instapayProfile){
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
}
