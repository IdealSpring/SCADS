package cn.ccut.design.iterator;

public class Client {
    public static void main(String[] args) {
        List list = new ListImpl();
        list.add("hello");
        list.add("word");
        list.add("java");

        Iterator iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("first: " + iterator.first());
        System.out.println("last: " + iterator.last());

        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
