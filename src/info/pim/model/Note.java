package info.pim.model;

import java.io.Serializable;

/**
 * Note Model
 */
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String content;

    public void copyData(Note source) {
        this.content = source.content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
