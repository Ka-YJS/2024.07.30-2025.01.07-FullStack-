import React, {useState} from "react";
import axios from "axios";


function BookSearch(){

    const [query, setQuery] = useState('');//검색어 state
    const [result, setResult] = useState([]);//검색 결과 state
    const [loading, setLoading] = useState(false);//로딩상태
    const [error, setError] = useState(null);

    //네이버 도서 검색 API 호출 함수
    const searchBooks = () => {
        // const clientId = 'wnrwOzpxrDwnsfKRNcEo';
        // const clientSecret = 'EFJ6LEQMco';

        try {
            const response = axios.get('http://localhost:9090/api/books',{
            //이전입력내용: https://openapi.naver.com/v1/search/book.json
                params: {query}                    
                    // headers: {
                    //     'X-Naver-Client-Id' : clientId,
                    //     'X-Naver-Client-Secret' : clientSecret,
                    // }
                });
                
                response.then(res => setResult(res.data.items));

            //검색결과를 result상태에 저장
            setResult(response.data.items);
        } catch (error) {
            setError('도서 검색에 실패했습니다.')
        }
    }

    //검색버튼 클릭 시 호출함
    const handleSearch = (e) => {
        if(!query){
            alert('검색어를 입력하세요.')
            return;
        }
        e.preventDefault();//새로고침을 강제로 막음
        searchBooks();
    }

    return(
        <div>
            <h1>네이버 도서 검색</h1>
            <form onSubmit={handleSearch}>
                <input type="text" value={query} onChange={(e) => setQuery(e.target.value)}
                    placeholder="책 이름을 입력하세요."/>
                <button type="submit">검색</button>
            </form>

            <ul>
                {result.map((book) => (
                    <li key={book.isbn}>
                        <img src={book.image} alt={book.title} />
                        <p>제목 : {book.title}</p>
                        <p>저자 : {book.author}</p>
                        <p>출판사 : {book.publisher}</p>
                        <p>가격 : {book.discount?`${book.discount}원` : '가격정보없음'}</p>
                        <a href={book.link} target="_blank" rel="noopener noreferrer">더보기</a>
                        {/* target : 새탭에서 열겠다, rel + no~ : 어디서 왔는지 숨기겠다 */}
                    </li>
                ))}
            </ul>
        </div>

    );

}

export default BookSearch;