import React, {useState} from "react";
import axios from "axios";


function NewsSearch(){

    const [query, setQuery] = useState('');
    const [result, setResult] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const searchNews = () => {

        try {
            const response = axios.get('http://localhost:9090/api/news',{
                params: {query}                    
                });
                
                response.then(res => setResult(res.data.items));

            setResult(response.data.items);
        } catch (error) {
            setError('존재하지않는 뉴스입니다.')
        }
    }

    const handleSearch = (e) => {
        if(!query){
            alert('검색어를 입력하세요.')
            return;
        }
        e.preventDefault();
        searchNews();
    }

    return(
        <div>
            <h1>네이버 뉴스 검색</h1>
            <form onSubmit={handleSearch}>
                <input type="text" value={query} onChange={(e) => setQuery(e.target.value)}
                    placeholder="뉴스제목을 입력하세요."/>
                <button type="submit">검색</button>
            </form>

            <ul>
                {result.map((news) => (
                    <li key={news.isbn}>
                        <img src={news.image} alt={news.title} />
                        <p>제목 : {news.title}</p>
                        <p>원문 : {news.originallink}</p>
                        <p>네이버기사 : {news.link}</p>
                        <p>내용 : {news.description}</p>
                        <p>날짜 : {news.pubDate}</p>
                        <a href={news.link} target="_blank" rel="noopener noreferrer">더보기</a>
                    </li>
                ))}
            </ul>
        </div>

    );

}

export default NewsSearch;