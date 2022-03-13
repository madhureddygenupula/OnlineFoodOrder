package com.ty.dto;

import java.util.List;

import javax.persistence.OneToMany;

public class Cart {
	
	@OneToMany
	private List<Item> items;

}
