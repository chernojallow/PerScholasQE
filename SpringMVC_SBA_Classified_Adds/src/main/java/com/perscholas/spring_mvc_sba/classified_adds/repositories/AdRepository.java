package com.perscholas.spring_mvc_sba.classified_adds.repositories;

import java.util.List;

import com.perscholas.spring_mvc_sba.classified_adds.models.Ad;

public interface AdRepository {
	List<Ad> showAds();

	Integer addAd(Ad ad);

	Boolean removeAd(Integer adId);

	Boolean orderAd(Integer adId);

	Boolean cancelAd(Integer adId);
}
