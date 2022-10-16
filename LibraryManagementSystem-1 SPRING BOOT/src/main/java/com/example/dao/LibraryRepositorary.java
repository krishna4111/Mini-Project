package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Library;
@Repository
public interface LibraryRepositorary extends JpaRepository <Library,Integer> {
	
	/*
	 * @Query(value="select l from Library l where l.id> :id1") List<Library>
	 * findLibraryById(@Param("id1")Integer id);
	 * 
	 * @Query("select l from Library l Where l.name LIKE %:name1%")
	 * List<Library>findByName(@Param("name1")String name);
	 * 
	 * 
	 * //Inner Join
	 * 
	 * @Query("Select l from Library l JOIN Book b on l.id=b.library")
	 * List<Library>findLibraryWithBooks();
	 */
	

}
