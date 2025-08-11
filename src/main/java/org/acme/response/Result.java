package org.acme.response;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

	private String message;

	private boolean sucess;

	public Result( String message ){
		this.sucess = true;
		this.message = message;
	}

	public Result( Set< ? extends ConstraintViolation< ? > > violations ){
		this.sucess = false;
		this.message = violations.stream().map( cv ->  cv.getMessage() )
				.collect( Collectors.joining( "," ) );
	}
}
