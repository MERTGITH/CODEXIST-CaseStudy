package com.casestudy.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "places")
@Data
public class Places {
	
	@Id
	private String id;
	
	private Double longtitude;
	
	private Double latitude;
	
	private Short radius;
	
	

	

}
