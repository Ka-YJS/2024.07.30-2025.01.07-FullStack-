import React from 'react';
import { Link } from 'react-router-dom';

/*각 유저의 프로필을 보러갈 수 있는 메뉴를 생성하는 컴포넌트*/

function User() {
  const users = [
    { id: 1, name: '홍길동' },
    { id: 2, name: '김길동' },
    { id: 3, name: '박길동' },
  ];

  return (
    <div>
      <h1>홈 페이지</h1>
      <ul>
        {users.map(user => ( 
          <li key={user.id}>
            <Link to={`/users/${user.id}`}>{user.name}의 프로필 보기</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default User;