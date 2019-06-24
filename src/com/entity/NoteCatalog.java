package com.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * NoteCatalog.java
 * A holder for all notes stored in the system. This class follows the singleton pattern as
 * we do not want multiple holders for various notes.
 * Notes are stored in a hash map that will disappear if the app is shut down.
 * @author Ben Haslar
 *
 */
public class NoteCatalog {
	private static NoteCatalog singleInstance = null;	//singleton instance of this object
	private long counter;	//an increasing id counter for each new note
	private Map<Long, Note> allNotes;	//map that will hold all the current notes
	private Note emptyNote; //note to return when note doesn't exist
	
	/**
	 * Constructor for the catalog that initializes all variables
	 */
	private NoteCatalog() {
		//initialize all variables to default on startup
		counter = 1;
		allNotes = new HashMap<Long, Note>();
		emptyNote = new Note();
		emptyNote.setId(0);
		emptyNote.setBody("");
	}
	
	/**
	 * Singleton override for the class
	 * @return the current instance of NoteCatalog
	 */
	public static NoteCatalog getInstance() {
		if(singleInstance == null) {
			singleInstance = new NoteCatalog();
		}
		return singleInstance;
	}
	
	/**
	 * Create function for a new note.
	 * @param noteBody user specified body for this note.
	 * @return Note object with both the body and id for this note.
	 */
	public Note addNote(String noteBody) {
		//take note body and create a new note for it with the next id number
		Note note = new Note();
		note.setId(counter);
		note.setBody(noteBody);
		allNotes.put(counter, note);
		
		counter++;
		
		return allNotes.get(counter -1);
	}
	
	/**
	 * Update function for an existing note
	 * @param id the id of the note we wish to replace the body of
	 * @param noteBody user specified body for this note
	 * @return Note object with both the body and id for this note.
	 */
	public Note updateNote(long id, String noteBody) {
		//update the specified note by id with the string of the note body
		allNotes.get(id).setBody(noteBody);
		return allNotes.get(id);
	}
	
	/**
	 * Delete function for an existing note
	 * @param id the id of the note we wish to delete
	 * @return an empty note object
	 */
	public Note deleteNote(long id) {
		allNotes.remove(id);
		
		return retrieveNote(id);
	}
	
	/**
	 * Read function for an existing note
	 * @param id the id of the note we wish to fetch
	 * @return Note object matching the id, empty note object if none exists
	 */
	public Note retrieveNote(long id) {
		//return note based on id
		if(allNotes.containsKey(id)) {
			return allNotes.get(id);
		}
		else {
			return emptyNote;
		}
		
	}
	
	/**
	 * Searches for Notes by the body text
	 * @param searchParam string that should be a substring of an existing note if any exist
	 * @return collection of all notes matching the search parameter
	 */
	public Collection<Note> searchForNotesByText(String searchParam){
		//return all notes that have the given param.
		Collection<Note> notesToReturn = new LinkedList<Note>();
		
		Iterator it = allNotes.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Long, Note> pair = (Entry<Long, Note>) it.next();
			String noteBody = pair.getValue().getBody();
			
			if(noteBody.toLowerCase().contains(searchParam.toLowerCase())) {
				notesToReturn.add((Note) pair.getValue());
			}
		}
		
		return notesToReturn;
	}
	
	/**
	 * Returns all notes contained in the map
	 * @return all notes in the system
	 */
	public Collection<Note> retrieveAllNotes() {
		//return all notes present in the map
		return allNotes.values();
	}
	

}
