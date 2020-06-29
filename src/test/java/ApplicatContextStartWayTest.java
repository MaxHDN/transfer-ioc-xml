import com.duck.dao.AccountDao;
import com.duck.pojo.Account;
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

    }
}
