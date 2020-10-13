package kurly.services;

import java.util.List;
import java.util.Vector;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kurly.domain.dto.ItemDto;
import kurly.domain.dto.ItemRequestDto;
import kurly.domain.dto.ItemRequestUpdate;
import kurly.domain.entity.Item;
import kurly.domain.entity.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository repository;
	
	@Override
	public void save(ItemRequestDto dto) {
		repository.save(dto.toEntity());
		
	}

	@Override
	public List<ItemDto> selectAll() {
		List<Item> result = repository.findAll();
		List<ItemDto> list = new Vector<>();
		for(Item item :result) {
			ItemDto dto = new ItemDto(item);
			list.add(dto);
		}
		return list;
	}

	@Override
	public ItemDto findById(Long no) {
		Item dto = repository.findById(no).orElse(null);
		ItemDto result = new ItemDto(dto);
		return result;
	}

	@Transactional
	@Override
	public void update(ItemRequestUpdate dto) {
		repository.findById(dto.getNo()).map(result->result.update(dto)).orElse(null);
		
	}

	@Override
	public void delete(Long no) {
		repository.deleteById(no);
		
	}



}
