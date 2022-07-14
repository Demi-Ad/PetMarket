package kiti.buy.pmk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kiti.buy.pmk.dto.post.PostCreateDto;
import kiti.buy.pmk.mapper.PostMapper;
import kiti.buy.pmk.vo.PostVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
	private final PostMapper postMapper;

	public int postCreate(PostCreateDto dto, int authorSeq) {
		PostVO post = PostVO.builder()
		.postTitle(dto.getPostTitle())
		.postContent(dto.getPostContent())
		.postCategory(dto.getPostCategory())
		.postAuthor(authorSeq)
		.build();
		
		postMapper.writePost(post);
		
		return post.getPostSeq();
		
	}
	
}