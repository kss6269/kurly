package kurly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kurly.common.FileUtils;
import kurly.domain.entity.BoardEntity;
import kurly.domain.entity.BoardFileEntity;
import kurly.domain.entity.FileBoardRepository;
import kurly.domain.entity.FileTableRepository;

@Service
public class FileBoardServiceImpl implements FileBoardService{
	@Autowired
	private FileBoardRepository fileBoardRepository;
	
	@Autowired
	private FileTableRepository fileTableRepository;
	
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public List<BoardEntity> selectBoardList() {
		List<BoardEntity> list=fileBoardRepository.findAllByOrderByBoardIdxDesc();
		return list;
	}
/*
	@Override
	public void insertFileBoard(BoardEntity fboard, MultipartHttpServletRequest multiRequest) throws Exception, IOException {
		//첨부파일 정보세팅
		//List<BoardFileEntity> fileList=fileUtils.parseFileInfo(fboard, multiRequest);
		List<BoardFileEntity> fileList=fileUtils.parseFileInfo(multiRequest);
		
		fboard.setFileList(fileList);
		
		//System.out.println(fboard);
		fileBoardRepository.save(fboard);
		
	}
*/
	@Override
	public void insertFileBoard(BoardEntity fboard, MultipartFile[] multipartFile) throws Exception {
		
		List<BoardFileEntity> fileList=fileUtils.parseFileInfo(fboard, multipartFile);
		
		fboard.setFileList(fileList);
		
		//System.out.println(fboard);
		fileBoardRepository.save(fboard);
		
	}
	//Transactional 을 적용하면
	//setsetHitCnt(): 따로 update 하지 않아도 자동으로 update쿼리가 실행된다.
	@Transactional
	@Override
	public BoardEntity getDetail(long boardIdx) {
		Optional<BoardEntity> opt=fileBoardRepository.findById(boardIdx);
		//isPresent() 값이 존재하는지 확인하기위해서 사용
		if(opt.isPresent()) {
			BoardEntity dto=opt.get();
			dto.setHitCnt(dto.getHitCnt()+1);
			return dto;
		}
		return null;
	}
	@Override
	public BoardFileEntity getFileEntity(long boardIdx, long idx) {
		BoardFileEntity fileEntity=fileBoardRepository.findBoardFileEntity(boardIdx, idx);
		return fileEntity;
	}
	@Override
	public void fileDelete(long idx) {
		fileTableRepository.deleteById(idx);
		
	}


	

}
