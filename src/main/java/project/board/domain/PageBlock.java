package project.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PageBlock {
    private int currentPage;               // 현재페이지
    private int numPerPage = 10;        // 한 페이지 출력 게시글 수
    private int numOfPageBlock = 10;    // 페이징 블럭 수
    private int startOfPageBlock = 1;      // 시작 번호    1 2 [3] 4 5 6 7 8 9 10 >
    private int endOfPageBlock ;           // 끝 번호
    private boolean prev, next;            // 이전 버트, 다음 버튼

    public PageBlock() {
        super();
    }

    public PageBlock(int currentPage, int numPerPage, int numOfPageBlock, int startOfPageBlock, int endOfPageBlock, boolean prev, boolean next) {
        this.currentPage = currentPage;
        this.numPerPage = numPerPage;
        this.numOfPageBlock = numOfPageBlock;
        this.startOfPageBlock = startOfPageBlock;
        this.endOfPageBlock = endOfPageBlock;
        this.prev = prev;
        this.next = next;
    }
}
