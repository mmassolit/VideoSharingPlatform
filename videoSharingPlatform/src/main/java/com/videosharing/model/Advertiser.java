package com.videosharing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.LinkedList;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import ads_service.Ad;


@EnableAutoConfiguration
@Entity
@Table(name = 'advertisers')


@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Advertiser {
	@Id
	private String idAdvertiser;
	private ZonedDateTime dateCreated;
	final String name;
	double balance;
	
	private LinkedList<Ad> adList;
	
	public Advertiser(String name) {
		super(name);
		this.adList = new LinkedList<Ad>();
	}
	
	public LinkedList<Ad> getAdsList() {
		return this.adList;
	}
	
	public void setAdsList(LinkedList<Ad> adsList) {
		this.adList = adsList;
	}
	
	
	@Override
	public String toString() {
		return "Advertiser(name:" + name + "; balance: " + balance + "; ads: " + adList + ")";
	}
	
}
