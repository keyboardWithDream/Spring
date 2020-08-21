# AOP



## AOP相关概念

### 什么是AOP

​	AOP: Aspect Oriented Programming - 面向切面编程，通过预编译方式和运行期动态代理实现程序的统一维护的一种技术。 AOP是OOP的延续，是软件开发的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑部分之间的耦合度降低，提高程序的可重用性，同时提高开发效率。<u>简单的说就是把程序重复的代码抽取出来，在需要运行的时候，使用动态代理的技术，在不修改源码的基础上，对我们已有方法进行增强。</u>

***

### AOP的优势

作用：在程序运行期间，不修改源码对已有方法进行增强。

优势：减少重复代码，提高开发效率，方便维护

***

### AOP的实现方式

使用动态代理技术

***

***

## Spring的AOP

### AOP相关术语

`Joinpoint`（连接点）：指那些被拦截到的点。在Spring中，这些点指的是方法，因为Spring只支持方法类型的连接点。

`Pointout`（切入点）：指我们要对那些`Joinpoint`进行拦截的定义。

`Advice`（通知/增强）：指拦截到的`Joinpoint`之后要做的事情就是通知，包括；前置通知、后置通知、异常通知、最终通知、环绕通知。

`Introduction`（引介）：一种特殊的通知在不修改类型代码的前提下，`Introduction`可以在运行期间为类动态添加方法或`Field`。

`Target`（目标对象）：代理的目标对象。

`Weaving`（织入）：指把增应用到目标对象来创建新的代理对象的过程。

`Proxy`（代理）：一个被AOP织入增强后，就产生一个结构代理类。

`Aspect`（切面）：是切入点和通知（引介）的结合。

***

### AOP中需明确的事

#### 开发阶段

1. 编写核心业务代码
2. 提取公共代码，制作成通知
3. 在配置文件中，声明切入点与通知间的关系，即切面

#### 运行阶段（框架完成）

​	Spring框架监控接入点方法的执行。一旦监控到切入点方法被运行，使用代理机制，动态创建目标对象的代理对象，根据通知类别，在代理对象的对应位置，将通知对应的功能织入，完成完整的代码逻辑运行。

***

***

## Spring基于XML的AOP

<font color=green>**1.配置文件导入AOP约束**</font>

`bean.xml`中导入`xmlns:aop`的约束

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">
        
</bean>
```

`prom.xml`中导入解析坐标

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.7</version>
</dependency>
```

***

<font color=green>**2.配置相关IoC的Bean对象**</font>

```xml
<!-- 配置Spring的IoC，把Service对象配置进来 -->
<bean id="accountService" class="com.study.spring.service.impl.AccountServiceImpl"/>
```

***

<font color=green>**3.配置AOP**</font>

<font color=green>**3.1.配置相关通知Bean**</font>

```xml
<bean id="logger" class="com.study.spring.utils.Logger"/>
```

<font color=green>**3.2.使用`<aop:config>`标签开始配置AOP**</font>

<font color=green>**3.3.使用`<aop:aspect>`标签开始配置切面**</font>

**属性**：

`id`：给切面提供一个唯一标识

`ref`：指定通知类bean的`id`

```xml
<aop:config>
    <aop:aspect id="logAdvice" ref="logger">
        
    </aop:aspect>
</aop:config>
```

<font color=green>**3.4.使用`<aop:aspect>`标签内使用对应标签配置通知类型**</font>

`<aop:before>`：前置通知

`<aop:after-returning>`: 后置通知

`<aop:after-throwing>`: 异常通知

`<aop:after>`: 最终通知

`<aop:around>`: 环绕通知

**属性**：

`method`：指定`Logger`类中哪个方法是前置通知

`pointcut`：指定切入点表达式，用于哪些方法进行增强

​	**关键字**：`execution()`

​	**表达式**：`访问修饰符	返回值	全限定类名.方法名(参数列表)`

```xml
<aop:before method="printLog" pointcut="execution(public void com.study.spring.service.impl.AccountServiceImpl.save())"/>
```

**全通配表达式**：`*	*..*.*(..)`

访问修饰符可省略，返回值可使用`*`（任何返回值），包名可使用`*`（任意包，有几级写几级）,包名可使用`..`（当前包及其子包），类名和方法名可使用`*`（任意类、方法），`..`（任意类型参数）-基本类型直接写-引用类型写全限定类名

```xml
<aop:before method="printLog" pointcut="execution(* *..*.*(..))"/>
```

**配置切入点表达式**: `<aop:pointcut>`标签 ,`id`: 指定唯一标识, `expression`: 指定表达式内容

```xml
<aop:pointcut id="transactionPoint" expression="execution(* com.study.spring.service.impl.*.*(..))"/>
```

---

**环绕通知**: 通过手动编码实现

```java
public Object aroundPrintLog(ProceedingJoinPoint joinPoint){
    Object result = null;
    try {
        Object[] args = joinPoint.getArgs();
        System.out.println("环绕通知");
        result = joinPoint.proceed(args);
        System.out.println("环绕通知");
        return result;
    } catch (Throwable throwable) {
        System.out.println("环绕通知");
        throw new RuntimeException(throwable);
    }finally {
        System.out.println("环绕通知");
    }
}
```

***

<font color=green>**完整配置**</font>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 配置Spring的IoC，把Service对象配置进来 -->
    <bean id="accountService" class="com.study.spring.service.impl.AccountServiceImpl"/>

    <!-- Spring中基于xml的AOP配置 -->
    <bean id="logger" class="com.study.spring.utils.Logger"/>

    <!-- 使用aop:config标签表明开始AOP的配置 -->
    <aop:config>
        <aop:aspect id="logAdvice" ref="logger">
            <aop:before method="printLog" pointcut="execution(public void com.study.spring.service.impl.AccountServiceImpl.save())"/>
        </aop:aspect>
    </aop:config>
</beans>
```

***

---

## Spring基于注解的AOP



