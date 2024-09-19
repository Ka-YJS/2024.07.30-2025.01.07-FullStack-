import React from "react";
import { useParams } from "react-router-dom";

function UserProfile(){
    const {id} = useParams();

    const user = {//:실제로는 받아온 id값을 가지고 서버에 요청해서 데이터를 가져옴
        id,
        name: id === '1' ? '홍길동' : id === '2' ? '김길동' : '박길동',
        age: id === '1' ? 30 : id === '2' ? 45 : 38,
      };

    return (
        <div>
          <h2>{user.name}님의 프로필</h2>
          <p>사용자 ID: {user.id}</p>
          <p>나이: {user.age}</p>
        </div>
    );
}

export default UserProfile;