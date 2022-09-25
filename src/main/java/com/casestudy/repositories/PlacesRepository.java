package com.casestudy.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;	
import org.springframework.stereotype.Repository;

import com.casestudy.entities.Places;

@Repository
public interface PlacesRepository extends MongoRepository<Places,String>{
	
	
     boolean existsByLongtitudeAndLatitudeAndRadius(Double longtitude,Double latitude, Short radius);
     
     Places findByLatitudeAndLongtitudeAndRadius(Double latitude,Double longtitude, Short radius);
}
