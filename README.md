# aop 面向切面编程

## aop配置的重点
       2向容器中注入 ！切面类，！被切类   
       
       <bean id="aopAspect" class="com.atcdu.liujun.aop2.AopAspect"></bean>
       <bean id="aopTarget" class="com.atcdu.liujun.aop2.AopTarget"></bean>
       
### 一：普通面向切面编程
     
     
     
    1.例子
        <aop:aspect ref="aopAspect">
            <aop:pointcut id="myPointCut" expression="execution(* com.atcdu.liujun.aop2.AopTarget.add(..))"/>
            <aop:before method="before" pointcut="execution(* com.atcdu.liujun.aop2.AopTarget.add(..))"></aop:before>
            <aop:after-returning method="afterReturn" pointcut-ref="myPointCut"></aop:after-returning>
        </aop:aspect>
    1.1  一定要配置切面类  <aop:aspect>
    1.2 在切面类里配置，    被切类的切入点   切面的切入方法
### 二：事务面向切面编程
    1.配置事务管理器
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
            <property name="dataSource" ref="DataSource"></property>
        </bean>
    2.配置数据源
        <context:property-placeholder location="DataSource.properties"></context:property-placeholder>
        <bean class="com.mchange.v2.c3p0.ComboPooledDataSource" id="DataSource">
            <property name="user" value="${jdbc.user}"></property>
            <property name="password" value="${jdbc.password}"></property>
            <property name="jdbcUrl" value="${jdbc.jdbcUrl}"></property>
            <property name="driverClass" value="${jdbc.driverClass}"></property>
        </bean>
        
    3.    <!--事务的aop配置-->
        <aop:config>
            <!--切入点表达式-->
            <aop:pointcut id="myPointCut2" expression="execution(* com.atcdu.liujun.aop2.AopTarget.*(..))"/>
            <!--切面-->
            <aop:advisor advice-ref="myTxManager" pointcut-ref="myPointCut"></aop:advisor>
        </aop:config>
    4.   <!--配置事务管理器切面-->
        <tx:advice id="myTxManager" transaction-manager="transactionManager">
            <tx:attributes>
                <!--<aop:pointcut id="myPointCut2" expression="execution(* com.atcdu.liujun.aop2.AopTarget.*(..))"/>
                只是表明了要切入那些方法，没有表明哪些方法要加事务，需要具体指明
                -->
                <tx:method name="jian" propagation="REQUIRED"/>
                <tx:method name="get*" read-only="true"/>
            </tx:att
