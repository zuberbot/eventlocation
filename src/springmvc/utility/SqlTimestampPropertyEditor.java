/**
 * SqlTimestampPropertyEditor
 */
package springmvc.utility;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This custom class helps bind java.sql.Timestamp HTML form data to avoid this 
 * form does not validate error:
 * 
 * Failed to convert property value of type 'java.lang.String' to required type 
 * 'java.sql.Timestamp' for property 'createdDate'; nested exception is 
 * java.lang.IllegalArgumentException: Cannot convert value of type [java.lang.String] 
 * to required type [java.sql.Timestamp] for property 'createdDate': PropertyEditor 
 * [org.springframework.beans.propertyeditors.CustomDateEditor] returned inappropriate 
 * value of type [java.util.Date]
 * 
 * http://adfinmunich.blogspot.de/2011/04/how-to-write-sqltimestamppropertyeditor.html
 * 
 * @author Chuck
 *
 */
public class SqlTimestampPropertyEditor extends PropertyEditorSupport {

	public static final String DEFAULT_BATCH_PATTERN = "yyyy-MM-dd";
	 
    private final SimpleDateFormat sdf;
 
    /**
     * Uses default pattern for date parsing.
     */
    public SqlTimestampPropertyEditor() {
        this.sdf = new SimpleDateFormat(SqlTimestampPropertyEditor.DEFAULT_BATCH_PATTERN);
    }
 
    /**
     * Uses the given pattern for date parsing, see {@link SimpleDateFormat} for allowed patterns.
     * 
     * @param pattern
     *            the pattern describing the date and time format
     * @see SimpleDateFormat#SimpleDateFormat(String)
     */
    public SqlTimestampPropertyEditor(String pattern) {
        this.sdf = new SimpleDateFormat(pattern);
    }
 
    /**
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(new Timestamp(this.sdf.parse(text).getTime()));
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
        }
    }
 
    /**
     * Format the java.sql.Timestamp as String, using the specified DateFormat.
     */
    @Override
    public String getAsText() {
        Timestamp value = (Timestamp) getValue();
        return (value != null ? this.sdf.format(value) : "");
    }
    
}
