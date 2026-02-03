package es.upm.grise.profundizacion.file;

import java.util.List;

public class File {

    private FileType type;
    private List<Character> content;

	/*
	 * Constructor
	 */
    public File() {
        
    }

	/*
	 * Method to code / test
	 */
    public void addProperty(char[] content) {

    }

	/*
	 * Method to code / test
	 */
    public long getCRC32() {
    	
        return 0L;
        
    }
    
    
	/*
	 * Setters/getters
	 */
    public void setType(FileType type) {
    	
    	this.type = type;
    	
    }
    
    public List<Character> getContent() {
    	
    	return content;
    	
    }
    
}
