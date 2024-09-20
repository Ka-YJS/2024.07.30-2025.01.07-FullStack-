import React, { useState, useEffect } from 'react';
import axios from 'axios';

function BlogApp() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [newPost, setNewPost] = useState({ title: '', body: '' });

  //게시물 조회
  useEffect(() => {
    //비동기함수작성 : 
    const fetchPosts = async () => {
      try {
        //axios는 데이터를 가져와서 바로 json으로 만들어줌
        const response = await axios.get('https://jsonplaceholder.typicode.com/posts');
        setPosts(response.data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchPosts();
  }, []);

  // 새 게시물 추가하기
  const addPost = async () => {
    if (!newPost.title || !newPost.body) return alert('모든 필드를 입력해 주세요.');

    try {
      const response = await axios.post('https://jsonplaceholder.typicode.com/posts', newPost);
      setPosts([response.data, ...posts]);
      setNewPost({ title: '', body: '' });
    } catch (err) {
      setError(err.message);
    }
  };

  // 게시물 삭제하기
  const deletePost = async (id) => {
    try {
      await axios.delete(`https://jsonplaceholder.typicode.com/posts/${id}`);
      setPosts(posts.filter(post => post.id !== id));
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
        <h2>새 게시물 추가</h2>
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
        <h2>게시물 리스트</h2>
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