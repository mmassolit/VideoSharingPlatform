package com.videosharing.model;

import 
import java.util.UUID;

public final class Ad {
	private final String name;
	private double cpm;
	private double budget;
	private final String uid;
	private final String ownerId;
	
	public Ad(String name, double cpm, double budget, String ownerId) {
		validateCpm(cpm);
		validateBudget(budget, cpm);
		
		this.name = name;
		this.cpm = cpm;
		this.budget = budget;
		this.uid = UUID.randomUUID().toString();
		this.ownerId = ownerId;
	}
	
	 private static void validateCpm(double cpm){
	        if (cpm < 0)
	            throw new IllegalArgumentException("Invalid value (it has to be positive).");
	 }
	
	 private static void validateBudget(double budget, double cpm){
	        if (budget < 0)
	            throw new IllegalArgumentException("Invalid value (it has to be positive).");
	        
	        else if (budget < cpm)
	        	throw new IllegalArgumentException("Invalid value (budget has to be bigger, than CPM).");
	 }
	
	public double getCpm() {
		return this.cpm;
	}
	
	public String getOwnerId() {
		return ownerId;
	}
	
	public String show() {
		return this.uid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCpm(double newCpm) {
		validateCpm(newCpm);
		this.cpm = newCpm;
	}
	
	public double getBudget() {
		return this.budget;
	}
	
	public void setBudget(double newBudget) {
		validateBudget(newBudget, this.cpm);
		this.budget = newBudget;
	}
	
	@Override
	public String toString() {
		return "Ad(name: " + name + "; uid" + uid + "; cpm: " + cpm + "; budget: " + budget + ")";
	}
}
