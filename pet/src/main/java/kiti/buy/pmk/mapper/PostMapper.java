package kiti.buy.pmk.mapper;

import kiti.buy.pmk.vo.PostPageVO;
import kiti.buy.pmk.vo.PostVO;

import java.util.HashMap;
import java.util.List;

public interface PostMapper {
	void writePost(PostVO post);
	
	List<PostVO> findAll();

	List<PostPageVO> listingPage(int pageNum);

	int countAll();

	List<PostPageVO> categoryListingPage(HashMap<String,Integer> param);

	int countAllByCategory(int categorySeq);
}
