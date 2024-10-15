import logo from './logo.svg';
import './App.css';
import {Routes, Route} from 'react-router-dom';
import Home from './Home';
import About from './About';
import Navbar from './Navbar';
import User from './User';
import UserProfile from './UserProfile';
import Dashboard from './Dashboard';
import Overview from './Overview';
import Settings from './Settings';
import NotFound from './NotFound';
import PrivateRoute from './PrivateRoute';
import Login from './Login';

function App() {

   //실제로 사용자 인증상태 확인해야 함 -> 주소창에 /login을 치면 로그인페이지로 이동함
   const isAuthenticated = false;

  return (
    <div className="App">
        <Routes>
          {/* path를 입력받았을 때 element를 실행하라는 의미 */}

          {/* <Route path="/" element={<Navbar/>}/>{/* : root경로에서 메뉴가 보이게 하기*/}
          {/* <Route path="/home" element={<Home/>}/>
          <Route path="/about" element={<About/>}/> */}

          {/* <Route path="/" element={<User/>}/>
          <Route path="/users/:id" element={<UserProfile/>}/> */}

          {/* <Route path="/dashboard/*" element={<Dashboard/>}/> */}
          
          {/* <Route path="/" element={<Home/>}/>
          <Route path="*" element={<NotFound/>}/> */}

          <Route path="/login" element={<Login />} />
          <Route
            path="/dashboard"
            element={<PrivateRoute element={<Dashboard />} isAuthenticated={isAuthenticated}/>}/>
          {/* : PrivateRoute 컴포넌트는 isAuthenticated가 true일 때는 자식 컴포넌트를 렌더링하고, 
          그렇지 않으면 로그인 페이지로 리다이렉트함 */}

        </Routes>
    </div>
  );

}

export default App;
