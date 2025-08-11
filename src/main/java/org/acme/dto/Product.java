package org.acme.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product {

	public Long id;

	@NotBlank( message="Campo rótulo não pode estar vázio" )
	public String label;

	@NotBlank( message="campo description não pode estar vázio" )
	public String description;

	@Min( message="Quantidade precisa ser maior que zero", value=1 )
	@Max( message="Quantidade não pode ser maior que 5", value = 5 )
	public Integer quantity;

	@Min( message="Preço precisa ser maior que zero", value=1 )
	public double price;

	// @CPF( message="CPF informado é inválido" )
	// public String cpf;

}