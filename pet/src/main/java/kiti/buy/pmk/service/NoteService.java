package kiti.buy.pmk.service;

import kiti.buy.pmk.dto.note.NoteCreateDTO;
import kiti.buy.pmk.dto.note.NoteResultDTO;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.mapper.NoteMapper;
import kiti.buy.pmk.vo.AccountVO;
import kiti.buy.pmk.vo.NoteVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NoteService {
	private final NoteMapper notemapper;
	private final AccountMapper accountMapper;
	
	public void sendNote(NoteCreateDTO dto, int senderSeq) {
		AccountVO recipientAccount =  accountMapper.findByAccountId(dto.getRecipientId());
		
		if (recipientAccount == null) {
			log.info("error = {}", senderSeq);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다");
		}
		
		NoteVO note = NoteVO.builder()
		.noteTitle(dto.getTitle())
		.noteContent(dto.getContent())
		.noteSender(senderSeq)
		.noteRecipient(recipientAccount.getAccountSeq())
		.build();
		
		notemapper.writeNote(note);
	}

	public List<NoteResultDTO> findAllSendNote(int seq) {
		return notemapper.findAllNote(seq);
	}
}
