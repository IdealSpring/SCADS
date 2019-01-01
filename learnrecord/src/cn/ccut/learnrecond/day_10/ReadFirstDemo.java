package cn.ccut.learnrecond.day_10;

// 资源类
class Resource {
    protected String showDate = "我是共享资源";
}

// 读线程
class ReadThread implements Runnable {
    protected Resource resource;

    public ReadThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

    }
}

class WriteThrad implements Runnable {
    protected Resource resource;

    public WriteThrad(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {

    }
}

public class ReadFirstDemo {
    public static void main(String[] args) {

    }
}
