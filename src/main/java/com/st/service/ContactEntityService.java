 package com.st.service;

import java.util.List;

import com.st.dto.Contact;


public interface ContactEntityService {

	boolean saveContact(Contact c);
	boolean updateContact(Contact c);
	boolean deleteContact(Integer id);
	List<Contact> getAllContact();
	Contact getContactById(Integer id);
}
