package project.board.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.board.domain.Board;
import project.board.domain.Boardd;
import project.board.service.BoardService;
import project.board.web.BoardForm;

import javax.validation.Valid;
import java.util.List;

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
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String showBoardList(@RequestParam(required = false) Integer currentpage, Model model){

        if(currentpage == null) currentpage = 1;

        int numPerPage = 10;
        List<Boardd> boardList = null;
        boardList = boardService.getBoardList(currentpage, numPerPage);
        model.addAttribute("boardList",boardList);
        return "board/list";
    }

    @GetMapping("/view")
    public String viewBoard(@RequestParam Long seq, Model model) {
        Board board = boardService.getBoard(seq);
        model.addAttribute("board", board);
        return "board/view";
    }

    @PostMapping("/delete")
    public String deleteBoard(@RequestParam("seq") Long seq, @RequestParam("pwd") String pwd){
        String isSuccess = boardService.deleteBoard(seq, pwd);
        return "redirect:/board/list?delete="+isSuccess;
    }

    @GetMapping("/edit")
    public String addEditForm(@RequestParam Long seq, Model model) {
        Board board = boardService.getBoard(seq);
        model.addAttribute("board", board);
        return "board/edit";
    }

    @PostMapping("/edit")
    public String editBoard(@Valid@ModelAttribute("boardForm") BoardForm boardForm, @RequestParam("seq") Long seq ){
        boardService.editBoard(seq, boardForm.getWriter(), boardForm.getPwd(), boardForm.getEmail(),
                boardForm.getTitle(), boardForm.getContent());
        return "redirect:/board/list";
    }
}
