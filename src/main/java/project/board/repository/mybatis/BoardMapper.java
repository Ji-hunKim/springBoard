package project.board.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import project.board.domain.Boardd;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Boardd> selectBoard(@Param("begin") int begin, @Param("numPerPage") int numPerPage);
    void increaseReaded(Long seq);
}
