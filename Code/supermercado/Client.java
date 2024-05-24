package supermercado;

import java.io.Serializable;
import java.lang.*;

/**
 * Class Cliente manages client
 */

public class Client implements Serializable {
    private String name;
    private String email;
    private int mobileNumber;
    private String address;

    /**
     * @param name         Name of the client
     * @param email        Email of the client, used to log
     * @param mobileNumber Mobile number of the client
     * @param address      Address of the client
     */
    public Client(String name, String email, int mobileNumber, String address) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    /**
     * Getter
     *
     * @return Name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name Sets name of the client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return Returns client email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter
     *
     * @param email Sets client email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter
     *
     * @return Returns client mobile number
     */
    public int getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Setter
     *
     * @param mobileNumber Sets mobile number
     */
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Getter
     *
     * @return Returns client address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter
     *
     * @param address Sets client address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * * toString
     *
     * @return Returns a string with client characteristics (Output: Name, Email, Mobile Number, Addres)
     */


    @Override
    public String toString() {
        return "Client -> " + "Name = " + name + " Email = " + email + " Mobile Number = " + mobileNumber + " Address = " + address + '}';
    }
}

