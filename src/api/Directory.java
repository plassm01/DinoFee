package api;


import java.util.List;
import javax.ejb.Remote;

import utilities.NotebookAlreadyExistsException;
import utilities.NotebookNotFoundException;

@Remote
public interface Directory
{
	List<Notebook> getAllNotebooks();
	
	Notebook getNotebook(String id);
	
	String createNotebook(String title, String theURL) throws NotebookAlreadyExistsException;
	
	void deleteNotebook(String id) throws NotebookNotFoundException;

}
