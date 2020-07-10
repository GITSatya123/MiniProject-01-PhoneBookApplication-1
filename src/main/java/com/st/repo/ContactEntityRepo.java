package com.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.entity.ContactEntity;

public interface ContactEntityRepo extends JpaRepository<ContactEntity, Integer> {

}
