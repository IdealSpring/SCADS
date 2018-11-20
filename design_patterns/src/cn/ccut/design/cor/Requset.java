package cn.ccut.design.cor;

/**
 * Bean
 *
 * @author zhipeng_Tong
 */
public class Requset {
    private String requestType; // 申请类型
    private String requsetContent;  // 申请内容
    private int number; // 数量

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequsetContent() {
        return requsetContent;
    }

    public void setRequsetContent(String requsetContent) {
        this.requsetContent = requsetContent;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
