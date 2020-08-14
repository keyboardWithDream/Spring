# Spring对Bean的管理

## 创建Bean的方式

### 1.默认构造函数创建

使用默认构造函数创建
在Spring的配置文件中, 使用`<bean>`标签, 配以`id`和`class`属性后, 且没有其他属性和标签时, 采用的就是默认构造函数创建Bean对象, 如果类中没有默认构造函数, 则对象无法创建.

```xml
<bean id="accountService" class="com.study.spring.service.impl.AccountServiceImpl"/>
```



### 2.使用类中的方法创建对象

使用某个类(如: 工厂类)中的方法创建对象, 并存入`Spring`容器

```java
public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
```

首先配置工厂信息

然后配置Bean对象信息

`factory-bean` : 工厂的`id`

`factory-method` : 工厂中创建Bean对象的方法

```xml
<bean id="instanceFactory" class="com.study.spring.factory.InstanceFactory"/>
<bean id="accountService" factory-bean="instanceFactory" factory-method="getAccountService"/>
```



### 3.使用类中的静态方法创建

使用某个类(如: 工厂类)中的静态方法创建对象, 并存入`Spring`容器

```java
public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
```

直接配置Bean对象信息

`class` : 工厂类的全限定类名

`factory-method`: 工厂中创建Bean对象的静态方法

```xml
<bean id="accountService" class="com.study.spring.factory.StaticFactory" factory-method="getAccountService"/>
```

***



## Bean的作用范围

通过`<bean>`标签的`scope`属性调整 Bean对象的作用范围

```xml
<bean id="xxx" class="xxx" scope="xxx"/>
```

### `scope`属性的取值

1. `singleton` : 单例 (默认值)
2. `prototype` : 多例
3. `request` : 作用于web应用的请求范围
4. `session` : 作用于web应用的会话范围
5. `global-session` : 作 用于集群环境的范围 (全局会话范围), 当不是集群环境时, 它就是`session`



## Bean的生命周期

### 单例对象

**<font color=red>单例对象的生命周期和容器相同</font>**

**出生**: 当容器创建时出生

**活着**: 只要容器还在, 对象一直或者

**死亡**: 容器销毁, 对象消亡

### 多例对象

**出生**: 使用对象时Spring创建

**活着**: 对象只要是在使用过程中就一直活着

**死亡**: 当对象长时间不用, 且没有别的对象引用时, 由`Java`的垃圾回收即使回收