package project.board.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity(name="board")
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bId;

    private String writer;
    private String pwd;
    private String email;
    private String title;
    private Long readed;
    private String content;

    public Board() {
    }

    public Board(String bId, String writer, String pwd, String email, String title, Long readed, String content) {
        this.bId = bId;
        this.writer = writer;
        this.pwd = pwd;
        this.email = email;
        this.title = title;
        this.readed = readed;
        this.content = content;
    }
}
