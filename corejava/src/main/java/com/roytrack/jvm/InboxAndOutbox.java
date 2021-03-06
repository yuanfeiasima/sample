package com.roytrack.jvm;

/**
 * Created by roytrack on 2015/8/14.
 * Integer 默认将-128到127缓存到整数缓存
 * Cache to support the object identity semantics of autoboxing for values between
 * -128 and 127 (inclusive) as required by JLS.
 * 可以用-XX:AutoBoxCacheMax=<size> 来修改
 * 如果没有进行计算的时候，java不会进行自动拆装箱
 * 运算结束也不会进行自动的类型转换
 */
public class InboxAndOutbox {
    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println("number to object 2=b:" + (2==b));
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        Integer _a=new Integer(4);
        Integer _b=new Integer(4);
        System.out.println(_a==_b);
        System.out.println(_a.equals(_b));
    }
}
