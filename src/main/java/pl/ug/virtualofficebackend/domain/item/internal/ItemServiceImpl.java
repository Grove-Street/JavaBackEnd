package pl.ug.virtualofficebackend.domain.item.internal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ug.virtualofficebackend.domain.item.boundary.ItemService;
import pl.ug.virtualofficebackend.domain.item.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {
   private ItemRepository itemRepository;

   @Autowired
   public ItemServiceImpl(ItemRepository itemRepository) {
      this.itemRepository = itemRepository;
   }

   public boolean add(Item workstation) {
      try {
         this.itemRepository.save(workstation);

         return true;
      } catch (Exception e) {
         e.printStackTrace();
      }

      return false;
   }

   public Item get(long id) {
      return this.itemRepository.findById(id).orElse(null);
   }

   public List<Item> getAll() {
      return new ArrayList<>(this.itemRepository.findAll());
   }
}