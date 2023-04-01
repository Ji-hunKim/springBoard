package project.board.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import project.board.domain.Board;
import project.board.domain.Boardd;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Boardd> selectBoard(int begin, int numPerPage);
}
