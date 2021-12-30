import React from 'react';
import MobileHeader from '../ui/header/MobileHeader.js';
import Nav from '../ui/header/Nav';

function Header() {
    return ( 
        <header className="site-header">
            
            <div className="container">
               <div className="row">
                  <MobileHeader />
                  <Nav />
               </div>
            </div>
         </header>
     );
}

export default Header;