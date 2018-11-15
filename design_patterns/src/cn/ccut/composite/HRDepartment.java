package cn.ccut.composite;

/**
 * Leap
 * @author zhipeng_Tong
 */
public class HRDepartment extends Company {
    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("-");
        System.out.println(name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(String.format("%s 员工招聘培训管理", name));
    }
}
