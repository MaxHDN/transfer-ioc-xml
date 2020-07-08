package com.duck.dao;

import com.duck.pojo.Account;

/**
 * @author 应癫
 */

public interface AccountDao {

    Account queryAccountByCardNo(String cardNo) throws Exception;

    int updateAccountByCardNo(Account account) throws Exception;
}
