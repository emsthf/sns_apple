import React from "react";
import { Link } from "react-router-dom";
import logo from "../../img/logo_03.png";

function Header() {
  return (
    <header className="site-header">
      <div className="container">
        <div className="row">
          <div
            id="atbs-mobile-header"
            className="takei-mobile-header visible-xs visible-sm"
          >
            <div className="mobile-header__inner mobile-header__inner--flex">
              <div className="header-branding flexbox__item header-branding--mobile mobile-header__section flexbox text-left">
                <div className="button-head">
                  <Link
                    to=""
                    className="offcanvas-menu-toggle mobile-header-btn js-atbs-offcanvas-toggle"
                  >
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
                  <Link
                    to=""
                    className="navigation-bar__login-btn navigation-bar-btn"
                    data-toggle="modal"
                    data-target="#login-modal"
                  >
                    <i className="mdicon mdicon-person"></i>
                  </Link>
                  <button
                    type="submit"
                    className="navigation-bar-btn js-search-dropdown-toggle"
                  >
                    <i className="mdicon mdicon-search"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>
          <nav className="navigation-bar navigation-bar--fullwidth hidden-xs hidden-sm js-sticky-header-holder">
            <div className="container">
              <div className="navigation-bar__inner">
                <div className="navigation-bar__section">
                  <div className="header-branding header-branding--mobile mobile-header__section text-left">
                    <div className="header-logo header-logo--mobile flexbox__item text-left">
                      <Link to="/">
                        <img src={logo} alt="logo" />
                      </Link>
                    </div>
                  </div>
                </div>
                <div className="navigation-wrapper navigation-bar__section js-priority-nav text-left">
                  <ul
                    id="menu-main-menu-1"
                    className="navigation navigation--main navigation--inline navigation--main-menu"
                  >
                    <li className=" menu-item-cat-1 navigation__active menu-item-has-children">
                      <Link to="/">Home</Link>
                      <ul className="sub-menu">
                        <li>
                          <Link to="/">home-1</Link>
                        </li>
                        <li>
                          <Link to="/">home-2</Link>
                        </li>
                        <li>
                          <Link to="/">home-3</Link>
                        </li>
                      </ul>
                    </li>
                    <li className="menu-item-cat-1 menu-item-has-children">
                      <Link to="/">Single</Link>
                      <ul className="sub-menu">
                        <li>
                          <Link to="/">single-1</Link>
                        </li>
                        <li>
                          <Link to="/">single-2</Link>
                        </li>
                      </ul>
                    </li>
                    <li className="menu-item-cat-1 menu-item-has-children">
                      <Link to="/">Archive</Link>
                      <ul className="sub-menu">
                        <li className="menu-item-has-children">
                          <Link to="/">Category</Link>
                          <ul className="sub-menu">
                            <li>
                              <Link to="/">category-1</Link>
                            </li>
                            <li>
                              <Link to="/">category-2</Link>
                            </li>
                            <li>
                              <Link to="/">category-3</Link>
                            </li>
                          </ul>
                        </li>
                        <li>
                          <Link to="/">Arcihve Tags</Link>
                        </li>
                        <li>
                          <Link to="/">Author</Link>
                        </li>
                      </ul>
                    </li>
                    <li className="menu-item-cat-1 menu-item-has-children">
                      <Link to="/">Page</Link>
                      <ul className="sub-menu">
                        <li>
                          <Link to="/">Page</Link>
                        </li>
                        <li>
                          <Link to="/">Page No Sidebar</Link>
                        </li>
                        <li>
                          <Link to="/">Search</Link>
                        </li>
                        <li>
                          <Link to="/">Typography</Link>
                        </li>
                        <li>
                          <Link to="/">404</Link>
                        </li>
                      </ul>
                    </li>
                    <li className="menu-item-cat-1">
                      <Link to="/">contact</Link>
                    </li>
                  </ul>
                </div>
                <div className="navigation-bar__section ">
                  <div className="navigation-bar__section lwa lwa-template-modal">
                    <Link
                      to="/"
                      className="navigation-bar__login-btn navigation-bar-btn"
                      data-toggle="modal"
                      data-target="#login-modal"
                    >
                      <i className="mdicon mdicon-person"></i>
                    </Link>
                    <button
                      type="submit"
                      className="navigation-bar-btn js-search-dropdown-toggle"
                    >
                      <i className="mdicon mdicon-search"></i>
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </nav>
        </div>
      </div>
    </header>
  );
}

export default Header;
