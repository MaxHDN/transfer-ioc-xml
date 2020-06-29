import com.duck.dao.AccountDao;
import com.duck.pojo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicatContextStartWayTest {

    @Test
    public void iocTest() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = accountDao.queryAccountByCardNo("6029621011000");
        System.out.println(account);

    }
}
