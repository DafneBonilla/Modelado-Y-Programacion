package clients;

import java.io.Serializable;
import java.util.Iterator;

import walmart.Walmart2;

public interface ClientInterface extends Serializable, Observer {

    public String getUsername();

    public String getPassword();

    public Country getNationality();

    public String getName();

    public long getPhone();

    public String getAddress();

    public int getId();

    public long getBankNumber();

    public Coupon getCoupon();

    @Override
    public void update();

    public boolean check(Iterator<Country> iter); 
    
    public void setWalmart(Walmart2 walmart);

}
