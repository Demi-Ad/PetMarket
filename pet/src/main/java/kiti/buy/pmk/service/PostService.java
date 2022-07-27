package kiti.buy.pmk.service;

import kiti.buy.pmk.component.MultipartImageUploadComponent;
import kiti.buy.pmk.dto.post.PostCreateDto;
import kiti.buy.pmk.dto.post.PostDetailDTO;
import kiti.buy.pmk.mapper.PostMapper;
import kiti.buy.pmk.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
	private final PostMapper postMapper;
	private final MultipartImageUploadComponent multipartImageUploadComponent;

	public int postCreate(PostCreateDto dto, int authorSeq) {
		
		String postImgPath =  multipartImageUploadComponent.saveImageAndGetPath(dto.getPostImg() , MultipartImageUploadComponent.SaveType.POST);
		
		PostVO post = PostVO.builder()
		.postTitle(dto.getPostTitle())
		.postContent(dto.getPostContent())
		.postCategory(dto.getPostCategory())
		.postAuthor(authorSeq)
		.postImgPath(postImgPath)
		.build();
		
		postMapper.writePost(post);
		
		return post.getPostSeq();
		
		
		
	}

	public PostDetailDTO postDetail(int seq) {
		HashMap<String,Integer> param = new HashMap<>();

		PostDetailDTO postDetailDTO = postMapper.postDetail(seq);
		int postHit = postDetailDTO.getPostHit();

		param.put("postSeq",seq);
		param.put("postHit", ++postHit);
		postMapper.postHitCountUp(param);

		postDetailDTO.setPostHit(postHit);
		return postDetailDTO;
	}

	public void postDelete(int postSeq, int sessionAccountSeq) {
		PostVO post = postMapper.findByPostSeq(postSeq);
		if (isAuthor(post,sessionAccountSeq)) {
			postMapper.postDelete(postSeq);
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,"인가받지 않은사용자");
		}
	}

	public PostVO postEditData(int postSeq, int sessionAccountSeq) {
		PostVO post = postMapper.findByPostSeq(postSeq);
		if (isAuthor(post,sessionAccountSeq)) {
			return post;
		}
		throw new ResponseStatusException(HttpStatus.FORBIDDEN,"인가받지 않은사용자");
	}

	public void postEdit(PostVO post) {
		postMapper.updatePost(post);
	}


	private boolean isAuthor(PostVO post, int sessionAccountSeq) {
		return post.getPostAuthor() == sessionAccountSeq;
	}
}
