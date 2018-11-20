package cn.ccut.design.visitor;

import java.util.ArrayList;

/**
 * ObjectStructure
 *
 * @author zhipeng_Tong
 */
public class ObjectStructure {
    private ArrayList<Person> list = new ArrayList<>();

    // 添加
    public void attach(Person person) {
        list.add(person);
    }

    // 删除
    public void delete(Person person) {
        list.remove(person);
    }

    // 查看
    public void display(Action visitor) {
        for (Person person : list)
            person.accept(visitor);
    }
}
