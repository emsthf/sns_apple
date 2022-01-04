import React, { useRef } from 'react';
import { Link } from 'react-router-dom';

function FooterTop() {
   const emailRef = useRef();

   const handleSubmit = (e) => {
      e.preventDefault();
      console.log(" press submit btn");
   }

   return ( 
      <div className="site-footer__section ">
         <div className="container">
            <div className="row">
               <div className="col-md-8 col-sm-6">
                  <div className="site-footer-logo  max-width-sm">
                     <Link to="home-1.html"><img src="img/logo_03.png" alt="file not found" /></Link>
                  </div>
               </div>
               <div className="col-md-4 col-sm-6">
                  <div className="site-footer__section-right ">
                     <div className=" footer-subscribe">
                        <div className="subscribe__inner ">
                           <div className="subscriber-tile">
                              <h3>Get the freshest Chobani news</h3>
                           </div>
                           <form className="subscriber-form subscribe-form--horizontal max-width-sm" onSubmit={handleSubmit}>
                              <input type="email" name="EMAIL"  placeholder="your email here" required="" ref={emailRef} />
                              <button type="submit" value="Subscribe" className="btn">Subscribe</button>
                           </form>
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