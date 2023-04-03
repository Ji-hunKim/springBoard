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

    public List<Boardd> getBoardList(int currentPage, int numPerPage, int searchCondition, String searchWord){

        List<Boardd> boardList = null;
        int begin = (currentPage-1)*numPerPage;

        if(searchWord == ""){
            boardList = boardMapper.selectBoard(begin, numPerPage);
        }else{
            switch (searchCondition) {
                case 1: // 제목
                    boardList = boardMapper.selectBoardTitle(begin, numPerPage, searchWord);
                    break;
                case 2:  // 내용
                    boardList = boardMapper.selectBoardContent(begin, numPerPage, searchWord);
                    break;
                case 3: // 작성자
                    boardList = boardMapper.selectBoardWriter(begin, numPerPage, searchWord);
                    break;
                case 4:  // 제목 + 내용
                    boardList = boardMapper.selectBoardBoth(begin, numPerPage, searchWord);
                    break;
            }
        }


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
    public PageBlock pagingService(int currentPage, int numPerPage, int numOfPageBlock, int searchCondition, String searchWord){

        PageBlock pageBlock = null;

        int totalRecords = 0;
        int totalPages = 1;

        if(searchWord == ""){
            totalRecords = pagingMapper.getTotalRecords();
            totalPages = pagingMapper.getTotalPages(numPerPage);
        }else{
            switch (searchCondition) {
                case 1: // 제목
                    totalRecords = pagingMapper.getTotalRecordsTitle(searchWord);
                    totalPages = pagingMapper.getTotalPagesTitle(numPerPage, searchWord);
                    break;
                case 2:  // 내용
                    totalRecords = pagingMapper.getTotalRecordsContent(searchWord);
                    totalPages = pagingMapper.getTotalPagesContent(numPerPage, searchWord);
                    break;
                case 3: // 작성자
                    totalRecords = pagingMapper.getTotalRecordsWriter(searchWord);
                    totalPages = pagingMapper.getTotalPagesWriter(numPerPage, searchWord);
                    break;
                case 4:  // 제목 + 내용
                    totalRecords = pagingMapper.getTotalRecordsBoth(searchWord);
                    totalPages = pagingMapper.getTotalPagesBoth(numPerPage, searchWord);
                    break;
            }
        }

        int begin = ( currentPage - 1)/numOfPageBlock * numOfPageBlock + 1;
        int end    = begin + numOfPageBlock - 1;
        if( end > totalPages )  end = totalPages;

        boolean prev =   begin == 1 ?  false : true;
        boolean next  =  end == totalPages ? false: true;

        pageBlock = new PageBlock(currentPage, numPerPage, numOfPageBlock ,begin, end, prev,  next);

        return pageBlock;
    }
}
