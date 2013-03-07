package api;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author    JFee
 */
@XmlRootElement (name="notebook")
@XmlType (name="notebook", propOrder={"id", "title", "note"})
public interface Notebook extends Serializable
{
	/**
	 * @uml.property  name="id"
	 */
	@XmlElement (name="id")
	public String getId();
	/**
	 * @param  id
	 * @uml.property  name="id"
	 */
	public void setId(String id);
	
	@XmlElement (name="note")
	public ArrayList<Note> getNotes();
	public void setNotes(ArrayList<Note> notes);
	
	/**
	 * @uml.property  name="title"
	 */
	@XmlElement (name="title")
	public String getTitle();
	/**
	 * @param  title
	 * @uml.property  name="title"
	 */
	public void setTitle(String title);
	
}
	

	


