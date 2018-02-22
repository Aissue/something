package test7;

/**
 * 父类
 * 测试继承问题
 */
public class Father {
    private String age;//子类不可用
    public String home;
    protected String money;

    private void test1(){}//子类不可用,不可被重写

    public void test2(){}//子类可用，可被重写

    protected void test3(){}//子类可用，可被重写

    protected final void test4(){}//子类可用，不可被重写
}
