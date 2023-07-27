package com.lib.management.system.libmanagementsysproject25thFeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lib.management.system.libmanagementsysproject25thFeb.models.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>{
	
	//two ways of writing cusotm query
	
	//JPQL - JAVA PERSISTENCE query lang 
	// above query will executes considering java class or object
	
	// NATIVE QUERY - fromat executes query conserding you sql tables
	
	
//	//JPQL query
//	@Query(value = "select a from Author a where a.email = ?1 and a.name = ?2 ")
//	Author findAuthor(String emailParam, String name);
//	
	
	//JPQL query -- prefered
	@Query(value = "select a from Author a where a.email = :emailParam ")
	Author findAuthor(String emailParam);
	
//	//Native query 
//	@Query(value = "select * from Author where email = :emailParam and name = ?2", nativeQuery = true)
//	Author findAuthorEmail(String emailParam, String name);
//	
	
	
	

}
