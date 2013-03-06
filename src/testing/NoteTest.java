package testing;

import static org.junit.Assert.*;
import implementation.NoteImp;

import org.junit.Before;
import org.junit.Test;

import api.Note;

public class NoteTest
{
	
	private Note note;

	@Before
	public void setUp() throws Exception
	{
		note = new NoteImp();
	}

	@Test
	public void test()
	{
		String content = "This is a note";
		note.setContent(content);
		note.setId(1);
		
		assertEquals("This is a note", note.getContent());
		assertEquals(1, note.getId());
	}

}
