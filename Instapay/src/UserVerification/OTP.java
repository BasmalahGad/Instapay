package UserVerification;

import java.util.Objects;

public class OTP {
    private String otp = "sd3$$sdf@asf11";
    public String generateOTP() {
        //fake generation
        return "sd3$$sdf@asf11";
    }
    public boolean verifyOTP(String inOtp) {
        return (Objects.equals(otp, inOtp));
    }
}
