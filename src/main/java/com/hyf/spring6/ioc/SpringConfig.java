package com.hyf.spring6.ioc;

import com.hyf.spring6.ioc.other.config.AbstractSpringConfig;
import com.hyf.spring6.ioc.other.config.SpringConfigI;
import org.springframework.context.annotation.*;

/**
 * @author baB_hyf
 * @date 2020/02/21
 * @see this:{@link ConfigurationClassParser#doProcessConfigurationClass}
 */
@Configuration
@ComponentScans(value = {
//		@ComponentScan("com.hyf.spring6.ioc.other.lifecycle"),
//		@ComponentScan("com.hyf.spring6.ioc.other.event"),
//		@ComponentScan("com.hyf.spring6.ioc.other.factory"),
//		@ComponentScan("com.hyf.spring6.ioc.other.parent"),
//		@ComponentScan("com.hyf.spring6.ioc.other.nest"),
//		@ComponentScan("com.hyf.spring6.ioc.other.common"),
		@ComponentScan("com.hyf.spring6.ioc.other.autowire"),
})
//@Import({JdbcConfig.class, EventConfig.class}) // @Import 导入的类的bean名称默认为【全路径】
@ImportResource("spring-ioc.xml")
@PropertySource("jdbc.properties")
public class SpringConfig extends AbstractSpringConfig implements SpringConfigI {

	public SpringConfig(){
		System.out.println(1);
	}

}
