package testing;

import static org.junit.Assert.*;

import implementation.DirectoryImp;

import java.util.List;



import org.junit.Before;
import org.junit.Test;

import api.Notebook;

import utilities.NotebookAlreadyExistsException;
import utilities.NotebookNotFoundException;



public class DirectoryTest
{
	
	
	DirectoryImp d = DirectoryImp.INSTANCE;

	@Before
	public void setUp() throws Exception
	{
		
	}

	@Test
	public void testFindsCopiesCreates()
	{
		boolean found = false;
		try
		{
			d.createNotebook("One", "1 URL");
		}
		catch(NotebookAlreadyExistsException e)
		{
			found = true;
		}
		
		assertFalse(found);
		
		assertTrue(d.getCopyDB().containsKey("1 URL"));
		assertEquals("One", d.getCopyDB().get("1 URL").getTitle());
		
		List<Notebook> list = d.getAllNotebooks();
		assertEquals(1, list.size());
		assertEquals("1 URL", list.get(0).getId());
		
		assertNull(d.findById("ITSNull"));
		Notebook one = d.findById("1 URL");
		assertNotNull(one);
		assertEquals(one.getTitle(), "One");
		
		try
		{
			d.createNotebook("One", "1 URL");
		}
		catch(NotebookAlreadyExistsException e)
		{
			found = true;
		}
		
		assertTrue(found);
		
		found = false;
		try
		{
			d.createNotebook("One", "NotTheSame");
		}
		catch(NotebookAlreadyExistsException e)
		{
			found = true;
		}
		
		assertTrue(found);
	
		Notebook otherOne = d.getNotebook("1 URL");
		assertNotNull(otherOne);
		
		found = false;
		
		try
		{
			d.deleteNotebook("This should not work");
		}
		catch(NotebookNotFoundException e)
		{
			found = true;
		}
		
		assertTrue(found);
		
		
		found = false;
		try
		{
			d.deleteNotebook("1 URL");
		}
		catch(NotebookNotFoundException e)
		{
			found = true;
		}
		
		
		assertFalse(found);
		assertTrue(d.getAllNotebooks().isEmpty());
		
	}

}
