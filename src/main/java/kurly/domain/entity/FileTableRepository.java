package kurly.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileTableRepository extends JpaRepository<BoardEntity, Long>{

	List<BoardEntity> findAllByOrderByBoardIdxDesc();
	


}

