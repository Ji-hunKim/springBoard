package project.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.board.service.BoardService;
import project.board.web.BoardForm;

import javax.validation.Valid;

@Controller
@RequestMapping("/board")
public class BoardController {


    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/write")
    public String addBoardForm(@ModelAttribute("boardForm") BoardForm boardForm){
        return "board/write";
    }

    @PostMapping("/write")
    public String saveBoard(@Valid@ModelAttribute("boardForm") BoardForm boardForm){
        boardService.saveBoard(boardForm.getWriter(),boardForm.getPwd(),boardForm.getEmail(),boardForm.getTitle(),boardForm.getContent());
        return "index";
    }
}
