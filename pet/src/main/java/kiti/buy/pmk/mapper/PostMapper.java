package kiti.buy.pmk.mapper;

import java.util.List;

import kiti.buy.pmk.vo.PostVO;

public interface PostMapper {
	void writePost(PostVO post);
	
	List<PostVO> findAll();
}
