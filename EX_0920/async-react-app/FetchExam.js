import React, { useState, useEffect } from 'react';

function FetchExam() {
  const [posts, SetPosts] = useState([]);        // 데이터를 저장할 (state)
  const [loading, SetLoading] = useState(true);  // 로딩 상태 관리
  const [error, SetError] = useState(null);      // 에러 상태 관리

  useEffect(() => {//1. useEffect사용
    //2. 비동기적으로 데이터 호출
    const fetchData = async () => {
      try {
        //jsonplaxeholder로부터 얻어온 데이터를 response에 저장
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        /*
        -response의 객체
        -서버로부터 응답을 나타내는 객체
        -ok : HTTP상태코드가 200~299범위에 있을 경우 true, 그렇지 않으면 false
            ->HTTP상태코드 : 
        */
        if (!response.ok) {
          throw new Error('데이터를 불러오는데 실패했습니다.');
        }
        //받아온 데이터를 json으로 변환
        const data = await response.json();
        SetPosts(data);  //상태에 데이터를 저장
      } catch (err) {
        SetError(err.message);  //에러 처리
      } finally {
        SetLoading(false);  //로딩 상태를 완료로 설정
      }
    };

    fetchData();  // 함수 호출 -> 함수는 호출해야만 사용할 수 있음
  }, []);  // 컴포넌트가 처음 렌더링될 때 한 번만 실행

  //로딩중일 때 보여줄 내용
  if (loading) {
    return <p>로딩 중...</p>;
  }

  //에러 발생시 보여줄 내용
  if (error) {
    return <p>에러 발생: {error}</p>;
  }

  //데이터를 성공적으로 불러왔을 때 보여줄 내용
  return (
    <div>
      <h1>게시글 목록</h1>
      <ul>
      {/*posts.slice(0, 10)는 posts 배열에서 인덱스 0부터 9까지의 
        첫 10개의 게시글을 잘라내서 새로운 배열을 반환합니다.*/}
        {posts.slice(0, 10).map((post) => (  //첫 10개의 게시글만 출력
        /*()를 사용하면 암시적 반환 함수가 표현식의 결과를 자동으로 반환,
          이때, return 키워드를 적지않아도 됨*/
            <li key={post.id}>{post.title}</li>
        ))}
      </ul>
    </div>
  );
}

export default FetchExam;