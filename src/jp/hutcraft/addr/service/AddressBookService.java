package jp.hutcraft.addr.service;

import java.util.List;

import jp.hutcraft.addr.entity.Account;

public interface AddressBookService {

	/**
	 * アドレスの登録。エラーの場合はIllegalArgumentExceptionを発生
	 * @param name
	 * @param address
	 */
	void register(String name, String address);
	
	boolean isValid(String name, String address);
	
	/**
	 * 全件取得。返り値は名前の昇順でソートされています。
	 * @return
	 */
	List<Account> findAll();
}
