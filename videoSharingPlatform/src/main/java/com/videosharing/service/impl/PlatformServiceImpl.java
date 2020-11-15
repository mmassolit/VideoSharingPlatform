package com.videosharing.service.impl;

import java.util.LinkedList;

public final class PlatformServiceImpl {
	public int userCount(VideoSharingPlatform platform) {
		return platform.getUserList().size();
	}
	
	public int advertisersCount(VideoSharingPlatform platform) {
		return platform.getAdvertiserList().size();
	}
	
	public void addUser(User user, VideoSharingPlatform platform) {
		LinkedList<User> userList = platform.getUserList();
		userList.addLast(user);
		platform.setUserList(userList);
	}
	
	public void deleteUser(User user, VideoSharingPlatform platform) {
		LinkedList<User> userList = platform.getUserList();
		
		if (userList.contains(user)) { 
			userList.remove(user);
			platform.setUserList(userList);
		}
	}
	
	public void addAdvertiser(Advertiser advertiser, VideoSharingPlatform platform) {
		LinkedList<Advertiser> advertiserList = platform.getAdvertiserList();
		advertiserList.addLast(advertiser);
		platform.setAdvertiserList(advertiserList);
	}
	
	public void deleteAdvertiser(Advertiser advertiser, VideoSharingPlatform platform) {
		LinkedList<Advertiser> advertiserList = platform.getAdvertiserList();
		
		if (advertiserList.contains(advertiser)) {
			advertiserList.remove(advertiser);
			platform.setAdvertiserList(advertiserList);
		}
	}
}
