import java.io.Serializable;

public class File1 implements Serializable{
    private static final long seriaVersionUID=1L;
    private File1 file1;
    private String fileName;


    private String path;
    private int starPos;
    private byte[]bytes;
    private int endPos;
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public File1 getFile1() {
        return file1;
    }

    public void setFile1(File1 file1) {
        this.file1 = file1;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getStarPos() {
        return starPos;
    }

    public void setStarPos(int starPos) {
        this.starPos = starPos;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }



}
