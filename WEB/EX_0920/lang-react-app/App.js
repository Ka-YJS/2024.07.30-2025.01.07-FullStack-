import logo from './logo.svg';
import './App.css';
import { Routes, Route } from 'react-router-dom';
import Home from './Home';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/:lang/home" element={<Home />} /> 
      </Routes>
    </div>
  );
}

export default App;
