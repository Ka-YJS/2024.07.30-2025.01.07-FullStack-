import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import MultiButtons from './MultiButtons';
import BookSearch from './api/Booksearch';
import Address from './api/Address';
import NewsSearch from './api/Newssearch';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MultiButtons/>}/>
          <Route path="/address" element={<Address/>}/>
          <Route path="/search" element={<BookSearch/>}/>
          <Route path="/newsSearch" element={<NewsSearch/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
