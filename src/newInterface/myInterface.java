package newInterface;

public interface myInterface {
    /**
     * 凡是该接口的实现，都会有使用这个方法的权限
     * 类似于模板模式
     * @return
     */
    default String test(){
        return "test:"+normal2();
    }

    static String test2(){
        return "test2";
    }

    String normal1(String str);
    String normal2();
}
