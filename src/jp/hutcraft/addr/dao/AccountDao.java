package jp.hutcraft.addr.dao;

import java.util.List;

import jp.hutcraft.addr.entity.Account;

import org.seasar.dao.annotation.tiger.S2Dao;
import org.seasar.dao.annotation.tiger.Sql;

@S2Dao(bean=Account.class)
public interface AccountDao {
	
	void insert(Account account);
	
	@Sql("SELECT * FROM account")
	List<Account> findAll();
	
	void delete(Account account);
}
