package com.casestudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.dto.PlacesDTO;
import com.casestudy.entities.Places;
import com.casestudy.repositories.PlacesRepository;


@Service
public class PlaceServiceImpl implements PlaceService
{
	
	@Autowired
	PlacesRepository placesRepo;

	@Override
	public void savePlace(Places place) {
		
	placesRepo.save(place);
	}

	@Override
	public boolean isPlaceExistInDB(Places place) {
	
		return placesRepo.existsByLongtitudeAndLatitudeAndRadius(place.getLongtitude(),place.getLatitude(),place.getRadius());
	}

	@Override
	public Places findByLatitudeAndLongtitudeAndRadius(Double latitude, Double longtitude, Short radius) {
		
		return placesRepo.findByLatitudeAndLongtitudeAndRadius(latitude, longtitude, radius);
		
	}
	


}
