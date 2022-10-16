
package com.example.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.LibraryRepositorary;
import com.example.entity.Library;

@Component
public class LibraryBO {

	@Autowired
	LibraryRepositorary lrep = null;

	public Library addLibrary(Library lib) {
		return lrep.save(lib);
	}

	public Library findById(Integer libraryId) {
		Optional<Library> lib = lrep.findById(libraryId);
		return (lib.get());
	}

	public List<Library> fetchAll() {
		return lrep.findAll();
	}
	/*
	 * public List<Library> fetchById(Integer id1) { return
	 * lrep.findLibraryById(id1); }
	 * 
	 * public List<Library> findByName(String name1) { return
	 * lrep.findByName(name1); }
	 * 
	 * public List<Library> findLibraryWithBooks() { return
	 * lrep.findLibraryWithBooks(); }
	 */

}
