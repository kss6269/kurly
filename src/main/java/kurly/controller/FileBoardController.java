package kurly.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kurly.domain.entity.BoardEntity;
import kurly.domain.entity.BoardFileEntity;
import kurly.services.FileBoardService;

@Controller
public class FileBoardController {
	
	@Autowired
	FileBoardService fileBoardService;
	
	@GetMapping("/fboard")
	public ModelAndView openFileBoard(){
		ModelAndView mv=new ModelAndView("/fboard/list");
		List<BoardEntity> list=fileBoardService.selectBoardList();
		mv.addObject("list", list);
		mv.addObject("today", LocalDate.now());
		
		return mv;
	}
	
	@GetMapping("/fboard/write")
	public String write() {
		return "/fboard/write";
	}
	
	@PostMapping("/fboard/write")
	/*
	public String write(BoardEntity fboard, MultipartHttpServletRequest multiRequest)  throws Exception, IOException{
		fileBoardService.insertFileBoard(fboard, multiRequest);
		return "redirect:/fboard";
	}
	//*/
	public String write(BoardEntity fboard, @RequestParam("files")MultipartFile[] MultipartFile)  throws Exception, IOException{
		fileBoardService.insertFileBoard(fboard, MultipartFile);
		return "redirect:/fboard";
	}
	
	@GetMapping("/fboard/detail/{no}")
	public ModelAndView detail(@PathVariable("no")long boardIdx) {
		ModelAndView mv=new ModelAndView("/fboard/detail");
		BoardEntity dto=fileBoardService.getDetail(boardIdx);
		System.out.println("detail: "+dto);
		mv.addObject("detail", dto);
		return mv;
	}
	@GetMapping("fboard/file")
	public void downloadFile(long boardIdx, long idx, HttpServletResponse response) throws IOException {
		BoardFileEntity file=fileBoardService.getFileEntity(boardIdx, idx);
		//System.out.println(file);
		String location = "D:/spring/workspace/kurly-v2/src/main/resources/static/upload";
		String path=location+file.getStoredfilePath();
		File downfile=new File(path);
		byte[] fileBytes=org.apache.commons.io.FileUtils.readFileToByteArray(downfile);
		response.setContentType("application/octet-stream");//바이너리 파일입니다.
		response.setContentLength(fileBytes.length);
		response.setHeader("Content-Disposition", "attachment; fileName="
					+URLEncoder.encode(file.getOrignalFileName(),"UTF-8"));
		
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream os=response.getOutputStream();
		os.write(fileBytes);
		os.flush();
		os.close();
	}
	
	@PostMapping("/fboard/file-delete")
	public void fileDelete(long idx) {
		System.out.println("삭제할 idx : " +idx);
		fileBoardService.fileDelete(idx);
	}
		
}
