package com.casestudy.services;

import org.springframework.stereotype.Service;

import com.casestudy.dto.PlacesDTO;
import com.casestudy.entities.Places;


public interface PlaceService {
	
	Places savePlace(Places place);

	boolean isPlaceExistInDB(Places place);
	
	

}
