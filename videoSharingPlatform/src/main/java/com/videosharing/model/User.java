package com.videosharing.model;

import java.util.LinkedList;

import video_service.Video;

public final class User extends Account {
	private LinkedList<Video> videoList;
	
	public User(String name) {
		super(name);
		videoList = new LinkedList<Video>();
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public LinkedList<Video> getVideoList() {
		return videoList;
	}

	public void setVideoList(LinkedList<Video> videoList) {
		this.videoList = videoList;
	}
	
	@Override
	public String toString() {
		return "User(name: " + name + "; uid: " + uid + "; balance: " + balance + ")";
	}
}
