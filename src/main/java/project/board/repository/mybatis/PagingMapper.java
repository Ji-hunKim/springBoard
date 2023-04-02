package project.board.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PagingMapper {
    int getTotalRecords();
    int getTotalPages(int numPerPage);
}
