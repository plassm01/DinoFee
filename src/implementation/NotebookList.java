package implementation;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import api.Notebook;


/**
 * List of Notebooks
 * @author   JFee
 */
@XmlRootElement (name="notebook-list")
public class NotebookList implements Serializable
{
	private static final long serialVersionUID = 2303902568394279368L;
	private List<Notebook> notebooks;
	
	@XmlElement (name="notebooks")
	public List<Notebook> getNotebooks()
	{
		return this.notebooks;
	}
	
	public void setNotebooks(List<Notebook> theList)
	{
		this.notebooks = theList;
	}
	

}
