package kurly.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kurly.domain.entity.BoardEntity;
import kurly.domain.entity.BoardFileEntity;

public interface FileBoardService {

	List<BoardEntity> selectBoardList();

	//void insertFileBoard(BoardEntity fboard, MultipartHttpServletRequest multiRequest)throws Exception, IOException;

	void insertFileBoard(BoardEntity fboard, MultipartFile[] multipartFile)throws Exception;

	BoardEntity getDetail(long boardIdx);

	BoardFileEntity getFileEntity(long boardIdx, long idx);

	void fileDelete(long idx);




}
