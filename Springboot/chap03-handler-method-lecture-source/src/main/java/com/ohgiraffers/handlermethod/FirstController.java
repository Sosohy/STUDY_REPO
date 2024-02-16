package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller

/* 설명. 현재의 Controller 클래스에 작성할 핸들러 메소드들이 모두 /first/xxx의 요청을 받게 될 때 클래스에 어노테이션을 추가할 수 있다. */
@RequestMapping("/first")    // 공통 요청 부분 빼내기
public class FirstController {

    /* 설명. 반환형이 void인 핸들러 메소드는 요청 경로 자체가 view의 경로 및 이름을 반환한 것으로 바로 해석이 된다.  */
    @GetMapping("regist")    // '/regist' 또는 'regist' 둘 다 허용
//    public String regist(){
//        return "/first/regist";
//    }
    public void regist(){}     // 경로 자체가 뷰의 이름

    /* request를 쓰게 된다면 request 개념은 사용자의 입력값이 존재, model은 동적 페이지의 재료를 담는 용도로 쓰기 */
    @PostMapping("regist")
//    public String registMenu(HttpServletRequest request){
    public String registMenu(WebRequest request, Model model){
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        int price = Integer.valueOf(request.getParameter("price"));
        int categoryCode = Integer.valueOf(request.getParameter("categoryCode"));

        String msg = name + " "  +  categoryCode + " " + price + " --- 메뉴 등록 성공";
        model.addAttribute("message", msg);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify(){}

    /* 설명
     *  request의 parameter로 넘어오는 값들의 key값과 일치하는 변수명을 작성하고
     *  @RequestParam 어노테이션을 적용하면 알아서 값을 꺼내고 해당 매개변수의 자료형에 맞게 변환까지 해준다.
     *  ** @RequestParam 어노테이션은 생략도 가능하다.
     *  (스프링부터는 컨트롤러의 파싱(parsing)작업이 간소화 된다는 것을 알 수 있다.)
     *  ** default value 설정 가능
    * */

    /* 설명
     *  @RequestParam의 속성들
     *  1. defaultValue : 사용자의 입력 값이 없거나("") 아니면 request의 parameter 키 값과 일치하지 않는 매개변수명 사용 시 매개변수가 가질 기본 default값을 작성한다.
     *  2. name : request parameter의 키 값과 다른 매개변수 명을 사용하고 싶을 때 request parameter의 키 값을 작성한다.
    * */
    @PostMapping("modify")
    public String modifyMenu(Model model,
                             @RequestParam(defaultValue = "디폴트", name= "name") String modifyName,
                             @RequestParam(defaultValue = "0") int modifyPrice){

        String msg = modifyName + "의 가격을 " + modifyPrice + "원으로 변경";
        model.addAttribute("message", msg);

        return "first/messagePrinter";
    }

    @PostMapping("modify2")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameter){

        String modifyName = parameter.get("name2");
        int modifyPrice = Integer.valueOf(parameter.get("modifyPrice2"));

        String msg = modifyName + "의 가격을 " + modifyPrice + "원으로 변경";
        model.addAttribute("message", msg);

        return "first/messagePrinter";
    }
}
