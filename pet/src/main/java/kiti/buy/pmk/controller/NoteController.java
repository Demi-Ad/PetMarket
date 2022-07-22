package kiti.buy.pmk.controller;

import kiti.buy.pmk.dto.note.NoteCreateDTO;
import kiti.buy.pmk.service.NoteService;
import kiti.buy.pmk.vo.SessionDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NoteController {
    private final NoteService noteService;

    @PostMapping("/noteCreate")
    public HttpEntity<?> createNote(@RequestBody NoteCreateDTO note, @SessionAttribute SessionDetail sessionDetail) {
        noteService.sendNote(note,sessionDetail.getAccountSeq());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/noteShow")
    public HttpEntity<?> showNote(@RequestParam int accountSeq, @SessionAttribute SessionDetail sessionDetail) {
        if (accountSeq == sessionDetail.getAccountSeq()) {
            return ResponseEntity.ok(noteService.findAllSendNote(accountSeq));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @ExceptionHandler(ResponseStatusException.class)
    public HttpEntity<?> exceptionHandler(ResponseStatusException e) {
        Map<String,Object> map = new HashMap<>();
        HttpStatus status = e.getStatus();
        map.put("status",status.value());
        map.put("reason",e.getMessage());
        return ResponseEntity.badRequest().body(map);
    }
}
