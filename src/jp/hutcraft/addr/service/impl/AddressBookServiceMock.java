package jp.hutcraft.addr.service.impl;

import java.util.List;

import jp.hutcraft.addr.entity.Account;
import jp.hutcraft.addr.service.AddressBookService;

import com.google.common.collect.Lists;

public class AddressBookServiceMock implements AddressBookService {

	private List<Account> accounts = Lists.newArrayList();
	
	@Override
	public void register(String name, String address) {
		final Account a = new Account();
		a.setName(name);
		a.setAddress(address);
		accounts.add(a);
	}

	@Override
	public List<Account> findAll() {
		return Lists.newArrayList(accounts);
	}

	@Override
	public boolean isValid(String name, String address) {
		return false;
	}

}
