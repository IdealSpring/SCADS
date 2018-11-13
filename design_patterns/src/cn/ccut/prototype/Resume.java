package cn.ccut.prototype;

/**
 * @author zhipeng_Tong
 */
public class Resume implements Cloneable{
    private String name;
    private int age;
    private WorkExperience workExperience;

    public Resume() {
    }

    public Resume(String name, int age, WorkExperience workExperience) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume resume = null;

        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", " + "\n\t" + "workExperience=" + workExperience +
                '}';
    }
}
