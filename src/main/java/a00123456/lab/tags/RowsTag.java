package a00123456.lab.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * RowsTag
 * this class of tasgsupport handles row presentation
 */
public class RowsTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Vector<String>> vectorRows;
	private int rowIndex;
	private String oddRowColor = "#FFFFFF";
	private String evenRowColor = "#C3F3C3";
	  
	  public int doStartTag() {
		  	rowIndex = 1;
		    try {	
		      JspWriter out = pageContext.getOut();
		      Iterator<Vector<String>> i = vectorRows.iterator();
		      while (i.hasNext())
		      {
		    	  if (rowIndex % 2 == 0) {
		    		  out.print("<TR BGCOLOR='" + evenRowColor + "'>");
		    	  }
		    	  else {
		    		  out.print("<TR BGCOLOR='" + oddRowColor + "'>");
		    	  }
		    	  Vector<String> aRow = i.next();
		    	  Iterator<String> aRowI = aRow.iterator();
		    	  while(aRowI.hasNext())
		    	  {
				      out.print("<TD>");
			    	  out.print(aRowI.next());
				      out.print("</TD>");
		    	  }
			      out.print("</TR>");
			      rowIndex++;
		      }
		    } catch(IOException ioe) {
		      System.out.println("Error in ExampleTag: " + ioe);
		    }
		    return(SKIP_BODY);
		  }

	  	public void setVectorRows(Vector<Vector<String>> data) 
	  	{
	  		vectorRows = data;
		}

		public void setOddRowColor(String color) {
			oddRowColor = color;
		}

		public void setEvenRowColor(String color) {
			evenRowColor = color;
		}
}