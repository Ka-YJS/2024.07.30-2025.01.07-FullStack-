import React, { useState, useEffect } from 'react';
import axios from 'axios';

function BlogApp() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [newPost, setNewPost] = useState({ title: '', body: '' });
  //제목이랑 내용을 입력할 수 있게 해줌

  //게시물 조회 : 렌더링될 때 무조건 한번은 실행, 서버로가서 select
  useEffect(() => {
    //비동기함수작성 : 
    const fetchPosts = async () => {
      try {
        //axios는 데이터를 가져와서 바로 json으로 만들어줌
        const response = await axios.get('https://jsonplaceholder.typicode.com/posts');
        setPosts(response.data);
        //비동기통신을 하고 얻은 데이터를 받으려면 변수명.data를 사용함
        console.log(response.data);
        setPosts(response.data);//posts state에 데이터가 저장됨
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchPosts();
  }, []);

  /*데이터 추가 : 서버에 데이터를 추가하여 새로고침해도 추가된 데이터가 유지되도록해보기
                -> 디비로가서 insert하기*/
  const addPost = async () => {
    if (!newPost.title || !newPost.body) return alert('모든 필드를 입력해 주세요.');
    //->유효성검사, newPost.title는 빈값이므로 false 이고, !를 사용하므로 true || true값을 나타냄

    try {
      /*조회할 때 HTTP메서드는 GET, 추가할 때 HTTP메서드는 POST를 사용함
      형식 : const response = await axios.post('보내줄 주소',보낼데이터)*/
      const response = await axios.post('https://jsonplaceholder.typicode.com/posts', newPost);
      setPosts([response.data, ...posts]);//:재 렌더링이 되어서 추가된 내용이 보임
      //->기존데이터(...posts)에 새데이터배열(response.data)을 추가하겠음
      setNewPost({ title: '', body: '' });//:input태그와 textarea의 내용을 비워줘야 함
    } catch (err) {
      setError(err.message);
    }
  };

  /*데이터 삭제하기 : 디비로가서 delete하기
    형식 : await axios.delete(`요청경로`);*/
  const deletePost = async (id) => {//:삭제 후 돌려주는 data는 없음 -> data : {}
    try {
      await axios.delete(`https://jsonplaceholder.typicode.com/posts/${id}`);
      setPosts(posts.filter(post => post.id !== id));//:내가 삭제한 게시글 빼고 다시 조회
    } catch (err) {
      setError(err.message);
    }
  };

  if (loading) return <p>Loading posts...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div className="App">
      <h1>블로그 게시물</h1>
      {/* 새 게시물 추가하기 */}
      <div>
        <h1>새 게시물 추가</h1>
        <input
          type="text"
          placeholder="제목"
          value={newPost.title}
          onChange={(e) => setNewPost({ ...newPost, title: e.target.value })}
        />
        <textarea
          placeholder="내용"
          value={newPost.body}
          onChange={(e) => setNewPost({ ...newPost, body: e.target.value })}
        />
        <button onClick={addPost}>게시물 추가</button>
      </div>

      {/* 게시물 리스트 */}
      <div>
        <h1>게시물 리스트</h1>
      {/* posts state에 저장되어 있는 내용을 하나씩 꺼내서 화면에 렌더링 */}
        {posts.map(post => (
          <div key={post.id} style={{ border: '1px solid black', margin: '10px', padding: '10px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
            <button onClick={() => deletePost(post.id)}>삭제</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default BlogApp;