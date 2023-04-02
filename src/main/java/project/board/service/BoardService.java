package project.board.service;

import org.springframework.stereotype.Service;
import project.board.domain.Board;
import project.board.domain.Boardd;
import project.board.domain.PageBlock;
import project.board.repository.jpa.JpaBoardRepository;
import project.board.repository.mybatis.BoardMapper;
import project.board.repository.mybatis.PagingMapper;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class BoardService {
    private final JpaBoardRepository jpaBoardRepository;
    private final BoardMapper boardMapper;
    private final PagingMapper pagingMapper;

    public BoardService(JpaBoardRepository jpaBoardRepository, BoardMapper boardMapper, PagingMapper pagingMapper) {
        this.jpaBoardRepository = jpaBoardRepository;
        this.boardMapper = boardMapper;
        this.pagingMapper = pagingMapper;
    }

    public void saveBoard(String writer, String pwd, String email, String title, String content){
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);

        Board board = Board.builder().writer(writer).pwd(pwd).email(email).title(title).writedate(timestamp)
                .readed(0L).content(content).build();
        jpaBoardRepository.save(board);
    }

    public List<Boardd> getBoardList(int currentPage, int numPerPage){
        int begin = (currentPage-1)*numPerPage;
        List<Boardd> boardList = boardMapper.selectBoard(begin, numPerPage);
        return boardList;
    }

    @Transactional
    public Board getBoard(Long seq){
        boardMapper.increaseReaded(seq);
        Board board = jpaBoardRepository.findBybId(seq);
        return board;
    }

    public String deleteBoard(Long seq, String pwd){
        String originPwd = boardMapper.getPwd(seq);
        if(originPwd.equals(pwd)) {
            boardMapper.deleteBoard(seq);
            return "success";
        }
        else{
            return "fail";
        }
    }


    public void editBoard(Long seq,String writer, String pwd, String email, String title, String content ){
        boardMapper.updateBoard(seq, writer, pwd, email, title, content);
    }


    @Transactional
    public PageBlock pagingService(int currentPage, int numPerPage, int numOfPageBlock, int SearchCondition, String searchWord){

        PageBlock pageBlock = null;

        int totalRecords = 0;
        int totalPages = 1;

        if(searchWord == ""){
            totalRecords = pagingMapper.getTotalRecords();
            totalPages = pagingMapper.getTotalRecords();
        }else{
            totalRecords = pagingMapper.getTotalRecords();
            totalPages = pagingMapper.getTotalRecords();
        }

        return pageBlock;
    }
}
