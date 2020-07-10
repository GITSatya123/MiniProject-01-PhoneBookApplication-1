package com.st.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.dto.Contact;
import com.st.service.ContactEntityService;

@Controller
public class ContactEntityController {

	
	private static final Logger log = LoggerFactory.getLogger(ContactEntityController.class);

	@Autowired
	private ContactEntityService service;
	
	@GetMapping("/view")
	public String showForm(Model model) {
		Contact c=new Contact();
		model.addAttribute("contact", c);
		return "contactInfo";
	}
	
	@PostMapping("/save")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, RedirectAttributes attribute) {
		log.info("Contact Data Saved"+c);
	 	boolean isSave=service.saveContact(c);
		if(isSave) {
			//model.addAttribute("succMsg", "contact Saved");
			attribute.addFlashAttribute("succMsg", "contact Saved");
		}else {
			attribute.addFlashAttribute("errMsg", "Failed to save contact");
		}		
		
		return "redirect:/contactSuccess";
	}
	
	@GetMapping("/all")
	public String getAllContact(Model model) {
		List<Contact> contactList=service.getAllContact();
		model.addAttribute("contact",contactList);
		return "contactView";
	} 
	
	@GetMapping("/contactSuccess")
	public String contactCreationSuccess(Model model,Contact c ) {
		log.info("ContactCreationSuccessMethod called()");
		model.addAttribute("contact", c);
		model.addAttribute("succMsg", "contact Saved");
	return "contactInfo";
	}
}
