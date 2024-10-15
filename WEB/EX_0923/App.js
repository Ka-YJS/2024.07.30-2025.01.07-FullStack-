import logo from './logo.svg';
import './App.css';
/*
//Redux와 React를 연결하는 데 필요한 Provider, useDispatch, useSelector를 가져옴
import React from 'react';
import { Provider, useDispatch, useSelector } from 'react-redux';

//Redux 스토어를 가져옴. 이 스토어는 전역 상태를 관리함
import store from './redux/store';
*/

/*increment와 decrement 액션 생성 함수(action creator)를 import
-> 아래함수들은 상태를 변경하는 액션을 디스패치하기 위해 사용됨*/
//import { increment, decrement } from './redux/action';

//--------------------------------------------------------------import_redux

/*
import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addTodo, removeTodo } from './todo/actions';
*/

//--------------------------------------------------------------import_todo

import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { login, logout } from './login/action';

//--------------------------------------------------------------import_login

// function Counter() {

//   /*useSelector: Redux에서 store에 저장되어있는 상태를 읽어오는 Hook
//     ->스토어의 상태 중 count 값을 선택해서 가져옴*/
//     const count = useSelector((state) => state.count);
  
//     /*useDispatch: store에 액션을 보낼 수 있는 Hook
//      ->이 Hook을 사용해 액션을 디스패치할 수 있음*/
//     const dispatch = useDispatch();
  
//     return (
//       <div>
//         {/* 현재 state인 count 값을 화면에 출력함 */}
//         <h1>Counter: {count}</h1>
        
//         {/* Increment 버튼을 클릭하면 increment 액션을 디스패치함 */}
//         <button onClick={() => dispatch(increment())}>Increment</button>
  
//         {/* Decrement 버튼을 클릭하면 decrement 액션을 디스패치함 */}
//         <button onClick={() => dispatch(decrement())}>Decrement</button>
//       </div>
//     );
//}
  

/*
function App() {
  return (
    //Provider: store를 애플리케이션 전체에 제공함
    //Provider 안에 있는 모든 컴포넌트는 Redux 스토어에 접근할 수 있음
    <Provider store={store}>
      <Counter />
    </Provider>
  )
}
export default App;*/

//--------------------------------------------------------------


/*
function App() {
  const [input, setInput] = useState(''); //입력값을 관리하는 로컬 state
  const todos = useSelector((state) => state.todos); //Redux에서 todos state를 가져옴
  const dispatch = useDispatch(); // 액션을 디스패치하는 함수 가져오기

  //추가버튼 눌렀을 때 input태그에 있는 내용을 배열에 추가하기

  const handleAddTodo = () => {
    if (input.trim()) {//input태그에 값이 비었는지 검사
      dispatch(addTodo(Date.now(), input)); //새로운 Todo를 추가 (id는 현재 시간으로 고유값 생성)
      //+id와 내용을 액션에 전송해서 reducer에 추가
      setInput(''); //입력창 비우기
    }
  };

  const handleRemoveTodo = (id) => {
    dispatch(removeTodo(id)); //Todo를 삭제
  };

  return (
    <div>
      <h1>Todo List</h1>
      <input
        type="text"
        value={input}
        onChange={(e) => setInput(e.target.value)}
        placeholder="Add a new todo"
      />
      <button onClick={handleAddTodo}>Add Todo</button>

      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>
            {todo.text} 
            <button onClick={() => handleRemoveTodo(todo.id)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;

*/

//--------------------------------------------------------------

function AuthApp() {
  const [usernameInput, setUsernameInput] = useState(''); // 입력 필드 상태
  const { isLoggedIn, username } = useSelector((state) => state); // Redux 상태에서 로그인 정보 가져오기
  const dispatch = useDispatch(); // 액션을 디스패치하기 위한 훅

  const handleLogin = () => {
    if (usernameInput.trim()) {
      dispatch(login(usernameInput)); // 로그인 액션 디스패치
      setUsernameInput(''); // 입력 필드 초기화
    }
  };

  const handleLogout = () => {
    dispatch(logout()); // 로그아웃 액션 디스패치
  };

  return (
    <div>
      <h1>Login Status</h1>
      {isLoggedIn ? (
        <div>
          <p>Welcome, {username}!</p>
          <button onClick={handleLogout}>Logout</button>
        </div>
      ) : (
        <div>
          <input
            type="text"
            value={usernameInput}
            onChange={(e) => setUsernameInput(e.target.value)}
            placeholder="Enter your username"
          />
          <button onClick={handleLogin}>Login</button>
        </div>
      )}
    </div>
  );
}

export default AuthApp;
