
package aayush.atharva.igi2.multiplayer.launcher.authentication;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.swing.JOptionPane;
import launcher.ServerConnector;

/**
 *
 * @author Hyper
 */
public class SignUp {

    private String Name;
    private String MP_Name;
    private String Email;
    private String Username;
    private String Password;
    private String OSName;
    private String PCName;

    public SignUp(String Name, String MP_Name, String Email, String Username, String Password, String OSName, String PCName) {
        this.Name = Name;
        this.MP_Name = MP_Name;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.OSName = OSName;
        this.PCName = PCName;
    }

    public void SignUp() throws UnsupportedEncodingException, IOException {

        String Data = "Query=Sign_Up" + "\n"
                + "Name=" + getName() + "\n"
                + "Username=" + getUsername() + "\n"
                + "MP_Name=" + getMP_Name() + "\n"
                + "Email=" + getEmail() + "\n"
                + "Password=" + getPassword() + "\n"
                + "OSName=" + getOSName() + "\n"
                + "PCName=" + getPCName();

        String Response = new ServerConnector(Data).Server();

        Properties ResponseData = new Properties();
        InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
        ResponseData.load(input);

        if (ResponseData.getProperty("Response").equals("Continue_Verification_New_Account") || ResponseData.getProperty("Response").contains("Verification Code Already Sent To Your Email")) {

            String Code = null;

            if (ResponseData.getProperty("Response").contains("Verification Code Already Sent To Your Email")) {
                JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
                Code = JOptionPane.showInputDialog(null, "A verification code has been already sent your Email.\nCheck Spam Folder of your Email if you don't find the code in Inbox.\nPlease enter the code.", "Enter The Verification Code", 1);
            } else {
                Code = JOptionPane.showInputDialog(null, "A verification code has been sent to your Email.\nCheck Spam Folder of your Email if you don't find the code in Inbox.\nPlease enter the code.", "Enter The Verification Code", 1);
            }

            if (Code == null) {
                JOptionPane.showMessageDialog(null, "Sign Up Request Cancelled");
                return;
            }

            Data = Data + "\n" + "EmailCode=" + Code;

            Response = new ServerConnector(Data).Server();
            input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
            ResponseData.load(input);

            if (ResponseData.getProperty("Response").equals("Account Created Successfully")) {
                JOptionPane.showMessageDialog(null, "Your Account Has Been Successfully Created!\nSign In To Start IGI-2 Multiplayer Launcher", "Welcome To IGI-2 Multiplayer", JOptionPane.PLAIN_MESSAGE);
            } else if (ResponseData.getProperty("Response").equals("Wrong Verification Code")) {
                JOptionPane.showMessageDialog(null, "You've entered wrong verification code.\nTry Again by clicking on \"Sign Up\" button.", "Verification Code Wrong", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public String getOSName() {
        return OSName;
    }

    public String getPCName() {
        return PCName;
    }

    public String getName() {
        return Name;
    }

    public String getMP_Name() {
        return MP_Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

}
