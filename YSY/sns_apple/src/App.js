import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './components/page/Home';
import Footer from './components/layout/Footer';
import Author from './components/page/Author';
import Header from './components/layout/Header';
import Single from './components/page/Single';

// css import

import  './css/vendors.css';
import  './css/basic.css';
import  './css/takei.css';
import  './css/single.css';
import  './css/gallery.css';
import  './css/404.css';
import  './css/font.css';
import  './css/color.css';
import TopTo from './components/TopTo';

function App() {
  return (
   
    <div className="site-wrapper ">
      
      <BrowserRouter>
      <TopTo/>
      <Header /> 
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/author" element={<Author />} />
          <Route path="/single/:id" element={<Single />} />
        </Routes>
      <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
