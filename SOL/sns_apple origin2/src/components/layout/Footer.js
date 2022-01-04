import React from "react";
import { Link } from "react-router-dom";

import FooterTop from "../ui/footer/FooterTop";

function Footer() {
  return (
    <footer className="site-footer ">
      <FooterTop />
      <div className="site-footer__section">
        <div className="site-footer__section-bottom">
          <div className="container">
            <div className="row">
              <div className="col-sm-6 col-md-7 ">
                <div className="Copyright">
                  Takei © 2021. Made with ☕ by DesignUTD
                </div>
              </div>
              <div className="col-sm-6 col-md-5 ">
                <div className="footer-bottom-follow">
                  <span>follow:</span>
                  <ul className="social-list social-list--sm  ">
                    <li>
                      <Link to="/">
                        <i className="mdicon mdicon-facebook"></i>
                      </Link>
                    </li>
                    <li>
                      <Link to="/">
                        <i className="mdicon mdicon-twitter"></i>
                      </Link>
                    </li>
                    <li>
                      <Link to="/">
                        <i className="mdicon mdicon-youtube"></i>
                      </Link>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
