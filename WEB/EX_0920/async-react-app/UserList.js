import React, { useState, useEffect } from 'react';

function UserList() {
  const [users, setUsers] = useState([]);        //유저정보를 담기위한 state
  const [loading, setLoading] = useState(true);  // 로딩 상태를 관리하기위한 state
  const [error, setError] = useState(null);      // 에러 상태를 관리하기위한 state

  useEffect(() => {//fetch를 사용하기 위해 useEffect를 사용함
    //비동기 함수 정의 : 
    const fetchUsers = async () => {
      try {
        const response = await fetch('https://jsonplaceholder.typicode.com/users');
        if (!response.ok) {
          throw new Error('데이터를 불러오는데 실패했습니다.');
        }
        const data = await response.json();
        setUsers(data);  //데이터를 useState에 저장
      } catch (err) {
        setError(err.message);  //에러 처리
      } finally {
        setLoading(false);  //로딩 상태를 완료로 설정
      }
    };
    
  /*useEffect 안에서 fetchUsers()를 호출하는 이유 : 
    -> useEffect 훅이 비동기 함수를 직접적으로 지원하지 않기 때문임*/
    fetchUsers(); // API 호출
  }, []);

  //로딩중일 때 표시할 UI
  if (loading) {
    return <p>로딩 중...</p>;
  }

  //에러가 발생했을 때 표시할 UI
  if (error) {//error값에는 null 혹은 message가 들어감
    return <p>에러 발생: {error}</p>;
  }

  //데이터를 성공적으로 불러왔을 때 표시할 UI
  return (
    <div>
      <h1>사용자 목록</h1>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.name} - {user.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserList;