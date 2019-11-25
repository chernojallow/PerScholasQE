package com.perscholas.casestudy.rms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.perscholas.casestudy.rms.repositories.ItemRepository;

@Controller
public class ItemController {
	@Autowired
	private ItemRepository iRep;
	
	
}
