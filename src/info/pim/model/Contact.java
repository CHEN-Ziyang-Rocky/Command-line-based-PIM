package info.pim.model;

import java.io.Serializable;

/**
 * Contacts Model
 */
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String address;

    private String mobile;

    public void copyData(Contact source) {
        this.name = source.name;
        this.address = source.address;
        this.mobile = source.mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
