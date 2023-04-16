package com.arun.ace.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	private int id;
	private String username;
	private String message;
	private OfferDto offer;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	 public static class OfferDto {
         private String type;
         private String sdp;
     }
	
	

}
