package com.casestudy.entities;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "places")
@Data
public class Places {
	
	@Id
	private String id;
	

    @NotNull(message = "Please enter longtitude value")
	private Double longtitude;
	
    @NotNull(message = "Please enter latitude value")
	private Double latitude;

   
	private Short radius=500;
    
 
	private String response;
	
	

	

}
