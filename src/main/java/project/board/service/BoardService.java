package project.board.service;

import org.springframework.stereotype.Service;
import project.board.domain.Board;
import project.board.repository.jpa.BoardRepository;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void saveBoard(String writer, String pwd, String email, String title, String content){
        Board board = Board.builder().bId("DEFAULT").writer(writer).pwd(pwd).email(email).title(title)
                .readed(0L).content(content).build();
        boardRepository.save(board);
    }

    public List<Board> getList(int currentPage, int numberPage){
        List<Board> boradList =
    }
}
