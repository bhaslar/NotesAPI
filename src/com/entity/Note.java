package com.entity;

/**
 * Note.java
 * Model object of a note to be passed back and forth to the user through the api.
 * 
 * @author Ben Haslar
 */
public class Note {
	private long id;		//unique identifier for each note
	private String body;	//user specified text of what the note contains
	
	/**
	 * Gets the id of the note.
	 * @return this note's id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id for this note
	 * @param id id that this note and this note alone
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the body of the note
	 * @return this note's body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * Sets or replaces the body for this note
	 * @param body user specified string for what this note is
	 */
	public void setBody(String body) {
		this.body = body;
	}
}
