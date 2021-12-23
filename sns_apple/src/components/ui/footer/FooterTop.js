import React from 'react';

function FooterTop() {
    return ( 
        <div className="site-footer__section ">
        <div className="container">
           <div className="row">
              <div className="col-md-8 col-sm-6">
                 <div className="site-footer-logo  max-width-sm">
                    <a href="home-1.html"><img src="img/logo_03.png" alt="file not found" /></a>
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
                             <input type="email" name="EMAIL"  placeholder="your email here" required="" />
                             <input type="submit" value="Subscribe" className="btn" />
                          </div>
                       </div>
                    </div>
                 </div>
              </div>
           </div>
        </div>
     </div>

     );
}

export default FooterTop;