package project.board.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import project.board.domain.Board;


public interface JpaBoardRepository extends JpaRepository<Board, String> {
    Board findBybId(Long seq);
}
