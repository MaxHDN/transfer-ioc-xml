import com.duck.dao.AccountDao;
import com.duck.pojo.Account;
import com.duck.pojo.Boss;
import com.duck.pojo.Car;
import com.duck.pojo.House;
import com.duck.service.impl.TransferServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicatContextStartWayTest {

    @Test
    public void iocTest() throws Exception {

        // 通过读取classpath路径下配置文件，来启动容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        // 通过读取本地磁盘配置文件，来启动容器。不推荐
        //  ApplicationContext applicationContext = new FileSystemXmlApplicationContext("文件系统的绝对路径");

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = accountDao.queryAccountByCardNo("6029621011000");
        System.out.println(account);

        TransferServiceImpl staticWayInstanceBean = (TransferServiceImpl) applicationContext.getBean("staticWayInstanceBean");
        System.out.println(staticWayInstanceBean);

        TransferServiceImpl nonStaticWayInstanceBean = (TransferServiceImpl) applicationContext.getBean("nonStaticWayInstanceBean");
        System.out.println(nonStaticWayInstanceBean);

    }

    @Test
    public void diWayTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Car car = (Car) applicationContext.getBean("attributeWayCar");
        System.out.println(car);

        car = (Car) applicationContext.getBean("constructorTypeWayCar");
        System.out.println(car);

        car = (Car) applicationContext.getBean("constructorIndexWayCar");
        System.out.println(car);

        car = (Car) applicationContext.getBean("constructorTypeAndIndexWayCar");
        System.out.println(car);

        House house1 = (House) applicationContext.getBean("house1");
        House house2 = (House) applicationContext.getBean("house2");
        System.out.println("house1: " + house1) ;
        System.out.println("house2: " + house2) ;

        Boss boss = (Boss) applicationContext.getBean("myboss");
        System.out.println(boss);

        Boss boss1 = (Boss) applicationContext.getBean("myboss1");
        System.out.println(boss1);

        Boss boss2 = (Boss) applicationContext.getBean("myboss2");
        System.out.println(boss2);

        Boss boss3 = (Boss) applicationContext.getBean("myboss3");
        System.out.println(boss3);

        Boss boss4 = (Boss) applicationContext.getBean("myboss4");
        System.out.println(boss4);

    }
}
