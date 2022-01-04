import React from 'react';
import { Link } from 'react-router-dom';

function MobileHeader () {
   return (
      <div id="atbs-mobile-header" className="takei-mobile-header visible-xs visible-sm">
         <div className="mobile-header__inner mobile-header__inner--flex">
            <div className="header-branding flexbox__item header-branding--mobile mobile-header__section flexbox text-left">
               <div className="button-head">
                  <Link to="" className="offcanvas-menu-toggle mobile-header-btn js-atbs-offcanvas-toggle">
                     <div className="button-head"></div>
                  </Link>
               </div>
               <div className=" flexbox__item text-left">
                  <div className="header-logo header-logo--mobile  text-left">
                     <Link to="">
                     <img src="img/logo_03.png" alt="logo" />
                     </Link>
                  </div>
               </div>
            </div>
            <div className=" flexbox__item mobile-header__section text-right">
               <div className="navigation-bar__section lwa lwa-template-modal">
                  <Link to="" className="navigation-bar__login-btn navigation-bar-btn" data-toggle="modal" data-target="#login-modal"><i className="mdicon mdicon-person"></i></Link>               
                  <button type="submit" className="navigation-bar-btn js-search-dropdown-toggle"><i className="mdicon mdicon-search"></i></button>
               </div>
            </div>
         </div>
      </div>
   );
}

export default MobileHeader;