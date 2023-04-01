package project.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter@Setter
public class Boardd {
    private String bId;

    private String writer;
    private String pwd;
    private String email;
    private String title;
    private Timestamp writedate;
    private Long readed;
    private String content;

    public Boardd(String bId, String writer, String pwd, String email, String title, Timestamp writedate, Long readed, String content) {
        this.bId = bId;
        this.writer = writer;
        this.pwd = pwd;
        this.email = email;
        this.title = title;
        this.writedate = writedate;
        this.readed = readed;
        this.content = content;
    }
}
