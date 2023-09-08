package hello.itemservice.mapper;

import hello.itemservice.vo.BoardList;
import hello.itemservice.vo.SearchBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {

    /**
     *  게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<BoardList> getBoard() throws SQLException;

    /** 게시글 카운트
     * @return 총 게시글
     */
    int getBoardCount(SearchBoard searchBoard) throws SQLException;

    /** 게시글 작성
     * @return 성공 1 실패 0
     */
    Integer setWrite(BoardList boardList) throws SQLException;

    /** 게시글 수정
     * @return 성공 1 실패 0
     */
    Integer updateLetter(BoardList boardList) throws SQLException;

    /** 게시글 삭제
     * @return 성공 1 실패 0
     */
    Integer deleteLetter(BoardList boardList)throws SQLException;

}
