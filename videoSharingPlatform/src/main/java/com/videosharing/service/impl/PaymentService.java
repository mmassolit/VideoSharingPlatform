package com.videosharing.service.impl;

import platform_service.Account;
import platform_service.Advertiser;
import platform_service.User;
import platform_service.VideoSharingPlatform;

public final class PaymentService {
	private static void validatePayment(Advertiser advertiser, double amount){
		double advertisersBalance = advertiser.getBalance();
		boolean validCondition = amount > 0 && amount < advertisersBalance;
		
        if (!validCondition)
            throw new IllegalArgumentException("Invalid value.");
	}
	
	private static void validateWithdraw(double balance, double amount) {
		if (balance < amount)
			throw new IllegalArgumentException("Invalid value "
					+ "(withdrawal amount has to be smaller than balance.");
	}
	
	public void transferPayment(VideoSharingPlatform platform, User user, Advertiser advertiser, double amount) {
		validatePayment(advertiser, amount);
		
		final double transactionFee = platform.getTransactionFee();
		
		double userAmount = amount * (1-transactionFee);
		double platformAmount = amount * transactionFee;
		
		advertiser.decreaseBalance(amount);
		user.increaseBalance(userAmount);
		platform.increaseBalance(platformAmount);
	}
	
	public void rechargeAdvertiserBalance(Advertiser advertiser, double amount) {
		advertiser.increaseBalance(amount);
	}
	
	public void rechargeUserBalance(User user, double amount) {
		user.increaseBalance(amount);
	}
	
	public void withdrawUserBalance(User user, double amount) {
		validateWithdraw(user.getBalance(), amount);
		user.decreaseBalance(amount);
	}
	
	public void withdrawAdvertiserBalance(Advertiser advertiser, double amount) {
		validateWithdraw(advertiser.getBalance(), amount);
		advertiser.decreaseBalance(amount);
	}
}
