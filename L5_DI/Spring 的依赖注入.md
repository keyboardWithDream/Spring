# Spring 的依赖注入

## 依赖注入概述

**依赖注入 (Dependency Injection)**

​	`IoC`的作用为降低程序间的耦合 (依赖关系)  , 对于依赖关系的管理都交给`Spring`来维护, 在当前类需要用到其他类的对象, 由`Spring`来提供, 我们只需要在配置文件中说明, 对于**依赖关系的维护**就称为 依赖注入.

​	依赖注入的数据有3类; 基本类型和`String`, 其他类型bean, 复杂类型(集合).

​	依赖注入的方式有3种; 使用构造函数提供, 使用`set`方法提供, 使用注解提供

***



## 构造函数注入

<font color=red>**优势: 在获取Bean对象时, 注入数据时必须的操作, 否则对象无法创建成功.**</font>

<font color=green>**弊端: 改变了Bean对象的实例化方式, 使创建对象时, 如果用不到这些数据, 也必须提供.**</font>

使用`<constructor-arg>` 标签

|  属性   |                             取值                             |
| :-----: | :----------------------------------------------------------: |
| `type`  | 指定要注入的数据的**数据类型**, 该数据类型也是构造函数中某个或某些参数的类型 |
| `index` | 指定要注入的数据给构造函数中指定**索引**的参数赋值, **索引位置从0开始** |
| `name`  |             指定构造函数中指定**名称**的参数赋值             |
|  `ref`  | 指定其他的**Bean类型**, 指在`Spring`的`IoC`核心容器中出现过的`Bean`对象 |
| `value` |               提供基本类型和`String`类型的数据               |

```xml
<!-- 构造函数注入 -->
<bean id="accountService" class="com.study.spring.service.impl.AccountServiceImpl">
    <constructor-arg name="name" value="test"/>
    <constructor-arg name="age" value="18"/>
    <constructor-arg name="birthday" ref="now"/>
</bean>

<!-- 创建一个日期对象存入容器 -->
<bean id="now" class="java.util.Date"/>
```

***



## `set`方法注入

<font color=red>**优势: 创建对现时, 没有明确的限制, 可以直接使用构造函数.**</font>

<font color=green>**弊端: 如果某个成员必须有值, 则获取对象时有可能`set`方法没有执行 .**</font>

使用`<property>`标签

|  属性   |                             取值                             |
| :-----: | :----------------------------------------------------------: |
| `name`  |                    指定bean的**属性名称**                    |
| `value` |                  提供基本类型和String的数据                  |
|  `ref`  | 指定其他的**Bean类型**, 指在`Spring`的`IoC`核心容器中出现过的`Bean`对象 |



```xml
<!-- set方法注入 -->
<bean id="accountService2" class="com.study.spring.service.impl.AccountServiceImpl2">
    <property name="name" value="test"/>
    <property name="age" value="19"/>
    <property name="birthday" ref="now"/>
 </bean>
 
 <!-- 创建一个日期对象存入容器 -->
<bean id="now" class="java.util.Date"/>
```

***



## 复杂类型(集合)的注入

`<property>`中的标签

用于给`List`结构集合注入的标签`<list>`, `<array>`, `<set>`
用于给`Map`结构集合注入的标签`<map>`, `<props>`


```xml
<bean id="accountService3" class="com.study.spring.service.impl.AccountServiceImpl3">
    <!-- array -->
    <property name="myArray">
        <array>
            <value>aaa</value>
            <value>bbb</value>
            <value>ccc</value>
        </array>
    </property>
    <!-- list -->
    <property name="myList">
        <list>
            <value>aaa</value>
            <value>bbb</value>
            <value>ccc</value>
        </list>
    </property>
    <!-- set -->
    <property name="mySet">
        <set>
            <value>aaa</value>
            <value>bbb</value>
            <value>ccc</value>
        </set>
    </property>
    <!-- map -->
    <property name="myMap">
        <map>
            <entry key="testA" value="AAA"/>
            <entry key="testB">
                <value>BBB</value>
            </entry>
        </map>
    </property>
    <!-- property -->
    <property name="myProps">
        <props>
            <prop key="testC">CCC</prop>
            <prop key="testD">DDD</prop>
        </props>
    </property>
</bean>
```