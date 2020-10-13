package kurly.domain.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FileBoardRepository extends JpaRepository<BoardEntity, Long>{

	List<BoardEntity> findAllByOrderByBoardIdxDesc();
	
	@Query("select file from BoardFileEntity file where BOARD_IDX=:boardIdx AND IDX=:idx")
	BoardFileEntity findBoardFileEntity(@Param("boardIdx")long boardIdx, @Param("idx")long idx);
	//@query어노테이션 사용가능하다. :변수 적용 @Param("변수이름")

	@Query("delete from BoardFileEntity file where BOARD_IDX=:boardIdx AND IDX=idx")
	void deleteFileEntity(long boardIdx, long idx);


}

