package com.controller;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.entity.Note;
import com.entity.NoteCatalog;

/**
 * NotesController.java
 * REST API access point for all clients with all CRUD operations for Note.java
 * @author Ben Haslar
 *
 */
@Path("notes")
public class NotesController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Note addNote(String noteBody) {
		return NoteCatalog.getInstance().addNote(noteBody);
	}
	
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Note updateNote(@PathParam("id") long noteId, String noteBody) {
		return NoteCatalog.getInstance().updateNote(noteId,noteBody);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Note deleteNote(@PathParam("id") long noteId) {
		return NoteCatalog.getInstance().deleteNote(noteId);
	}
		
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Note getNote(@PathParam("id") long noteId) {
		return NoteCatalog.getInstance().retrieveNote(noteId);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Note> getAllNotes(@QueryParam("query") String searchParam) {
		if(searchParam == null|| searchParam.isEmpty()) {
			return NoteCatalog.getInstance().retrieveAllNotes();
		}
		else {
			return NoteCatalog.getInstance().searchForNotesByText(searchParam);
		}
		
	}
}
