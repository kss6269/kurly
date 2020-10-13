package kurly.services;

import java.util.List;

import kurly.domain.dto.ItemDto;
import kurly.domain.dto.ItemRequestDto;
import kurly.domain.dto.ItemRequestUpdate;

public interface ItemService {

	void save(ItemRequestDto dto);

	List<ItemDto> selectAll();

	ItemDto findById(Long no);

	void update(ItemRequestUpdate dto);

	void delete(Long no);

}
