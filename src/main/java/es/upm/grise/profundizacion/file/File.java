package es.upm.grise.profundizacion.file;

import java.util.ArrayList;
import java.util.List;

public class File {

    private FileType type;
    private List<Character> content;

    // Utilidad para CRC32 (según especificación)
    private final FileUtils fileUtils;

    /*
     * Constructor
     * content deberá estar vacío, pero no null.
     */
    public File() {
        this.content = new ArrayList<>();  // vacío, pero NO null
        this.fileUtils = new FileUtils();
    }

    /*
     * Method to code / test
     * Añade un par clave=valor al content (append)
     */
    public void addProperty(char[] newcontent) {

        if (newcontent == null) {
            throw new InvalidContentException("newcontent cannot be null");
        }

        if (this.type == FileType.IMAGE) {
            throw new WrongFileTypeException("Cannot add a PROPERTY to an IMAGE file");
        }

        for (char c : newcontent) {
            this.content.add(c);
        }
    }

    /*
     * Method to code / test
     * Calcula CRC32 del content
     */
    public long getCRC32() {

        if (this.content == null || this.content.isEmpty()) {
            return 0L; // calculateCRC32 no admite arrays vacíos
        }

        // Convertimos cada char (UTF-16) a 2 bytes: MSB y LSB.
        // Para PNG 8-bit, MSB será 0 y el LSB contiene el valor [0..255].
        byte[] bytes = new byte[this.content.size() * 2];

        int i = 0;
        for (Character ch : this.content) {
            char c = ch.charValue();

            byte msb = (byte) ((c >>> 8) & 0xFF);
            byte lsb = (byte) (c & 0x00FF);

            bytes[i++] = msb;
            bytes[i++] = lsb;
        }

        return fileUtils.calculateCRC32(bytes);
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
