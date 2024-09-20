import logo from './logo.svg';
import './App.css';
import { UserProvider } from './UserContext';
import Parent from './Parent';
import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import ThemeSwitcher from './ThemeSwitcher';
import { useContext } from 'react';


function App() {

  // const user = {name : 'John Doe', age : 30}
  const { isDarkMode } = useContext(ThemeContext);

  return (
    // <div className="App">
    //   {/* <UserProvider>
    //     <Parent />
    //   </UserProvider> */}
    // </div>

    <div
      style={{
        backgroundColor: isDarkMode ? '#333' : '#fff',
        color: isDarkMode ? '#fff' : '#000',
        height: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
      }}
    >
      <h1>{isDarkMode ? '다크 모드' : '라이트 모드'}</h1>
      <ThemeSwitcher />
    </div>


   
  );
}

export default App;
