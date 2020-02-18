package com.capg.onlinewallet.dao;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.capg.onlinewallet.model.WalletAccount;
import com.capg.onlinewallet.model.WalletTransaction;

public class WalletAccountDaoImpl implements WalletAccountDao {
	
	Map<Long, WalletAccount> walletAccounts=new HashMap<>();
	
	public WalletAccountDaoImpl() {
		addSomeWalletAccount();
	}
	public void addSomeWalletAccount() {
		WalletAccount ac1=new WalletAccount(1001121312L,2000.0F,99586566L,"Rahul",
					Arrays.asList(new WalletTransaction(1012121L,LocalDate.now())));
		WalletAccount ac2=new WalletAccount(10011213021L,1000.0F,99586562L,"Mahesh",
				Arrays.asList(new WalletTransaction(10125323L,LocalDate.now().minusDays(100))));
		
		walletAccounts.put(ac1.getWalletId(), ac1);
		walletAccounts.put(ac2.getWalletId(), ac2);
	}

	@Override
	public boolean addWalletAccount(WalletAccount account) {
		if(walletAccounts.containsKey(account)) {
			return false;
		}
		walletAccounts.put(account.getWalletId(), account);
		return true;
	}

	@Override
	public WalletAccount getWalletAccountById(long id) {
		return walletAccounts.get(id);
	}

	@Override
	public boolean updateWalletAccount(WalletAccount account) {
		if(!walletAccounts.containsKey(account.getWalletId())) {
			return false;
		}
		WalletAccount accountToUpdate=walletAccounts.get(account.getWalletId());
		accountToUpdate.setBalance(account.getBalance());
		////////
		//////
		return true;
	}

	@Override
	public boolean addAmount(long id,float amount) {
		if(!walletAccounts.containsKey(id)) {
			return false;
		}
		WalletAccount acc=walletAccounts.get(id);
		acc.setBalance(acc.getBalance()+amount);
		return true;
		
		
	}

}