package com.duck.factory;

import com.duck.dao.AccountDao;
import com.duck.dao.impl.JdbcAccountDaoImpl;
import com.duck.service.TransferService;
import com.duck.service.impl.TransferServiceImpl;

public class BeanFactory {

    public static TransferServiceImpl getTransferService(){
        TransferServiceImpl TransferServiceImpl = new TransferServiceImpl();
        AccountDao accountDao = new JdbcAccountDaoImpl();
        TransferServiceImpl.setAccountDao(accountDao);
        return TransferServiceImpl;
    }


    public  TransferServiceImpl getTransferServiceNonStatic(){
        TransferServiceImpl TransferServiceImpl = new TransferServiceImpl();
        AccountDao accountDao = new JdbcAccountDaoImpl();
        TransferServiceImpl.setAccountDao(accountDao);
        return TransferServiceImpl;
    }
}
