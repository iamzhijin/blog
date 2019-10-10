public class TestStatic {
    int id;
    String name;
    String pwd;

    static String msg = "是否有登录";

    TestStatic(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static void getToken(){
        // 静态方法中无法调用非静态方法
//        login();
        System.out.println("登录前先获取token");
    }

    public void login(){
        // 非静态方法可以调用静态方法及静态属性
        getToken();
        System.out.println(msg);
        System.out.println("登录成功");
    }

    static {
        System.out.println("我是静态初始化块，我比构造器更早执行");
    }

    public static void main(String[] args) {
        TestStatic myStatic = new TestStatic(11, "dada");
        myStatic.login();
        // 静态方法从属于类，只要得到类就可调用静态方法，无需实例化
        TestStatic.getToken();
        myStatic.getToken();
    }
}
