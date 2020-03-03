package com.hyf.spring2.mix.lookup;

/**
 * 用于一个单例bean中依赖一个原型对象的情况
 *
 * @author baB_hyf
 * @date 2020/02/22
 */
public abstract class LookupClass {

    public void lookupPojo() {
        Pojo pojo = createPojo();
        pojo.printMyself();
    }

    /**
     * <public|protected> [abstract] <return-type> theMethodName(no-arguments);
     */
    protected abstract Pojo createPojo();

}

class Pojo {

    public void printMyself() {
        System.out.println(this);
    }
}
