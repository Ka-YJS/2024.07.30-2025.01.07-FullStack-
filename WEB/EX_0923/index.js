/*

import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux'; //Redux 스토어를 React 애플리케이션에 연결하기 위해 사용
import store from './todo/store'; //Redux 스토어 불러오기
import App from './App'; //TodoApp 컴포넌트 불러오기
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Provider store={store}> 
    <App />
  </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

*/

//--------------------------------------------------------------import_todo

//--------------------------------------------------------------import_login

import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux'; //Redux 스토어를 React 앱에 연결하기 위해 사용
import store from './login/store'; //Redux 스토어 불러오기
import AuthApp from './App'; //AuthApp 컴포넌트 불러오기
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <Provider store={store}> 
    <AuthApp />
  </Provider>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();