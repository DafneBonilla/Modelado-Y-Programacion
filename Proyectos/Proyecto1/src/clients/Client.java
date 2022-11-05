package clients;

import java.util.Iterator;
import walmart.Walmart2;

/**
 * Class to represent a client
 * A client has a username, a password, a nationality (instance of
 * {@link Country}),
 * a name, a phone number, an address, an id, a bank number, a amount of money,
 * a coupon (instance of {@link Coupon}) and a Walmart2 (instance of
 * {@link Walmart2})
 */
public class Client implements ClientInterface {

    /* The username of the client */
    private String username;

    /* The password of the client */
    private String password;

    /* The nationality of the client */
    private Country nationality;

    /* The name of the client */
    private String name;

    /* The phone number of the client */
    private long phone;

    /* The address of the client */
    private String address;

    /* The id of the client */
    private int id;

    /* The bank number of the client */
    private long bankNumber;

    /* The amount of money of the client */
    private double money;

    /* The coupon of the client */
    private Coupon coupon;

    /* The Walmart2 of the client */
    private Walmart2 walmart;

    /**
     * Constructor
     * 
     * @param builder the builder to build the client
     */
    public Client(ClientBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.nationality = builder.nationality;
        this.name = builder.name;
        this.phone = builder.phone;
        this.address = builder.address;
        String nat = nationality.toString();
        String num = Long.toString(phone);
        this.id = name.charAt(0) + name.charAt(name.length() - 1) + nat.charAt(0) + nat.charAt(nat.length() - 1)
                + num.charAt(0) + num.charAt(num.length() - 1) + address.charAt(0)
                + address.charAt(address.length() - 1);
        this.bankNumber = builder.bankNumber;
        this.money = builder.money;
        this.coupon = null;
    }

    /**
     * Method to get the username of the client
     * 
     * @return the username of the client
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Method to get the password of the client
     * 
     * @return the password of the client
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Method to get nationality of the client
     * 
     * @return the nationality of the client
     */
    @Override
    public Country getNationality() {
        return nationality;
    }

    /**
     * Method to get the name of the client
     * 
     * @return the name of the client
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Method to get the phone number of the client
     * 
     * @return the phone number of the client
     */
    @Override
    public long getPhone() {
        return phone;
    }

    /**
     * Method to get the address of the client
     * 
     * @return the address of the client
     */
    @Override
    public String getAddress() {
        return address;
    }
    /**
     * Method to get the id of the client
     * 
     * @return the id of the client
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Method to get the bank number of the client
     * 
     * @return the bank number of the client
     */
    @Override
    public long getBankNumber() {
        return bankNumber;
    }

    /**
     * Method to get the money of the client
     * 
     * @return the money of the client
     */
    @Override
    public double getMoney() {
        return money;
    }

    /**
     * Method to set the clients money
     * 
     * @param money the clients money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Method to get the coupon that the client has
     * 
     * @return the coupon that the client has
     */
    @Override
    public Coupon getCoupon() {
        return coupon;
    }

    /**
     * Method to update the client
     */
    @Override
    public void update() {
        if (walmart != null) {
            this.coupon = walmart.getCoupon();
        }
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
        Country c;
        while (iter.hasNext()) {
            c = iter.next();
            if (c.getInt() == nationality.getInt()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to set the Walmart2 of the client
     * 
     * @param walmart the Walmart2 of the client
     */
    @Override
    public void setWalmart(Walmart2 walmart) {
        this.walmart = walmart;
    }

}
