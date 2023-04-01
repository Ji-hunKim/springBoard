package project.board.service;

import org.springframework.stereotype.Service;
import project.board.domain.Board;
import project.board.domain.Boardd;
import project.board.repository.jpa.BoardRepository;
import project.board.repository.mybatis.BoardMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public BoardService(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    public void saveBoard(String writer, String pwd, String email, String title, String content){
        Board board = Board.builder().bId("DEFAULT").writer(writer).pwd(pwd).email(email).title(title)
                .readed(0L).content(content).build();
        boardRepository.save(board);
    }

    public List<Boardd> getBoardList(int currentPage, int numPerPage){
        int begin = (currentPage-1)*numPerPage;
        List<Boardd> boardList = boardMapper.selectBoard(begin, numPerPage);
        return boardList;
    }
}
