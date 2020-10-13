package kurly.common;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kurly.domain.entity.BoardEntity;
import kurly.domain.entity.BoardFileEntity;

@Component
public class FileUtils {
	/*
	public List<BoardFileEntity> parseFileInfo(MultipartHttpServletRequest multiRequest) throws Exception{
		if(ObjectUtils.isEmpty(multiRequest)) {
			return null;
		}
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate current=LocalDate.now();
		String path="D:/spring/workspace/kurly-v2/src/main/resources/static/upload/"+current.format(format);
		System.out.println("path : "+ path);
		
		
		//String realPath=multiRequest.getServletContext().getRealPath(path);
		//System.out.println("realPath: "+realPath);
		//File dir=new File(realPath);
		File dir=new File(path);
		//.getRealPath(path);
		if(dir.exists()==false) {
			dir.mkdir();
			System.out.println("디렉토리생성");
		}
		
		List<BoardFileEntity> fileList=new Vector<>();//파일정보 저장할 List
		//파일이 없을수도 있다.파일이 있을때만 파일처리
		if(ObjectUtils.isEmpty(multiRequest)==false) {
			List<MultipartFile> files=multiRequest.getFiles("files");
			for(MultipartFile file:files) {
				//System.out.println("파일이름 : "+file.getName());
				//System.out.println("파일타입 : " +file.getContentType());
				//System.out.println("파일실제이름 :"+file.getOriginalFilename());
				//System.out.println("파일사이즈 : "+file.getSize());
				//BoardFileEntity 객체에 셋팅 후 List에 저장
				String fileName=file.getOriginalFilename();
				String[] strs=fileName.split("[.]");
				String extention=strs[strs.length-1];//파일이름중에 확장자만 추출
				//System.out.println(extention);
				String newFileName=strs[0]+"_"+System.nanoTime()+"."+extention;
				//System.out.println(newFileName);
				String storedfilePath = path+"/"+newFileName;
				BoardFileEntity fileEntity=new BoardFileEntity();
				fileEntity.setOrignalFileName(fileName);
				fileEntity.setStoredfilePath(storedfilePath);
				fileEntity.setFileSize(file.getSize());
				fileEntity.setCreatorId(multiRequest.getParameter("creatorId"));
				fileList.add(fileEntity);//완성된 파일정보는 list에 저장
				
				file.transferTo(new File(storedfilePath));
			}//for End
		}//if End
		return fileList;
	}
	//*/
	/*
/////////////////////////////////////////////////////////////////////////////////////////
	public List<BoardFileEntity> parseFileInfo(BoardEntity fboard, MultipartHttpServletRequest multiRequest) throws Exception{
		if(ObjectUtils.isEmpty(multiRequest)) {
			return null;
		}
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate current=LocalDate.now();
		String path="upload/"+current.format(format);
		System.out.println("path : "+ path);
		
		
		//String realPath=multiRequest.getServletContext().getRealPath(path);
		//System.out.println("realPath: "+realPath);
		//File dir=new File(realPath);
		File dir=new File(path);
		//.getRealPath(path);
		if(dir.exists()==false) {
			dir.mkdir();
			System.out.println("디렉토리생성");
		}
		
		List<BoardFileEntity> fileList=new Vector<>();//파일정보 저장할 List
		//파일이 없을수도 있다.파일이 있을때만 파일처리
		if(ObjectUtils.isEmpty(multiRequest)==false) {
			List<MultipartFile> files=multiRequest.getFiles("files");
			for(MultipartFile file:files) {
				//System.out.println("파일이름 : "+file.getName());
				//System.out.println("파일타입 : " +file.getContentType());
				//System.out.println("파일실제이름 :"+file.getOriginalFilename());
				//System.out.println("파일사이즈 : "+file.getSize());
				//BoardFileEntity 객체에 셋팅 후 List에 저장
				String fileName=file.getOriginalFilename();
				String[] strs=fileName.split("[.]");
				String extention=strs[strs.length-1];//파일이름중에 확장자만 추출
				//System.out.println(extention);
				String newFileName=strs[0]+"_"+System.nanoTime()+"."+extention;
				//System.out.println(newFileName);
				String storedfilePath = path+"/"+newFileName;
				BoardFileEntity fileEntity=new BoardFileEntity();
				fileEntity.setOrignalFileName(fileName);
				fileEntity.setStoredfilePath(storedfilePath);
				fileEntity.setFileSize(file.getSize());
				fileEntity.setCreatorId(fboard.getCreatorId());
				fileList.add(fileEntity);//완성된 파일정보는 list에 저장
				
				file.transferTo(new File(storedfilePath));
			}//for End
		}//if End
		return fileList;
	}
 	//*/
/////로컬컴퓨터 기준 경로세팅/////////////////////////////////////////////////////////////////
	public List<BoardFileEntity> parseFileInfo(BoardEntity fboard, MultipartFile[] multipartFile) throws Exception{
		if(ObjectUtils.isEmpty(multipartFile)) {
			return null;
		}
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate current=LocalDate.now();
		String location="D:/spring/workspace/kurly-v2/src/main/resources/static/upload";
		String folder="/"+current.format(format);
		//System.out.println("path : "+ folder);
		
		//String realPath=multiRequest.getServletContext().getRealPath(path);
		//System.out.println("realPath: "+realPath);
		//File dir=new File(realPath);
		File dir=new File(location+folder);
		System.out.println("dir : "+dir.getAbsolutePath());
		//.getRealPath(path);
		if(dir.exists()==false) {
			dir.mkdir();
			System.out.println("디렉토리생성");
		}
		
		List<BoardFileEntity> fileList=new Vector<>();//파일정보 저장할 List
		//파일이 없을수도 있다.파일이 있을때만 파일처리
		
		for(MultipartFile file : multipartFile) {
			//System.out.println("파일이름 : "+file.getName());
			//System.out.println("파일타입 : " +file.getContentType());
			//System.out.println("파일실제이름 :"+file.getOriginalFilename());
			//System.out.println("파일사이즈 : "+file.getSize());
			//BoardFileEntity 객체에 셋팅 후 List에 저장
			String fileName=file.getOriginalFilename();
			String[] strs=fileName.split("[.]");
			String extention=strs[strs.length-1];//파일이름중에 확장자만 추출
			//System.out.println(extention);
			String newFileName=strs[0]+"_"+System.nanoTime()+"."+extention;
			//System.out.println(newFileName);
			String storedfilePath = folder+"/"+newFileName;//폴더에 저장된 새파일
			BoardFileEntity fileEntity=new BoardFileEntity();
			fileEntity.setOrignalFileName(fileName);
			fileEntity.setStoredfilePath(storedfilePath);
			fileEntity.setFileSize(file.getSize());
			fileEntity.setCreatorId(fboard.getCreatorId());
			fileList.add(fileEntity);//완성된 파일정보는 list에 저장
			
			file.transferTo(new File(storedfilePath));
		}//for End
		return fileList;
	}
}
