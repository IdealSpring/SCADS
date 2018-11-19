package cn.ccut.observer;

/**
 * ConcreteSubject
 * @author zhipeng_Tong
 */
public class Boss extends Subject {
    private String subjectState;    // 保存状态信息

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
