package project.board.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PagingMapper {
    int getTotalRecords();
    int getTotalPages(int numPerPage);
    int getTotalRecordsTitle(String searchWord);
    int getTotalPagesTitle(@Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);
    int getTotalRecordsContent(String searchWord);
    int getTotalPagesContent(@Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);
    int getTotalRecordsWriter(String searchWord);
    int getTotalPagesWriter(@Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);
    int getTotalRecordsBoth(String searchWord);
    int getTotalPagesBoth(@Param("numPerPage") int numPerPage, @Param("searchWord") String searchWord);

}
