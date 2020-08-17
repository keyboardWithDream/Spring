# `SpringConfiguration`

使用一个配置类来代替`bean.xml`, 其作用和`bean.xml`相同

需要通过`AnnotationConfigApplicationContext`获取容器对象

```java
ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
```

***



## `@Configuration`注解

指定当前类是配置类

```java
@Configuration
public class SpringConfiguration {
}
```

---



## `@ComponentScan`注解

用于指定Spring在创建容器时需要扫描的包 , 等同于`<context:component-scan base-package="xxx.xx"/>`

`value` / `basePackages` : 需要扫描的(多个)包名

```java
@Configuration
@ComponentScan(basePackages = "com.study.spring")
public class SpringConfiguration {
}
```

---



## `@Bean`注解

用于把当前方法的返回值作为`Bean`对象存入Spring容器中

`name` : 指定Bean的`id`, 默认值为当前方法名称

```java
@Bean(name = "runner")
@Scope("prototype")
public QueryRunner createQueryRunner(@Qualifier("spring") DataSource ds){
	return new QueryRunner(ds);
}
```

`@Scope("prototype")`:  设置多例.

`@Qualifier("spring")`: 设置传入的Bean`id`

```java
@Bean(name = "spring")
public DataSource createDataSource(){
    ComboPooledDataSource ds = new ComboPooledDataSource();
    try {
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("Hhn004460");
        return ds;
    } catch (PropertyVetoException e) {
        e.printStackTrace();
        return null;
    }
}
```

<font color=red>**注意**</font>:当我们使用注解配置方法时, 当方法有参数, Spring会去容器中查找有没有Bean对象, 查找方式和`@Autowired`注解作用一样.



---



## `@Import`注解

用于导入其他的配置类

`value` : 其他配置类字节码数组

```java
@Import(JdbcConfiguration.class)
public class SpringConfiguration {
}
```

---



## `@PropertySource`注解

用于指定`properties`文件的位置

`value` : 指定文件的名称和路径 

​	关键字: `classpath` , 表示在类路径下

```java
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
}
```

---



## 案例

### 主配置类

```java
@Configuration
@ComponentScan(basePackages = "com.study.spring")
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
```

### 其他配置类

```java
public class JdbcConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource ds){
        return new QueryRunner(ds);
    }

    @Bean(name = "ds")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

### 配置文件

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring?serverTimezone=UTC
jdbc.user=root
jdbc.password=Hhn004460
```