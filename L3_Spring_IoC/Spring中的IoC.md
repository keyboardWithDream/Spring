# Spring 中的IoC

​	**控制反转**（Inversion of Control，缩写为**IoC**），是[面向对象编程](https://baike.baidu.com/item/面向对象编程)中的一种设计原则，可以用来减低计算机代码之间的[耦合度](https://baike.baidu.com/item/耦合度)。其中最常见的方式叫做**依赖注入**（Dependency Injection，简称**DI**），还有一种方式叫“依赖查找”（Dependency Lookup）。通过控制反转，对象在被创建的时候，由一个调控系统内所有对象的外界实体将其所依赖的对象的引用传递给它。也可以说，依赖被注入到对象中。

***



## Spring 使用IoC

### 环境搭建

1. 建立Maven工程导入坐标

	```xml
	<dependencies>

    	<dependency>
        	<groupId>org.springframework</groupId>
       		<artifactId>spring-context</artifactId>
        	<version>5.0.2.RELEASE</version>
    	</dependency>

	</dependencies>
	```
	
2. 创建`XML`配置文件

   1. 添加`xml` 约束

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://www.springframework.org/schema/beans
              https://www.springframework.org/schema/beans/spring-beans.xsd">
      </beans>
      ```

   2. 配置信息

      `<bean>` 标签

      `id` : 唯一标识

      `class` : 全限定类名

      ```xml
      <!-- 把对象的创建交给spring来管理 -->
      <bean id="accountDao" class="com.study.spring.dao.impl.AccountDaoImpl"/>
      <bean id="accountService" class="com.study.spring.service.impl.AccountServiceImpl"/>
      ```
   
***

### 使用Ioc容器

通过`ClassPathXmlApplicationContext`获取IoC容器对象

```java
//1.获取核心容器对象
ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

//2.根据id获取bean对象
IAccountService service = (IAccountService) ac.getBean("accountService");
//两种方式 -- 一种不需要强转类型, 传入字节码
IAccountDao dao = ac.getBean("accountDao", IAccountDao.class);
```

***



## `ApplicationContext`常用实现类

### `ClassPathXmlApplicationContext`

<font color=red>可加载类路径下的配置文件, 要求配置文件必须在类路径下, 否则不能加载.</font>

```java
ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
```



### `FileSystemXmlApplicationContext`

<font color=red>可加载磁盘任意路径下的配置文件, 要求路径必须有访问权限.</font>

```java
ApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("E:/Code/Spring/L3_Spring_IoC/src/main/resources/bean.xml");
```



### `AnnotationConfigApplicationContext`

<font color=red>通过读取注解创建容器.</font>

***



## 核心容器的两个接口

### `ApplicationContext`

`ApplicationContext`在构建核心容器时, 创建对象是采用<u>**立即加载**</u>的方式, 只要一读取完配置文件就马上创建配置文件中的对象.(**单例对象适用**)

### `BeanFactory`

`BeanFactory`在构建核心容器时, 创建对象是采用<u>**延迟加载**</u>的方式, 什么时候根据`id`获取对象了, 什么时候创建对象.(**多例对象使用**)

