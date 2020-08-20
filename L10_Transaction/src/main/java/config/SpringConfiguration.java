package config;

import org.springframework.context.annotation.*;

/**
 * @author Harlan
 * @date 2020/8/17 14:31
 * 配置类: 作用和Bean.xml相同
 */
@Configuration
@ComponentScan(basePackages = "com.study.spring")
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
