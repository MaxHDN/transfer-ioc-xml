import com.duck.pojo.NaiveWaiter;
import com.duck.pojo.Waiter;
import com.duck.proxy.PreGreetingAspect;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApectJProxyTest {

    @Test
    public void testSchemaXml(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Waiter naiveWaiter = (Waiter) applicationContext.getBean("naiveWaiter");
        naiveWaiter.serveTo("Tom");
        naiveWaiter.greetTo("Tom");
    }

    @Test
    public void testAnnotationAwareAspectJAutoProxyCreator(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Waiter aspectNaiveWaiter = (Waiter) applicationContext.getBean("aspectNaiveWaiter");
        aspectNaiveWaiter.serveTo("Tom");
        aspectNaiveWaiter.greetTo("Tom");
    }

    @Test
    public void testAspectJAnnotation(){
        Waiter waiter = new NaiveWaiter();

        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(waiter);  // 设置代理对象
        factory.addAspect(PreGreetingAspect.class); // 添加切面类

        Waiter proxy = factory.getProxy(); // 生成织入切面的代理对象

        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
