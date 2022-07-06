package kiti.buy.pmk.service;

import org.springframework.stereotype.Service;

import kiti.buy.pmk.dto.note.NoteCreateDTO;
import kiti.buy.pmk.mapper.AccountMapper;
import kiti.buy.pmk.mapper.NoteMapper;
import kiti.buy.pmk.vo.AccountVO;
import kiti.buy.pmk.vo.NoteVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteService {
	private final NoteMapper notemapper;
	private final AccountMapper accountMapper;
	
	public void sendNote(NoteCreateDTO dto, int senderSeq) {
		AccountVO recipientAccount =  accountMapper.findByAccountId(dto.getRecipientId());
		
		if (recipientAccount == null) {
			log.info("error = {}", senderSeq);
			return;
		}
		
		NoteVO note = NoteVO.builder()
		.noteTitle(dto.getTitle())
		.noteContent(dto.getContent())
		.noteSender(senderSeq)
		.noteRecipient(recipientAccount.getAccountSeq())
		.build();
		
		notemapper.writeNote(note);
	}
}
