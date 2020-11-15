package com.videosharing.model;

import java.util.UUID;

public final class Video {
	private final String name;
	private int views;
	private final String uid;
	private final String ownerId;
	
	public Video(String name, String ownerId) {
		this.name = name;
		this.ownerId = ownerId;
		this.uid = UUID.randomUUID().toString();
		this.views = 0;
	}
	
	public int getViews() {
		return views;
	}
	
	public String getOwnerId() {
		return ownerId;
	}
	
	public String show() {
		return uid;
	}
	
	public String getName() {
		return name;
	}
	
	public void addViews(int amount) {
		views += amount;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Video(name: " + name + "; uid: " + uid + "; views: " + views + ")";
	}
}
