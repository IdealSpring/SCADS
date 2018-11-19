package cn.ccut.design.prototype;

/**
 * @author zhipeng_Tong
 */
public class WorkExperience implements Cloneable{
    private String date;
    private String address;

    public WorkExperience(String date, String address) {
        this.date = date;
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "date='" + date + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
