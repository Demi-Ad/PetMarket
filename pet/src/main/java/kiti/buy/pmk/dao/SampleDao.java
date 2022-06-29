package kiti.buy.pmk.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class SampleDao {
	private final SqlSessionTemplate template;
	
	
	public String sample() {
		return template.selectOne("sample.now");
	}
}
