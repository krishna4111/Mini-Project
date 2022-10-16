
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.example.bo.LibraryBO;

import com.example.entity.Library;

@Component
public class LibraryService {

	@Autowired
	LibraryBO lbo = null;

	public Library insertLibrary(Library lib) {
		return lbo.addLibrary(lib);
	}

	public Library findLibraryById(Integer libraryId) {
		return lbo.findById(libraryId);
	}

	public List<Library> findAll() {
		return lbo.fetchAll();
	}
	
	
	public Library updateLibrary(Library library) {
	Integer libraryId=	library.getLibraryId();
     Library lib= lbo.findById(libraryId);
     lib.setLibraryName(library.getLibraryName());
     lib.setPlace(library.getPlace());
     lib.setContactNo(library.getContactNo());
    return lbo.addLibrary(lib);
     
		
	}
}
/*
 * public List<Library> fetchId(Integer id1) { return lbo.fetchById(id1); }
 * public List<Library> fetchName(String name1) { return lbo.findByName(name1);
 * } public List<Library>findLibraryWithBooks(){ return
 * lbo.findLibraryWithBooks(); } }
 */
