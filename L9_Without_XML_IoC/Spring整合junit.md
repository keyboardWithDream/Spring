# Spring整合junit

## 整合junit配置

1. `prom`导入Spring整合junit的jar包(坐标)

   ```xml
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-test</artifactId>
       <version>5.2.8.RELEASE</version>
   </dependency>
   ```

2. 使用junit的注解替换原有的`main`方法, 替换为Spring提供的`main`方法

   `@Runwhit`注解替换运行器(`main`)

   `value` : 需要替换的运行器 字节码

   ```java
   @RunWith(SpringJUnit4ClassRunner.class)
   public class AccountServiceTest {
       ...
   }
   ```

3. 告知Spring的运行器, `IoC容器`创建的方式

   使用`@ContextConifguration`注解

   `localtion` : 指定`xml`文件的位置, 加上`classpath`关键字, 表示在类路径下

   `classes` : 指定注解配置类的字节码

   ```java
   @RunWith(SpringJUnit4ClassRunner.class)
   @ContextConfiguration(classes = SpringConfiguration.class)
   public class AccountServiceTest {
   	...
   }
   ```

   <font color=red>**注意**</font>: 当使用Spring 5.x 版本时, 要求junit的jar包必须是4.12及以上, 否则报错: 初始化失败-`java.lang.ExceptionInInitializerError`