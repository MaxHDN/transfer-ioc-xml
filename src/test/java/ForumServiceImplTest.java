import com.duck.pojo.NaiveWaiter;
import com.duck.pojo.Seller;
import com.duck.pojo.Waiter;
import com.duck.proxy.CglibProxy;
import com.duck.proxy.GreetingAdvisor;
import com.duck.proxy.GreetingBeforeAdvice;
import com.duck.proxy.PerformanceHandler;
import com.duck.service.impl.ForumService;
import com.duck.service.impl.ForumServiceImpl;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class ForumServiceImplTest {

    @Test
    public void testDefaultAdvisorAutoProxyCreator(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Waiter autoWaiter = (Waiter) applicationContext.getBean("waiter");

        autoWaiter.serveTo("John");
        autoWaiter.greetTo("John");

    }

    @Test
    public void testAutoProxy(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Waiter autoWaiter = (Waiter) applicationContext.getBean("autoWaiter");
        Seller autoSeller = (Seller) applicationContext.getBean("autoSeller");

        autoWaiter.serveTo("John");
        autoWaiter.greetTo("John");

        autoSeller.serveTo("Tom");
        autoSeller.greetTo("Tom");

    }

    @Test
    public void testAdvisorByConfigXml(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        System.out.println("-------静态普通方法名匹配切面------");
        Waiter waiterByAdvisor = (Waiter) applicationContext.getBean("waiterByAdvisor");
        waiterByAdvisor.greetTo("lisi");
        waiterByAdvisor.serveTo("lisi");

        Seller seller = (Seller) applicationContext.getBean("seller");
        seller.greetTo("wanger");
        seller.serveTo("wanger");

        System.out.println("-------静态正则表达式方法匹配切面------");

        Waiter waiterByRegexAdvisor = (Waiter) applicationContext.getBean("waiterByRegexAdvisor");
        waiterByRegexAdvisor.greetTo("lisi");
        waiterByRegexAdvisor.serveTo("lisi");

        Seller regexSeller = (Seller) applicationContext.getBean("regexSeller");
        regexSeller.greetTo("wanger");
        regexSeller.serveTo("wanger");

        System.out.println("-------动态切面------");
        Waiter dynamicWaiter = (Waiter) applicationContext.getBean("dynamicWaiter");
        dynamicWaiter.greetTo("John");
        dynamicWaiter.serveTo("John");
        dynamicWaiter.greetTo("Tom");
        dynamicWaiter.serveTo("Tom");

        Seller dynamicSeller = (Seller) applicationContext.getBean("dynamicSeller");
        dynamicSeller.greetTo("wanger");
        dynamicSeller.serveTo("wanger");
    }

    @Test
    public void testAdvisorByCode(){
        // 使用ProxyFactory，编码的方式生成代理对象

        Waiter waiter = new NaiveWaiter();
        // 前置增强
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        // 切面
        GreetingAdvisor advisor = new GreetingAdvisor();
        // 切面设置增强
        advisor.setAdvice(beforeAdvice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAdvisor(advisor);

        Waiter waiterProxy = (Waiter) proxyFactory.getProxy();
        waiterProxy.greetTo("lisi");
        waiterProxy.serveTo("wanger");
    }

    @Test
    public void testMethodBeforeAdvice(){

        // 使用ProxyFactory，编码的方式生成代理对象
        Waiter waiter = new NaiveWaiter();
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAdvice(beforeAdvice);

        Waiter waiterProxy = (Waiter) proxyFactory.getProxy();
        waiterProxy.greetTo("lisi");
        waiterProxy.serveTo("wanger");

        // 采用Spring配置的方式，生成代理对象，注册到IOC容器中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Waiter waiter1 = (Waiter) applicationContext.getBean("waiter");
        waiter1.greetTo("lisi");
        waiter1.serveTo("wanger");

        System.out.println(waiter1.getClass());


    }

    @Test
    public void testCglibProxy(){
        CglibProxy cglibProxy = new CglibProxy();
        ForumServiceImpl proxy = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
        proxy.removeForum(3283);
        proxy.removeTopic(2398);
    }

    @Test
    public void testJdkProxy(){
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
        proxy.removeTopic(3847);
        proxy.removeForum(9384);
    }

    @Test
    public void testForumService(){
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(2341);
        forumService.removeTopic(3456);
    }
}
