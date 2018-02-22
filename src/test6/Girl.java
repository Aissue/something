package test6;

import test7.Father;

/**
 * Created by Administrator on 2018/1/26.
 * 测试子类对protected的使用
 */
public class Girl extends Father{
    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.money = "dfdf";
    }
}
