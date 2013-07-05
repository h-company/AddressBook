package jp.hutcraft.addr.service.impl;

import java.util.Date;
import java.util.List;

import jp.hutcraft.addr.dao.AccountDao;
import jp.hutcraft.addr.entity.Account;
import jp.hutcraft.addr.service.AddressBookService;

import org.seasar.framework.util.StringUtil;
import org.seasar.framework.util.UUID;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;

public class AddressBookServiceImpl implements AddressBookService {

	private AccountDao accountDao;
	
	@Override
	public void register(final String name, final String address) {
		if (!isValid(name, address)) throw new IllegalArgumentException();
		final Account a = new Account();
		a.setId(UUID.create());
		a.setName(name);
		a.setAddress(address);
		a.setMakeDate(new Date());
		accountDao.insert(a);
	}
	
	@Override
	public boolean isValid(final String name, final String address) {
		return isValid(name) && isValid(address);
	}
	
	private boolean isValid(final String v) {
		return StringUtil.isNotEmpty(v) && StringUtil.isNotEmpty(v.trim()); 
	}

	@Override
	public List<Account> findAll() {
		return ImmutableSortedSet.orderedBy(
				Ordering.natural().onResultOf(new Function<Account, String>() {
					@Override public String apply(Account from) {
						return from.getName();
					}
			}))
			.addAll(accountDao.findAll()).build().asList();
	}
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
