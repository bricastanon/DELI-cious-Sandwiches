package com.pluralsight;

public class Customer {
    private String mane;
    private String email;

    public Customer(String mane, String email) {
        this.mane = mane;
        this.email = email;
    }
    public String getMane() { return mane;
    }
    public String getEmail() { return email;
    }
}
