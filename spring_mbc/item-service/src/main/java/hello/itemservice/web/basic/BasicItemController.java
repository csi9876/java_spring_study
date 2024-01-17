package hello.itemservice.web.basic;


import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
//@RequiredArgsConstructor >> 이거 쓰면  public BasicItemController 없어도 된다
public class BasicItemController {
    private final ItemRepository itemRepository;

    public BasicItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }


    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    // prams 일일이 받아서 저장
//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemRepository.save(item);

        model.addAttribute("item", item);
        return "basic/item";
    }

    // modelAttribute 로 저장
//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {
        itemRepository.save(item);
        //model.addAttribute("item", item); //자동 추가, 생략 가능
        return "basic/item";}

    // modelAttribute name과 모델 생략
//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    // modelAttribute 전체 생략
//    @PostMapping("/add")
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

    // redirect (새로고침시 재요청 방지)
//    @PostMapping("/add")
    public String addItemV5(Item item) {
        itemRepository.save(item);
        // url에 쿼리나 파람스 넣기 어려움
        return "redirect:/basic/items/" + item.getId();
    }

    // RedirectAttributes : url 인코딩, pathVariable, 쿼리 처리
    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);

        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/basic/items/{itemId}";
    }

    // 상품 수정페이지
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    // 상품 수정
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    // 테스트용 데이터
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 20000, 20));
    }
}
