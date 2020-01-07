package a00123456.lab.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * HeadersTag
 * this class of tasgsupport handles header presentation
 */
public class HeadersTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<String> headerVector;
	private String headerColor = "#FFDC75";
	  
	  public int doStartTag() {
		    try {	
		      JspWriter out = pageContext.getOut();
		      Iterator<String> i = headerVector.iterator();
		      out.print("<TR BGCOLOR='" + headerColor + "'>");
		      while (i.hasNext())
		      {
			      out.print("<TH>");
		    	  out.print((String)i.next());
			      out.print("</TH>");
		      }
		      out.print("</TR>");
		    } catch(IOException ioe) {
		      System.out.println("Error in ExampleTag: " + ioe);
		    }
		    return(SKIP_BODY);
		  }

	  public void setHeaderVector(Vector<String> headers) 
	  {
	  	headerVector = headers;
	}

	public void setHeaderColor(String color){
		headerColor = color;
	}
}




