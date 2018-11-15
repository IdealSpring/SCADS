package cn.ccut.composite;

public class Client {
    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany company = new ConcreteCompany("上海华东分公司");
        company.add(new HRDepartment("上海华东分公司人力资源部"));
        company.add(new FinanceDepartment("上海华东分公司人财务部"));
        root.add(company);

        ConcreteCompany company2 = new ConcreteCompany("南京办事处");
        company2.add(new HRDepartment("南京办事处人力资源部"));
        company2.add(new FinanceDepartment("南京办事处人财务部"));
        company.add(company2);

        ConcreteCompany company3 = new ConcreteCompany("吉林东北分公司");
        company3.add(new HRDepartment("吉林东北分公司人力资源部"));
        company3.add(new FinanceDepartment("吉林东北分公司人财务部"));
        root.add(company3);

        ConcreteCompany company4 = new ConcreteCompany("长春办事处");
        company4.add(new HRDepartment("长春办事处人力资源部"));
        company4.add(new FinanceDepartment("长春办事处人财务部"));
        company3.add(company4);

        System.out.println("结构图：");
        root.display(1);

        System.out.println("职责：");
        root.lineOfDuty();
    }
}
