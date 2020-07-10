package com.st.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.dto.Contact;

import com.st.service.ContactEntityService;

@Controller 
public class ViewContactController {

	@Autowired
	private ContactEntityService service;
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("id") Integer id,Model model) {
		
			Contact c=service.getContactById(id);
			model.addAttribute("contact", c);
			return "contactInfo";
	}
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("id") Integer id,Model model) {
		boolean isdeleted=service.deleteContact(id);
		if(isdeleted) {
			
			return "redirect:/all";
		}
		return  null;
	}
}
