package hello.itemservice.domain.item;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용

     // 저장
    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    // 단일 찾기
    public Item findById(Long id) {
        return store.get(id);
    }

    // 전부 찾기
    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 수정
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);

        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // 초기화
    public void clearStore() {
        store.clear();
    }

}
