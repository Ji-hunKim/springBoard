package project.board.repository.jpa;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class BoardRepositoryImpl implements BoardRepository{
    private final JpaBoardRepository jpaBoardRepository;

    public BoardRepositoryImpl(JpaBoardRepository jpaBoardRepository) {
        this.jpaBoardRepository = jpaBoardRepository;
    }

}
