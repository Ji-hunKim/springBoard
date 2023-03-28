package project.board.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.board.domain.Board;

import java.util.ArrayList;

public interface BoardRepository extends JpaRepository<Board, String> {
    // 1. 글 쓰기

    // 2. 글 목록
    //ArrayList<Board> select(int currentPage, int numberPerPage );

    // 3. 글 상세보기
    // 3-1. 조회수 증가
    //int increaseReaded(int seq);
    // 3-2. 해당 게시글 반환
    //Board view(int seq);

    // 4. 글 삭제
    // 4-1. 비밀번호 확인
    //String getOriginalPwd(int seq);
    // 4-2. 글 삭제.
    //int delete(int seq);

    // 5. 수정
    //int update(Board board);

    // 6. 검색
    //ArrayList<Board> search( int currentPage, int numberPerPage, int searchCondition, String searchWord);

    // 총레코드수
    //int getTotalRecords();
    // 총페이지수
    //int getTotalPages(int numberPerPage);

    //  검색하기 - 총레코드수
    //int getTotalRecords(int searchCondition, String searchWord);
    // 검색하기 - 총페이지수
    //int getTotalPages(int numberPerPage, int searchCondition, String searchWord);
}
