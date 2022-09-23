package learn_base;


public class learnRun {
    int i = 1;
    public learnRun(){
        // thread是匿名类对象，它的run方法中用到了外部类的run方法
        // 这时由于函数同名，直接调用就不行了
        // 解决办法： 外部类的类名加上this引用来说明要调用的是外部类的方法run
        // 在该类的有事件监听或者其他方法的内部若要调用该类的引用，用this就会出错，这时可以使用类名.this，就ok了
        Thread thread = new Thread() {

            @Override
            public void run() {
                for (;;) {
                    learnRun.this.run();
                    try {
                        sleep(1000);
                    } catch (InterruptedException ie) {
                    }
                }
            }
        };
        thread.start();
    }

    public void run() {
        System.out.println("i = " + i);
        i++;
    }

    public static void main(String[] args) throws Exception {
        new learnRun();
    }
}

