package project.board.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bId;

    private String writer;
    private String pwd;
    private String email;
    private String title;
    private Timestamp writedate;
    private Long readed;
    private String content;

    public Board() {
    }

    public Board(Long bId, String writer, String pwd, String email, String title, Timestamp writedate, Long readed, String content) {
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
