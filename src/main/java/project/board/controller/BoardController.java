package project.board.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.board.domain.Board;
import project.board.domain.Boardd;
import project.board.domain.PageBlock;
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
    public String showBoardList(@RequestParam(required = false) Integer currentpage, @RequestParam(required = false) Integer searchCondition,
                                @RequestParam(required = false) String searchWord,  Model model){

        if(currentpage == null) currentpage = 1;

        int numPerPage = 10;      // 한페이지에 출력할 게시글
        int numOfPageBlock = 10;  // 페이징 블럭수

        if(searchCondition == null) searchCondition = 1;
        if(searchWord == null) searchWord = "";


        List<Boardd> boardList = null;
        PageBlock pageBlock = null;

        boardList = boardService.getBoardList(currentpage, numPerPage, searchCondition, searchWord);
        pageBlock = boardService.pagingService(currentpage, numPerPage, numOfPageBlock, searchCondition, searchWord);

        model.addAttribute("boardList",boardList);
        model.addAttribute("pageBlock", pageBlock);
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
