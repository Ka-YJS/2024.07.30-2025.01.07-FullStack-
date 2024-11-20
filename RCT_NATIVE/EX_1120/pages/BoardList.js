//메인화면(게시글목록을 보여주고, 다른화면으로 이동이 가능함)

import React,{useState, useEffect, useContext} from "react";
import { BoardContext } from "../context/BoardContext";
import { Link, useNavigate } from "react-router-dom";
import '../css/BoardList.css'


const BoardList = () => {

    const navigate = useNavigate();

    //Context에서  boardList와 setBoardList를 가져옴
    const {boardList, setBoardList} = useContext(BoardContext);

    //현재페이지상태를 관리
    const [currentPage, setCurrentPage] = useState(1);

    //한 페이지당 보여줄 게시물 수 관리
    const [postsPerPage, setPostsPerPage] = useState(3);

    //전체페이지관리
    const [totalPages, setTotalPages] = useState(1);

    useEffect(() => {
        setBoardList(boardList);
        //총페이지 수 계산
        setTotalPages(Math.ceil(boardList.length/postsPerPage))
    }, [postsPerPage, boardList])

    //현재페이지에서 보여줄 게시글의 마지막 인덱스 계산
    const indexOfLastPost = currentPage * postsPerPage;

    //현재페이지에서 보여줄 게시글의 첫번째 인덱스계산
    const indexOfFirstPost = indexOfLastPost - postsPerPage;

    //현재페이지에서 보여줄 게시글만 slice로 추출
    const currentPosts = boardList.slice(indexOfFirstPost,indexOfLastPost);
    //ex. slice(0,3) -> 0에서 3미만

    //현재 페이지번호를 변경하는 함수
    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    const handleWritePost = () => {
        navigate('/write');
    }

    //parseInt : string을 정수로 변환한 값을 리턴함
    const handlePostPerPage = (e) => {
        setPostsPerPage(parseInt(e.target.value))
        setCurrentPage(1);
    }

    return(
        <div className="board-container">
            {/* 게시판 제목 */}
            <h1 className="board-title">게시판</h1>

            {/* 글쓰기 버튼 */}
            <div className="board-button">
                <button onClick={handleWritePost}>글쓰기</button>
            </div>
            <br/>
            {/* 게시글 목록 */}
            <ul className='board-posts'>
                {currentPosts.map((board) => (
                    <li key={board.id} className="board-post-item">
                        <Link to={`/post/${board.id}`}>{board.title}</Link>
                        <span>작성자: {board.author}</span>
                        <span> | 작성 시간: {board.writingTime}</span>
                    </li>
                ))}
            </ul>

            {/* 페이지당 게시물 수를 선택하는 드롭다운 */}
            <div className="board-posts-per-page">
                <label>
                    게시물 수:{" "}
                    <select value={postsPerPage} onChange={handlePostPerPage}>
                        <option value={3}>3개</option>
                        <option value={5}>5개</option>
                        <option value={10}>10개</option>
                    </select>
                </label>
            </div>

            {/* 페이지 목록 표시
                Arrays(totalPages) : 빈 배열 생성
                .keys() : 인덱스를 가지는 iterator객체를 반환받는다.
                [... ] : iterator를 배열로 변환한다.
            */}
            <div className="board-pagination">
                {[...Array(totalPages).keys()].map((number)=> (
                    <button
                        key={number+1}
                        className={currentPage === number + 1 ? "selected" : ""}
                        onClick={() => paginate(number+1)}
                    >{number+1}</button>
                ))}
            </div>
        </div>
    )
}

export default BoardList;