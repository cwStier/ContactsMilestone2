package cst135n.w4.milestone4;

import java.io.Serializable;

public class Photo implements Serializable {
	
	private int photoId;
	private String fileName;
	private String dateOfPhoto;
	private String description;
	
	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", fileName=" + fileName + ", dateOfPhoto=" + dateOfPhoto
				+ ", description=" + description + "]";
	}
	
	public Photo(int photoId, String fileName, String dateOfPhoto, String description) {
		super();
		this.photoId = photoId;
		this.fileName = fileName;
		this.dateOfPhoto = dateOfPhoto;
		this.description = description;
	}

	public int getPhotoId() {
		return photoId;
	}
	
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getDateOfPhoto() {
		return dateOfPhoto;
	}
	
	public void setDateOfPhoto(String dateOfPhoto) {
		this.dateOfPhoto = dateOfPhoto;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
