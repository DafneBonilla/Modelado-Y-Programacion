package clients;

import java.io.Serializable;
import java.util.Iterator;
import walmart.*;

/**
 * Interface to represent a client and implement the Proxy pattern
 * It can be serialized
 */
public interface ClientInterface extends Serializable, Observer {

    /**
     * Method to get the username of the client
     * 
     * @return the username of the client
     */
    public String getUsername();

    /**
     * Method to get the password of the client
     * 
     * @return the password of the client
     */
    public String getPassword();

    /**
     * Method to get nationality of the client
     * 
     * @return the nationality of the client
     */
    public Country getNationality();

    /**
     * Method to get the name of the client
     * 
     * @return the name of the client
     */
    public String getName();

    /**
     * Method to get the phone number of the client
     * 
     * @return the phone number of the client
     */
    public long getPhone();

    /**
     * Method to get the address of the client
     * 
     * @return the address of the client
     */
    public String getAddress();

    /**
     * Method to get the id of the client
     * 
     * @return the id of the client
     */
    public int getId();

    /**
     * Method to get the bank number of the client
     * 
     * @return the bank number of the client
     */
    public long getBankNumber();

    /**
     * Method to get the money of the client
     * 
     * @return the money of the client
     */
    public double getMoney();

    /**
     * Method to set the clients money
     * 
     * @param money the clients money
     */
    public void setMoney(double money);

    /**
     * Method to get the coupon that the client has
     * 
     * @return the coupon that the client has
     */
    public Coupon getCoupon();

    /**
     * Method to update the client
     */
    @Override
    public void update();

    /**
     * Method to check if the clients country is in the list of countries that is
     * given
     * 
     * @param iter the iterator of the list of countries
     * @return true if the client's country is in the list of countries, false if
     *         not
     */
    public boolean check(Iterator<Country> iter);

    /**
     * Method to set the clients Walmart2
     * 
     * @param walmart the Walmart2 to set
     */
    public void setWalmart(Walmart2 walmart);

}
