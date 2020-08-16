# 基于注解的`IoC`配置

**使用注解配置时, 在配置文件中需指定Spring需要扫描的包**

需要添加名称空间和约束

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"    xmlns:context="http://www.springframework.org/schema/context"    xsi:schemaLocation="http://www.springframework.org/schema/beans        https://www.springframework.org/schema/beans/spring-beans.xsd        http://www.springframework.org/schema/context        https://www.springframework.org/schema/context/spring-context.xsd">     <context:annotation-config/> 
    ...
</beans>
```

配置包名

```xml
<!-- 告知Spring在创建容器时要扫描的包, 使用context -->
<context:component-scan base-package="com.study.spring"/>
```

***



## 用于创建对象

**功能与`<bean>`标签相同**

---

**`@Compoenent`注解 : 用于把当前对象存入Spring容器**

`value` : 指定`bean`的 `id`, 当我们不写时, 默认值为当前类名首字母小写

```java
@Component("accountService")
public class AccountServiceImpl implements IAccountService {
    public void save() {
    }
}
```

**!注**: 为了使得三层架构的结构更加清晰, Spring提供了三个注解, 其作用和`@Compoenent`一样

`@Controller` : 一般用在表现层

`@Service` : 一般用在业务层

`@Repository` : 一般用在持久层

***



## 用于注入数据

**功能与`<property>`标签相同**

***

`@Autowired` : 自动按照类型注入, 只要容器中有**唯一的一个bean对象类型**和要注入的类型匹配, 就可以注入成功

当容器中有多个类型可以匹配时, 通过`变量名` 和 容器中的 `id`进行匹配

**出现位置** : 可以在变量上, 也可以在方法上

```java
@Autowired()
private IAccountDao dao;
```

---

`@Qualifier` : 在按照类型注入的基础上，按照名称注入。它在给类成员注入时不能单独使用，但在给方法参数注入时可以

`value` : 指定注入bean的`id`

```java
@Autowired()
@Qualifier("accountDao")
private IAccountDao dao;
```

---

`@Resource` :直接按照bean的`id`注入， 单独使用。

`name`：指定bean的`id`

```java
@Resource(name = "accountDao")
private IAccountDao dao;
```

---



### 基本类型的注入

`@value` : 用于注入基本类型和String类型的数据

`value`：指定数据的值，可使用Spring中的 `SpEL`（Spring 中的EL表达式）

`SpEL`的写法：`${表达式}`

```java
@Value(value = "test")
private String name;
```

***



## 用于改变作用范围

**功能与`scope`属性相同**

***

`@Scope`：用于指定bean的作用范围

`value`：指定范围（`singleton`，`prototype`）

```java
@Service("accountService")
@Scope(value = "prototype")
public class AccountServiceImpl implements IAccountService { 
    ... 
}
```

***



## 生命周期相关

**功能与`init-method`和`destroy-method`属性相同**

---

`@PreDestroy`：用于指定销毁方法

```java
@PreDestroy
public void destroy(){
	System.out.println("销毁方法执行...");
}
```

---

`@PostConstruct`：用于指定初始化方法

```java
@PostConstruct
public void init(){
    System.out.println("初始化方法执行...");
}
```