import React from "react";
import { Link } from "react-router-dom";

function Footer() {
  return (
    <footer className="site-footer ">
      <div className="site-footer__section ">
        <div className="container">
          <div className="row">
            <div className="col-md-8 col-sm-6">
              <div className="site-footer-logo  max-width-sm">
                <Link to="home-1.html">
                  <img src="img/logo_03.png" alt="file not found" />
                </Link>
              </div>
            </div>
            <div className="col-md-4 col-sm-6">
              <div className="site-footer__section-right ">
                <div className=" footer-subscribe">
                  <div className="subscribe__inner ">
                    <div className="subscriber-tile">
                      <h3>Get the freshest Chobani news</h3>
                    </div>
                    <div className="subscriber-form subscribe-form--horizontal max-width-sm">
                      <input
                        type="email"
                        name="EMAIL"
                        placeholder="your email here"
                        required=""
                      />
                      <input type="submit" value="Subscribe" className="btn" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
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
                      <Link to="#">
                        <i className="mdicon mdicon-facebook"></i>
                      </Link>
                    </li>
                    <li>
                      <Link to="#">
                        <i className="mdicon mdicon-twitter"></i>
                      </Link>
                    </li>
                    <li>
                      <Link to="#">
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
