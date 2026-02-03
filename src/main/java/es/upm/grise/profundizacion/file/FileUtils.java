package es.upm.grise.profundizacion.file;

public class FileUtils {
	
	// Please notice the difference between the class diagram and this implementation
	// The reason is to facilitate unit testing
	
	long CRC32;
	
	void setCRC(long CRC32) {
		
		this.CRC32 = CRC32;
		
	}
	
	long calculateCRC32(byte[] bytes) {
		
		return this.CRC32;
		
	}

}
