
package com.example.dto;

import java.util.Date;

public class LibraryDTO {
	private Integer libraryId;
	private String libraryName;
	private String place;
	private Long contactNO;
	private Date CreatedAt;
	private Date UpdatedAt;

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public Date getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Long getContactNO() {
		return contactNO;
	}

	public void setContactNO(Long contactNO) {
		this.contactNO = contactNO;
	}

}
