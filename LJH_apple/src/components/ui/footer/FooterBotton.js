import React from 'react';

function FooterBotton() {
    return (

        <div className="site-footer__section">
        <div className="site-footer__section-bottom">
           <div className="container">
              <div className="row">
                 <div className="col-sm-6 col-md-7 ">
                    <div className="Copyright">Takei © 2021. Made with ☕ by DesignUTD</div>
                 </div>
                 <div className="col-sm-6 col-md-5 ">
                    <div className="footer-bottom-follow">
                       <span>follow:</span>
                       <ul className="social-list social-list--sm  ">
                          <li><a href="#"><i className="mdicon mdicon-facebook"></i></a>
                          </li>
                          <li><a href="#"><i className="mdicon mdicon-twitter"></i></a>
                          </li>
                          <li><a href="#"><i className="mdicon mdicon-youtube"></i></a>
                          </li>
                       </ul>
                    </div>
                 </div>
              </div>
           </div>
        </div>
     </div>




      );
}

export default FooterBotton;