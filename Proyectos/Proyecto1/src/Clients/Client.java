package clients;

import java.util.Iterator;

import walmart.Walmart2;

public class Client implements ClientInterface {

    private String username;

    private String password;

    private Country nationality;

    private String name;

    private long phone;

    private String address;

    private int id;

    private long bankNumber;

    private Coupon coupon;

    private Walmart2 walmart;

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
        this.coupon = null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Country getNationality() {
        return nationality;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getPhone() {
        return phone;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public long getBankNumber() {
        return bankNumber;
    }

    @Override
    public Coupon getCoupon() {
        return coupon;
    }

	@Override
	public void update() {
        if (walmart != null) {
            this.coupon = walmart.getCoupon();
        }
	}

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

	@Override
	public void setWalmart(Walmart2 walmart) {
        this.walmart = walmart;
	}

}
