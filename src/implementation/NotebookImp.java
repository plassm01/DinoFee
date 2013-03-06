package implementation;

import java.io.Serializable;
import java.util.ArrayList;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import api.Note;
import api.Notebook;


/**
 *Notebook with unique String id, unique String title and Notes associated with it. 
 * @author JFee
 *
 */
@XmlRootElement (name="notebook")
@XmlType (name="notebook", propOrder={"id", "title", "note"})
public class NotebookImp implements Notebook, Serializable
{
	private static final long serialVersionUID = 8018457530676416928L;
	private String id;
	private ArrayList<Note> notes;
	private String title;
	
	
	@XmlElement (name="id")
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	
	@XmlElement (name="note")
	public ArrayList<Note> getNotes()
	{
		return notes;
	}
	public void setNotes(ArrayList<Note> notes)
	{
		this.notes = notes;
	}
	
	
	@XmlElement (name="title")
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	

}
