package clients;

import java.util.Iterator;
import walmart.Walmart2;

/**
 * Class to implement the Proxy pattern
 * A client proxy will be used to access the client's information
 * A client proxy has a client (instance of {@link Client})
 */
public class ClientProxy implements ClientInterface {

    /* The client of the client proxy */
    private Client client;

    /**
     * Constructor
     * 
     * @param client the client of the client proxy
     */
    public ClientProxy(Client client) {
        this.client = client;
    }

    /**
     * Method to get the username of the client
     * 
     * @return the username of the client
     */
    @Override
    public String getUsername() {
        return client.getUsername();
    }

    /**
     * Method to get the password of the client
     * 
     * @return the password of the client
     */
    @Override
    public String getPassword() {
        return client.getPassword();
    }

    /**
     * Method to get nationality of the client
     * 
     * @return the nationality of the client
     */
    @Override
    public Country getNationality() {
        return client.getNationality();
    }

    /**
     * Method to get the name of the client
     * 
     * @return the name of the client
     */
    @Override
    public String getName() {
        return client.getName();
    }

    /**
     * Method to get the phone number of the client
     * 
     * @return the phone number of the client
     */
    @Override
    public long getPhone() {
        return client.getPhone();
    }

    /**
     * Method to get the address of the client
     * 
     * @return the address of the client
     */
    @Override
    public String getAddress() {
        return client.getAddress();
    }

    /**
     * Method to get the id of the client
     * 
     * @return the id of the client
     */
    @Override
    public int getId() {
        return client.getId();
    }

    /**
     * Method to get the bank number of the client
     * 
     * @return the bank number of the client
     */
    @Override
    public long getBankNumber() {
        return client.getBankNumber();
    }

    /**
     * Method to get the money of the client
     * 
     * @return the money of the client
     */
    @Override
    public double getMoney() {
        return client.getMoney();
    }

    /**
     * Method to set the clients money
     * 
     * @param money the clients money
     */
    public void setMoney(double money) {
        client.setMoney(money);
    }

    /**
     * Method to get the coupon of the client
     * 
     * @return the coupon of the client
     */
    @Override
    public Coupon getCoupon() {
        return client.getCoupon();
    }

    /**
     * Method to update the client
     */
    @Override
    public void update() {
        client.update();
    }

    /**
     * Method to check if the clients country is in the list of countries that is
     * given
     * 
     * @param iter the iterator of the list of countries
     * @return true if the client's country is in the list of countries, false if
     *         not
     */
    @Override
    public boolean check(Iterator<Country> iter) {
        return client.check(iter);
    }

    /**
     * Method to set the clients Walmart2
     * 
     * @param walmart the Walmart2 to set
     */
    @Override
    public void setWalmart(Walmart2 walmart) {
        client.setWalmart(walmart);
    }

}
