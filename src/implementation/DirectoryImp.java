package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utilities.NotebookAlreadyExistsException;
import utilities.NotebookNotFoundException;
import api.Directory;
import api.Notebook;

/**
 * @author JFee
 *
 */
public class DirectoryImp implements Directory
{
	//Singleton Pattern used
	public final static DirectoryImp INSTANCE = new DirectoryImp(); 
	private DirectoryImp(){};
	
	//the directory backed by HashMap
	
	private Map<String, Notebook> db = Collections.synchronizedMap(new HashMap<String, Notebook>());
	
	

	/**
	 * Finds a notebook in the directory by its ID
	 * @param id the wanted notebook's ID 
	 * @return the found Notebook or null otherwise
	 */
	public Notebook findById(String id)
	{
		return db.get(id);	
	}
	
	/**
	 * Find a notebook by its unique title
	 * @param title title of notebook to find
	 * @return the wanted notebook or null otherwise
	 */
	public Notebook findByTitle(String title)
	{
		for(Notebook n: this.getAllNotebooks())
		{
			if(n.getTitle().equalsIgnoreCase(title))
			{
				return n;
			}
		}
		
		return null;
	}

	public List<Notebook> getAllNotebooks()
	{
		List<Notebook> all = new ArrayList<Notebook>(db.values());
		return all;
	}

	public Notebook getNotebook(String id)
	{
		return this.findById(id);
	}

	public String createNotebook(String title, String primaryURL)
			throws NotebookAlreadyExistsException
	{
		//check if id is already associated with a notebook
		if(this.findById(primaryURL) != null)
		{
			throw new NotebookAlreadyExistsException("Notebook already in directory");
		}
		
		//check if title already is associated with a notebook
		if(this.findByTitle(title) != null)
		{
			throw new NotebookAlreadyExistsException("Notebook already in directory");
		}
		
		
		String id = primaryURL;
		Notebook nb = new NotebookImp();
		nb.setTitle(title);
		nb.setId(id);
		
		db.put(id, nb);
		return id;
	}

	public void deleteNotebook(String id)
			throws NotebookNotFoundException
	{
		Notebook found = this.findById(id);
		if(found == null)
		{
			throw new NotebookNotFoundException("Notebook does not exist in directory");
		}
		
		db.remove(found.getId());

	}
	
	
	//returning a copy of the DB for testing purposes
	public Map<String, Notebook> getCopyDB()
	{
		Map<String, Notebook> copy = new HashMap<String, Notebook>();
		copy.putAll(this.db);
		
		return copy;
	}

}
