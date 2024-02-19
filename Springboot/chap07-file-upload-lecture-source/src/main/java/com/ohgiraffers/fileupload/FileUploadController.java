package com.ohgiraffers.fileupload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    /* 설명. build된 파일 업로드 할 경로를 가져오기 위해 ResourceLoader 의존성 주입 받기 */
    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile,  // 파일은 String형으로 받을 수 없기 때문에 MultipartFile 사용
                                   @RequestParam String singleFileDescription,
                                   RedirectAttributes rttr) throws IOException {

        /* 설명. encType = "multipart/form-data" 형태로 넘어온 파일은 MultipartFile 타입으로 받게 된다. */
        System.out.println("singleFile = " + singleFile);
        System.out.println("singleFileDescription = " + singleFileDescription);

        /* 설명. build 경로의 static에 있는 파일 업로드 할 곳의 경로를 받아온다.(미리 경로에 해당하는 디렉토리 생성 및 빌드 확인) */
        Resource resource = resourceLoader.getResource("classpath:static/uploadFiles/img/single");
//        System.out.println("빌드된 single 디렉토리의 절대경로 : " +  resource.getFile().getAbsolutePath());
        String filePath = resource.getFile().getAbsolutePath();
        
        /* 설명. 사용자가 넘긴 파일을 확인하고, rename해보기(자바의 UUID 클래스를 활용해서 rename) */
        String originFileName = singleFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);
        
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        System.out.println("ext = " + ext);
        
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        System.out.println("savedName = " + savedName);

        /* 설명. 우리가 지정한 경로로 파일을 저장하고, */
        try {
            singleFile.transferTo(new File(filePath + "/" + savedName));

            /* 설명. DB를 다녀오는 BL 구문 작성 (DB에 저장) */
            /* BL이 성공하면 화면의 재료를 RedirectAttribute로 담는다.(flashAttribute) */
            rttr.addFlashAttribute("message", "파일 업로드 성공");
            rttr.addFlashAttribute("img", "uploadFiles/img/single/" + savedName);
            rttr.addFlashAttribute("singleFileDescription", singleFileDescription);

        }catch (IOException e){

            /* 설명. try 구문 안에서(DB를 다녀오는 business logic 처리) 예외가 발생하면 파일만 올라가면 안되므로 찾아서 다시 지워줌 */
            new File(filePath + "/" + savedName).delete();
        }

        return "redirect:/result";          // 사용자가 새로고침은 누르면 업로드가 계속 되기 때문에 방지하는 목적으로 redirect 사용
    }

    @GetMapping("result")
    public void result(){}

}