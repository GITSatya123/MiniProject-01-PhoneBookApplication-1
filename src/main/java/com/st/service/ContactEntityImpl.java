package com.st.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.dto.Contact;
import com.st.entity.ContactEntity;
import com.st.repo.ContactEntityRepo;



@Service
public class ContactEntityImpl implements ContactEntityService {

	@Autowired 
	private ContactEntityRepo repo;
	
	
	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity=new ContactEntity();
		//if(c.getContactId()!=null) {
			//Optional<ContactEntity>findById=repo.findById(c.getContactId());
			//entity=findById.get();
	//	}
		BeanUtils.copyProperties(c, entity);
		ContactEntity saveEntity=repo.save(entity);
		return saveEntity.getContactId()!=null;
	}
	
	@Override
	public List<Contact> getAllContact() {
		List<ContactEntity> entities=repo.findAll();
		/* List<Contact> contacts= new ArrayList<>(); */
		//legacy approch
		/*for(ContactEntity entity:entities) {
			Contact contact= new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}*/
		//java 8 approch
		List<Contact> contacts=entities.stream().map(entity->{
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		
		return contacts;
	}
	
	@Override
	public Contact getContactById(Integer id) {
		ContactEntity entity= null;
		Optional<ContactEntity> findById = repo.findById(id);
		if(findById.isPresent()) {
			entity=findById.get();
			Contact c= new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}


	@Override
	public boolean updateContact(Contact c) {
		
		return false;
	}

	@Override
	public boolean deleteContact(Integer id) {
		repo.deleteById(id);
		return true;
	}

	
	

}
