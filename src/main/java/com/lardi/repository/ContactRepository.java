package com.lardi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lardi.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
