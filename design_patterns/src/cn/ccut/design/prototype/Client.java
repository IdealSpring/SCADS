package cn.ccut.design.prototype;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume = new Resume("路人甲", 23,
                new WorkExperience("2019", "al"));
        System.out.println(resume);

        System.out.println("-------------------------");
        Resume clone = (Resume)resume.clone();
        clone.setName("小明");
        clone.setAge(12);
        clone.setWorkExperience(new WorkExperience("2022", "ccut"));
        System.out.println(clone);
    }
}
