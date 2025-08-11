package org.acme.resources;


import java.util.Set;

import org.acme.dto.Product;
import org.acme.response.Result;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path( "/product" )
public class ProductResource {
	

	@Inject
	Validator validator;

	@POST
	public Result addProduct( @Valid Product product ) {
		Set< ConstraintViolation< Product > > violations = validator.validate( product );
			return new Result( "Produto inserido é valido" );
	}

	//{
	//"message": "Pre?o precisa ser maior que zero",
	//"sucess": false
	//}
	// @POST
	// public Result addProduct( Product product ) {
	// 	Set< ConstraintViolation< Product > > violations = validator.validate( product );
	// 	if ( violations.isEmpty() ){
	// 		return new Result( "Produto inserido � valido" );
	// 	} else {
	// 		return new Result( violations );
	// 	}
	// }


	/*{
	"title": "Constraint Violation",
	"status": 400,
	"violations": [
		{
			"field": "addProduct.product.price",
			"message": "Pre?o precisa ser maior que zero"
		}
	]
} */

}
