package thymeleaf.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ThymeleafHandler {

    @Autowired
    //服务器一启动此对象就被创建了
    private ServletContext servletContext;

    @RequestMapping("/test/thymeleaf")
    public ModelAndView thymeleafTest(ModelAndView modelAndView, HttpSession session){
        ModelAndView mv = new ModelAndView();

        //1.将数据存入请求域
        mv.addObject("requestScope","request");

        //2.将数据存放到session域
        session.setAttribute("sessionScope","session");

        //3.将数据存放到应用域
        servletContext.setAttribute("applicationScope","application");

        //4.将集合存放到请求域中
        mv.addObject("list", Arrays.asList("aaa","bbb","ccc","ddd"));


        mv.setViewName("first-thymeleaf");
        return mv;
    }

}
