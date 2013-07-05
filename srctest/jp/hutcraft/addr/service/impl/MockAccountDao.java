package jp.hutcraft.addr.service.impl;

import java.util.List;

import com.google.common.collect.Lists;

import jp.hutcraft.addr.dao.AccountDao;
import jp.hutcraft.addr.entity.Account;

public class MockAccountDao implements AccountDao {

	public List<Account> accounts = Lists.newArrayList();
	
	@Override
	public void insert(Account account) {
		accounts.add(account);
	}

	@Override
	public List<Account> findAll() {
		return accounts;
	}

	@Override
	public void delete(Account account) {
	}

}
