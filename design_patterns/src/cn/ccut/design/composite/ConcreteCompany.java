package cn.ccut.design.composite;

import java.util.ArrayList;

/**
 * Composite
 * @author zhipeng_Tong
 */
public class ConcreteCompany extends Company{
    private ArrayList<Company> companies = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        companies.add(company);
    }

    @Override
    public void remove(Company company) {
        companies.remove(companies);
    }

    @Override
    public void display(int depth) {
        toDisplay(depth);

        for (Company c : companies)
            c.display(depth + 2);
    }

    private void toDisplay(int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("-");
        System.out.println(name);
    }

    @Override
    public void lineOfDuty() {
        for (Company c : companies)
            c.lineOfDuty();
    }
}
