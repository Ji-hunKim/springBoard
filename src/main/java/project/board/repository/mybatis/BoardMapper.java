package project.board.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import project.board.domain.Boardd;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Boardd> selectBoard(@Param("begin") int begin, @Param("numPerPage") int numPerPage);
    List<Boardd> selectBoardTitle(@Param("begin") int begin, @Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);
    List<Boardd> selectBoardContent(@Param("begin") int begin, @Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);
    List<Boardd> selectBoardWriter(@Param("begin") int begin, @Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);
    List<Boardd> selectBoardBoth(@Param("begin") int begin, @Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);

    void increaseReaded(Long seq);
    String getPwd(Long seq);
    void deleteBoard(Long seq);
    void updateBoard(@Param("seq")Long seq, @Param("writer") String writer, @Param("pwd") String pwd,
                     @Param("email") String email, @Param("title") String title, @Param("content") String content);
}
