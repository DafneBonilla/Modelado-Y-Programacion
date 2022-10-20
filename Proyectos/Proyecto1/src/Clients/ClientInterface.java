package Clients;

import java.io.Serializable;

public interface ClientInterface extends Serializable {

    public String getUsername();

    public String getPassword();

    public Country getNationality();

    public String getName();

    public long getPhone();

    public String getAddress();

    public int getId();

    public long getBankNumber();

    public void setCoupon(Coupon coupon);

    public Coupon getCoupon();

}
