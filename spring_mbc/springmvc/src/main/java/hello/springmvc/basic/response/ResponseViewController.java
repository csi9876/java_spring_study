package hello.springmvc.basic.response;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // 탬플릿 반환
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello!");
        return mav;
    }

    // 탬플릿을 string으로 반환
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    // 경로와 탬플릿 이름을 같게 하면 반환하지 않아도 알아서 반환
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {model.addAttribute("data", "hello!!");
    }

}
