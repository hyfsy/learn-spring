package com.hyf.spring.ioc.hightest.typefilter;

import com.hyf.spring.ioc.hightest.typefilter.anno.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Properties;

/**
 * 自定义包过滤规则
 *
 * @author baB_hyf
 * @date 2020/02/15
 */
public class MyTypeFilter extends AbstractTypeHierarchyTraversingFilter {

    private PathMatcher pathMatcher;

    /**
     * 区域名称
     * 获取信息应从配置文件中读取
     * 此处不能使用@Value注解，
     * 因为负责填充属性的 InstantiationAwareBeanPostProcessor
     * 与TypeFilter实例创建根本不搭边
     */
    private String area;
    private String scanPackage;

    /**
     * 父类构造函数
     */
    protected MyTypeFilter() {
        // 不考虑基类 不考虑接口
        super(false, false);

        // 借助spring默认的通配符方式
        pathMatcher = new AntPathMatcher();

        try {
            // 获取配置文件中配置的区域信息
            Properties prop = PropertiesLoaderUtils.loadAllProperties("test/district.properties");
            scanPackage = ClassUtils.convertClassNameToResourcePath(prop.getProperty("district.scan.package"));
            area = prop.getProperty("district.area");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 此处传入的类名为@ComponentScan指定的扫描包路径下的所有类
     * <p>
     * 匹配类名
     *
     * @param className
     * @return
     */
    @Override
    protected boolean matchClassName(String className) {
        try {
            // 判断该类是否在指定的扫描包下
            if (!isPotentialPackageClass(className)) {
                return false;
            }

            Class<?> clazz = ClassUtils.forName(className, MyTypeFilter.class.getClassLoader());
            District district = clazz.getAnnotation(District.class);
            // 判断该类是否有指定注解
            if (district == null) {
                return false;
            }

            // 如果配置的名称和注解上的名称一致则扫描，否则排除
            return !area.equalsIgnoreCase(district.value());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 判断该类是否在指定扫描的包下
     */
    private boolean isPotentialPackageClass(String className) {
        String path = ClassUtils.convertClassNameToResourcePath(className);
        // 将指定的扫描包和类的资源路径进行匹配
        return pathMatcher.match(scanPackage, path);
    }
}
