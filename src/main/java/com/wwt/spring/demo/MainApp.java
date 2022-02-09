package com.wwt.spring.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.wwt.spring.demo.controller.UserController;

// 教程参考
// http://c.biancheng.net/spring/bean-post-processor.html
public class MainApp {
    private static final Log LOGGER = LogFactory.getLog(MainApp.class);

    public static void main(String[] args) {
        //示范 001 传统的Java程序 主函数直接通过类创建对象
        //StandardJava_HelloWorld_Demo();

        //示范 002 BeanFactory Java程序实现
        //Bean_BeanFactory_HelloWorld_Demo();

        //示范 003 ApplicationContext Java程序实现
        //ClassPathXmlApplicationContext与FileSystemXmlApplicationContext使用
        //Bean_ApplicationContext_HelloWorld_Demo();

        //示范 004 ApplicationContext Java程序实现
        //Bean_ApplicationContext_Student_Demo();

        //示范 005 ApplicationContext 短命名空间
        //Bean_ApplicationContext_Employee_Demo();

        //示范 006 ApplicationContext 内部bean
        //Bean_InsideBean_ApplicationContext_Employee_Demo();

        //示范 007 ApplicationContext 在集合中设置普通类型的值
        //Bean_JavaCollection_Demo();

        //示范 008 ApplicationContext 在集合中设置普通类型的值和引用类型的值
        //Bean_JavaCollectionAddRef_Demo();

        //示范 009 Spring 注入其他类型的属性
        //Bean_Example();

        //示范 010 Spring Bean作用域
        /*
        Spring 5 共提供了 6 种 scope 作用域，如下表。
        作用范围	描述
        singleton	默认值，单例模式，表示在 Spring 容器中只有一个 Bean 实例
        prototype	原型模式，表示每次通过 Spring 容器获取 Bean 时，容器都会创建一个新的 Bean 实例。
        request	每次 HTTP 请求，容器都会创建一个 Bean 实例。该作用域只在当前 HTTP Request 内有效。
        session	同一个 HTTP Session 共享一个 Bean 实例，不同的 Session 使用不同的 Bean 实例。该作用域仅在当前 HTTP Session 内有效。
        application	同一个 Web 应用共享一个 Bean 实例，该作用域在当前 ServletContext 内有效。

        与 singleton 类似，但 singleton 表示每个 IoC 容器中仅有一个 Bean 实例，而一个 Web 应用中可能会存在多个 IoC 容器，但一个 Web 应用只会有一个 ServletContext，也可以说 application 才是 Web 应用中货真价实的单例模式。
        websocket	websocket 的作用域是 WebSocket ，即在整个 WebSocket 中有效。
        */
        //Bean_SingletonAndPrototype_Demo();

        /*
        在传统的 Java 应用中，Bean 的生命周期很简单，使用 Java 关键字 new 进行 Bean 的实例化后，这个 Bean 就可以使用了。一旦这个 Bean 长期不被使用，Java 自动进行垃圾回收。
        相比之下，Spring 中 Bean 的生命周期较复杂，大致可以分为以下 5 个阶段：

        Bean 的实例化
        Bean 属性赋值
        Bean 的初始化
        Bean 的使用
        Bean 的销毁

        Spring 根据 Bean 的作用域来选择 Bean 的管理方式，
        对于 singleton 作用域的 Bean 来说，Spring IoC 容器能够精确地控制 Bean 何时被创建、何时初始化完成以及何时被销毁；
        对于 prototype 作用域的 Bean 来说，Spring IoC 容器只负责创建，然后就将 Bean 的实例交给客户端代码管理，Spring IoC 容器将不再跟踪其生命周期。
         */
        //示范 011 Bean 的生命周期:通过接口实现 Bean 的生命周期回调方法。
        //Bean_LifeCycle_Demo();

        //示范 012 Bean 的生命周期:通过 XML 配置实现 Bean 的生命周期回调方法。
        //Bean_XMLLifeCycle_Demo();

        //示范 013 Bean 的生命周期:通过 JSR-250 的 @PostConstruct 和 @PreDestroy 注解，指定 Bean 的生命周期回调方法。
        //Bean_AnnotationLifeCycle_Demo();

        //示范 014 Spring后置处理器（BeanPostProcessor）
        //Bean_PostProcessor_Demo();

        //示范 015 Spring Bean继承
        //Bean_Animal_Dog_Demo();

        //示范 015 Spring 自动装配
        //Bean_Autowire();

        //示范 016 Spring 自动装配（基于注解）
        Bean_ComponentScan();
    }

    /*
        传统的Java程序 主函数直接通过类创建对象
     */
    private static void StandardJava_HelloWorld_Demo() {
        //传统的Java程序
        //主函数直接通过类创建对象
        HelloWorld javaHelloWord = new HelloWorld();
        javaHelloWord.setMessage("Java Standard HelloWorld Demo:Hello World!");
        javaHelloWord.getMessage();
        LOGGER.info(javaHelloWord.toString());
    }

    /*
        BeanFactory 是 IoC 容器的基本实现，也是 Spring 提供的最简单的 IoC 容器，它提供了 IoC 容器最基本的功能，由 org.springframework.beans.factory.BeanFactory 接口定义。
        注意：BeanFactory 是 Spring 内部使用接口，通常情况下不提供给开发人员使用。
     */
    private static void Bean_BeanFactory_HelloWorld_Demo() {
        //ClassPathXmlApplicationContext
        //加载类路径 ClassPath 下指定的 XML 配置文件，并完成 ApplicationContext 的实例化工作
        BeanFactory beanClassFactory = new ClassPathXmlApplicationContext("Bean_HelloWorld.xml");
        Object beanClassFactoryObj = beanClassFactory.getBean("helloWorld", HelloWorld.class);
        HelloWorld beanClassFactoryHelloWorld = (HelloWorld) beanClassFactoryObj;
        beanClassFactoryHelloWorld.getMessage();
        LOGGER.info(beanClassFactoryHelloWorld.toString());

        //FileSystemXmlApplicationContext
        //加载指定的文件系统路径中指定的 XML 配置文件，并完成 ApplicationContext 的实例化工作
        BeanFactory beanFileFactory = new FileSystemXmlApplicationContext("E:\\ideaProjects\\SpringDemo\\src\\main\\resources\\Bean_HelloWorld.xml");
        Object beanFileFactoryObj = beanFileFactory.getBean("helloWorld", HelloWorld.class);
        HelloWorld beanFileFactoryHelloWorld = (HelloWorld) beanFileFactoryObj;
        beanFileFactoryHelloWorld.getMessage();
        LOGGER.info(beanFileFactoryHelloWorld.toString());
    }

    /*
        ApplicationContext 示范 1
        ApplicationContext 是 BeanFactory 接口的子接口，是对 BeanFactory 的扩展。ApplicationContext 在 BeanFactory 的基础上增加了许多企业级的功能，例如 AOP（面向切面编程）、国际化、事务支持等。
     */
    private static void Bean_ApplicationContext_HelloWorld_Demo() {
        //spring bean方式的Java程序
        //Spring 启动时，IoC 容器会自动根据对象定义，将这些对象创建并管理起来。这些被 IoC 容器创建并管理的对象被称为 Spring Bean。
        //IoC 底层通过工厂模式、Java 的反射机制、XML 解析等技术，将代码的耦合度降低到最低限度，其主要步骤如下。
        //在配置文件（例如 Bean.xml）中，对各个对象以及它们之间的依赖关系进行配置；
        //我们可以把 IoC 容器当做一个工厂，这个工厂的产品就是 Spring Bean；
        //容器启动时会加载并解析这些配置文件，得到对象的基本信息以及它们之间的依赖关系；
        //IoC 利用 Java 的反射机制，根据类名生成相应的对象（即 Spring Bean），并根据依赖关系将这个对象注入到依赖它的对象中。

        //ClassPathXmlApplicationContext 类，加载类路径 ClassPath 下指定的 XML 配置文件，并完成 ApplicationContext 的实例化工作：创建和初始化所有对象（Bean）。
        ApplicationContext classContext = new ClassPathXmlApplicationContext("Bean_HelloWorld.xml");
        //ApplicationContext.getBean() 方法用来获取 Bean，该方法返回值类型为 Object，
        Object classContextObj = classContext.getBean("helloWorld", HelloWorld.class);
        // 通过强制类型转换为 HelloWorld 的实例对象
        HelloWorld classContextHelloWorld = (HelloWorld) classContextObj;
        // 调用其中的 getMessage() 方法。
        classContextHelloWorld.getMessage();
        LOGGER.info(classContextHelloWorld.toString());

        //FileSystemXmlApplicationContext 类，加载指定的文件系统路径中指定的 XML 配置文件，并完成 ApplicationContext 的实例化工作：创建和初始化所有对象（Bean）。
        ApplicationContext fileContext = new FileSystemXmlApplicationContext("E:\\ideaProjects\\SpringDemo\\src\\main\\resources\\Bean_HelloWorld.xml");
        //ApplicationContext.getBean() 方法用来获取 Bean，该方法返回值类型为 Object，
        Object fileContextObj = classContext.getBean("helloWorld", HelloWorld.class);
        // 通过强制类型转换为 HelloWorld 的实例对象
        HelloWorld fileContextHelloWorld = (HelloWorld) fileContextObj;
        // 调用其中的 getMessage() 方法。
        fileContextHelloWorld.getMessage();
        LOGGER.info(fileContextHelloWorld.toString());
    }

    /*
        ApplicationContext 示范 2
     */
    private static void Bean_ApplicationContext_Student_Demo() {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_Student.xml");
        //获取名为 student 的 Bean
        Student student = context.getBean("student", Student.class);
        //通过日志打印学生信息
        LOGGER.info(student.toString());
    }

    /*
        ApplicationContext 示范 3 短命名空间
    */
    private static void Bean_ApplicationContext_Employee_Demo() {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_Employee.xml");
        //获取名为 employee 的 Bean
        Employee employee = context.getBean("employee", Employee.class);
        //通过日志打印信息
        LOGGER.info(employee.toString());
    }

    /*
        ApplicationContext 示范 4 短命名空间
    */
    private static void Bean_InsideBean_ApplicationContext_Employee_Demo() {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_InsideBeans_Employee.xml");
        //获取名为 employee 的 Bean
        Employee employee = context.getBean("insidPropertyEnmloyee", Employee.class);
        //通过日志打印信息
        LOGGER.info(employee.toString());
    }

    /*
        ApplicationContext 示范 5 集合类型的Bean
     */
    private static void Bean_JavaCollection_Demo() {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_JavaCollection.xml");
        //获取名为 employee 的 Bean
        JavaCollection javaCollection = context.getBean("javaCollection", JavaCollection.class);
        //通过日志打印员工信息
        LOGGER.info(javaCollection.toString());
    }

    /*
        ApplicationContext 示范 6 集合类型的Bean包含引用方式
    */
    private static void Bean_JavaCollectionAddRef_Demo() {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_JavaCollectionAddRef.xml");
        //获取名为 employee 的 Bean
        JavaCollectionAddRef javaCollectionAddRef = context.getBean("javaCollectionAddRef", JavaCollectionAddRef.class);
        //通过日志打印员工信息
        LOGGER.info(javaCollectionAddRef.toString());
    }

    /*
        ApplicationContext 示范 6 集合类型的Bean包含引用方式 级联属性赋值
    */
    private static void Bean_Example() {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_Example.xml");
        //获取名为 exampleBean 的 Bean
        ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);
        //通过日志打印信息
        LOGGER.info(exampleBean.toString());
    }

    private static void Bean_SingletonAndPrototype_Demo() {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_SingletonAndPrototype.xml");
        SingletonAndPrototypeBean singletonBean1 = context.getBean("singletonBean", SingletonAndPrototypeBean.class);
        SingletonAndPrototypeBean singletonBean2 = context.getBean("singletonBean", SingletonAndPrototypeBean.class);
        System.out.println(singletonBean1);
        System.out.println(singletonBean2);
        SingletonAndPrototypeBean prototypeBean1 = context.getBean("prototypeBean", SingletonAndPrototypeBean.class);
        SingletonAndPrototypeBean prototypeBean2 = context.getBean("prototypeBean", SingletonAndPrototypeBean.class);
        System.out.println(prototypeBean1);
        System.out.println(prototypeBean2);
    }

    private static void Bean_LifeCycle_Demo() {
        //获取 ClassPathXmlApplicationContext 容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_LifeCycle.xml");
        LifeCycleBean lifeCycleBean = context.getBean("lifeCycleBean", LifeCycleBean.class);
        LOGGER.info(lifeCycleBean);
        //手动销毁 Bean
        context.close();
    }

    private static void Bean_XMLLifeCycle_Demo() {
        //获取 ClassPathXmlApplicationContext 容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_XMLLifeCycle.xml");
        XMLLifeCycleBean xmlLifeCycleBean = context.getBean("xmlLifeCycleBean", XMLLifeCycleBean.class);
        LOGGER.info(xmlLifeCycleBean);
        //手动销毁 Bean
        context.close();
    }

    /*
        使用注解实现
        我们还可以通过 JSR-250 的 @PostConstruct 和 @PreDestroy 注解，指定 Bean 的生命周期回调方法。
     */
    private static void Bean_AnnotationLifeCycle_Demo() {
        //获取 ClassPathXmlApplicationContext 容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean_AnnotationLifeCycle.xml");
        AnnotationLifeCycleBean annotationLifeCycleBean = context.getBean("annotationLifeCycleBean", AnnotationLifeCycleBean.class);
        LOGGER.info(annotationLifeCycleBean);
        //手动销毁 Bean
        context.close();
    }

    /*
        postProcessBeforeInitialization 方法是在 Bean 实例化和属性注入后，自定义初始化方法前执行的。
        postProcessAfterInitialization 方法是在自定义初始化方法后执行的。
        由于 getOrder 方法返回值越大，优先级越低，因此 InitHelloWorld2 先执行。
     */
    private static void Bean_PostProcessor_Demo() {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Bean_PostProcessor.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();
        context.registerShutdownHook();
    }

    /*
        Spring Bean继承(对应于类之间的继承关系）
        在 Spring 中，Bean 和 Bean 之间也存在继承关系。我们将被继承的 Bean 称为父 Bean，将继承父 Bean 配置信息的 Bean 称为子 Bean。
        Spring Bean 的定义中可以包含很多配置信息，例如构造方法参数、属性值。子 Bean 既可以继承父 Bean 的配置数据，也可以根据需要重写或添加属于自己的配置信息。
        在 Spring XML 配置中，我们通过子 Bean 的 parent 属性来指定需要继承的父 Bean
     */
    private static void Bean_Animal_Dog_Demo() {
        //获取 ClassPathXmlApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_Animal_Dog.xml");
        Animal_Dog dog = context.getBean("dog", Animal_Dog.class);
        System.out.println(dog);
    }

    /*
        Spring 自动装配（Spring 在 Bean 与 Bean 之间建立依赖关系的行为称为“装配”。）
        Spring 的自动装配功能可以让 Spring 容器依据某种规则（自动装配的规则，有五种），为指定的 Bean 从应用的上下文（AppplicationContext 容器）中查找它所依赖的 Bean，并自动建立 Bean 之间的依赖关系。而这一过程是在完全不使用任何 <constructor-arg>和 <property> 元素 ref 属性的情况下进行的。
        Spring 的自动装配功能能够有效地简化 Spring 应用的 XML 配置，因此在配置数量相当多时采用自动装配降低工作量。
        Spring 框架式默认不支持自动装配的，要想使用自动装配，则需要对 Spring XML 配置文件中 <bean> 元素的 autowire 属性进行设置。

        自动装配规则
        Spring 共提供了 5 中自动装配规则，它们分别与 autowire 属性的 5 个取值对应，具体说明如下表。
        属性值	说明
        byName	按名称自动装配。
        Spring 会根据的 Java 类中对象属性的名称，在整个应用的上下文 ApplicationContext（IoC 容器）中查找。若某个 Bean 的 id 或 name 属性值与这个对象属性的名称相同，则获取这个 Bean，并与当前的 Java 类 Bean 建立关联关系。
        byType	按类型自动装配。
        Spring 会根据 Java 类中的对象属性的类型，在整个应用的上下文 ApplicationContext（IoC 容器）中查找。若某个 Bean 的 class 属性值与这个对象属性的类型相匹配，则获取这个 Bean，并与当前的 Java 类的 Bean 建立关联关系。
        constructor	与 byType 模式相似，不同之处在与它应用于构造器参数（依赖项），如果在容器中没有找到与构造器参数类型一致的 Bean，那么将抛出异常。

        其实就是根据构造器参数的数据类型，进行 byType 模式的自动装配。
        default	表示默认采用上一级元素 <beans> 设置的自动装配规则（default-autowire）进行装配。
        no	默认值，表示不使用自动装配，Bean 的依赖关系必须通过 <constructor-arg>和 <property> 元素的 ref 属性来定义。
     */
    private static void Bean_Autowire() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_Autowire.xml");

        Employee employee1 = context.getBean("employeeAutowireNo", Employee.class);
        System.out.println("EmployeeAutowireNo:" + employee1);

        Employee employee2 = context.getBean("employeeAutowireByName", Employee.class);
        System.out.println("EmployeeAutowireByName:" + employee2);

        Employee employee3 = context.getBean("employeeAutowireByType", Employee.class);
        System.out.println("EmployeeAutowireByType:" + employee3);

        Employee employee4 = context.getBean("employeeAutowireConstructor", Employee.class);
        System.out.println("EmployeeAutowireConstructor:" + employee4);
    }

    /*
    使用注解定义 Bean
    Spring 提供了以下多个注解，这些注解可以直接标注在 Java 类上，将它们定义成 Spring Bean。

    注解	说明
    @Component	该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。

    使用时只需将该注解标注在相应类上即可。
    @Repository	该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
    @Service	该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。
    @Controller	该注解通常作用在控制层（如 Struts2 的 Action、SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。

    基于注解方式实现依赖注入
    我们可以通过以下注解将定义好 Bean 装配到其它的 Bean 中。

    注解	说明
    @Autowired	可以应用到 Bean 的属性变量、setter 方法、非 setter 方法及构造函数等，默认按照 Bean 的类型进行装配。

    @Autowired 注解默认按照 Bean 的类型进行装配，默认情况下它要求依赖对象必须存在，如果允许 null 值，可以设置它的 required 属性为 false。如果我们想使用按照名称（byName）来装配，可以结合 @Qualifier 注解一起使用

    @Resource	作用与 Autowired 相同，区别在于 @Autowired 默认按照 Bean 类型装配，而 @Resource 默认按照 Bean 的名称进行装配。

    @Resource 中有两个重要属性：name 和 type。
    Spring 将 name 属性解析为 Bean 的实例名称，type 属性解析为 Bean 的实例类型。
    如果指定 name 属性，则按实例名称进行装配；
    如果指定 type 属性，则按 Bean 类型进行装配；
    如果都不指定，则先按 Bean 实例名称装配，如果不能匹配，则再按照 Bean 类型进行装配；如果都无法匹配，则抛出 NoSuchBeanDefinitionException 异常。
    @Qualifier	与 @Autowired 注解配合使用，会将默认的按 Bean 类型装配修改为按 Bean 的实例名称装配，Bean 的实例名称由 @Qualifier 注解的参数指定。
     */
    //这里用到了dao、service、controller的三层架构
    //对于一个将数据库内数据展示在网站的项目来说
    //Model:就是底层的数据库，它就是一个一个的数据集合
    //Util:工具类，完成与业务无关的功能，通常就是一个明确的输入和一个明确的输出结果，比如实现加密的功能给一个明文返回一个密文
    //dao:里面就是实现对数据的内容的CRUD操作（创建，读取，更新，删除）
    //service:通过调用dao层的方法实现对数据库内数据的调用，并对获取到的数据进行一系列的运算等操作，最终的到希望的结果
    //Controller:控制中心，所有的指令调度都从这里发出
    //WebUI:前端显示，展示出来的最终结果
    //大体上可以理解为：客户需要在WebUI上面看到自己想要的结果，通过WebUI提交请求，给service
    //Controller负责调度
    //service通过dao获取Model中的原始数据，然后调用各种Util等对数据进行处理，处理完返回给WebUI
    //通常情况下Service可以调用其它Service跟多个dao，但是实际上比较理想的方式是一个service对应一个dao
    private static void Bean_ComponentScan() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean_ComponentScan.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.doStr();
    }
}
