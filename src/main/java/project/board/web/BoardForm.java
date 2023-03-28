package project.board.web;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Data
public class BoardForm {
    @NotEmpty
    private String writer;
    @NotEmpty
    private String pwd;
    @NotEmpty
    private String email;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
}
