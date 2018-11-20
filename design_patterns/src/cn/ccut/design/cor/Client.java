package cn.ccut.design.cor;

public class Client {
    public static void main(String[] args) {
        CommonManager commonManager = new CommonManager("经理");
        Majordomo majordomo = new Majordomo("总监");
        GeneralManager generalManager = new GeneralManager("总经理");

        commonManager.setSuperior(majordomo);
        majordomo.setSuperior(generalManager);

        Requset requset = new Requset();
        requset.setRequestType("请假");
        requset.setRequsetContent("小明请假");
        requset.setNumber(1);
        commonManager.requestApplications(requset);
        System.out.println("--------------------");

        requset.setRequestType("请假");
        requset.setRequsetContent("小明请假");
        requset.setNumber(4);
        commonManager.requestApplications(requset);
        System.out.println("--------------------");

        requset.setRequestType("加薪");
        requset.setRequsetContent("小明请求加薪");
        requset.setNumber(500);
        commonManager.requestApplications(requset);
        System.out.println("--------------------");

        requset.setRequestType("加薪");
        requset.setRequsetContent("小明请求加薪");
        requset.setNumber(5000);
        commonManager.requestApplications(requset);
        System.out.println("--------------------");
    }
}
