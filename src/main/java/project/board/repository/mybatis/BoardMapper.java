package project.board.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import project.board.domain.Boardd;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Boardd> selectBoard(@Param("begin") int begin, @Param("numPerPage") int numPerPage);
    void increaseReaded(Long seq);
    String getPwd(Long seq);
    void deleteBoard(Long seq);
    void updateBoard(@Param("seq")Long seq, @Param("writer") String writer, @Param("pwd") String pwd,
                     @Param("email") String email, @Param("title") String title, @Param("content") String content);
}
