package api;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author    JFee
 */
@XmlRootElement (name="note")
@XmlType ( name="note", propOrder={"id", "content"})
public interface Note extends Serializable
{
	/**
	 * @uml.property  name="content"
	 */
	@XmlElement (name="content")
	public String getContent();
	/**
	 * @param  content
	 * @uml.property  name="content"
	 */
	public void setContent(String content);
	
	@XmlElement (name="id")
	public int getId();
	public void setId(int id);
}
