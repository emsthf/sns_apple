import React from 'react';
import { Link } from 'react-router-dom';

function GridAS() {
   return ( 
      <>
         <div className="post-vertical-grid-a">
            <article className="post post--vertical">
               <div className="post-vertical-top">
                  <div className="post__thumb">"
                     <div className="background-img" ></div>
                     <Link className="link-overlay" to="single-1.html"></Link>
                  </div>
                  <div className="post__text">
                     <h3 className="post__title typescale-1">
                        <Link to="single-1.html">The Wisest Men Follow Their Own Direction</Link>
                     </h3>
                  </div>
               </div>
               <div className="post-meta">
                  <div className="author">
                     <Link to="author.html" className="author__avatar">
                     <img src="http://via.placeholder.com/40x40" alt="file not found"/>
                     </Link>
                     <div className="author__text">
                        <Link className="author__name" to="author.html">Adeline Eirene</Link>
                        <p className="">London</p>
                     </div>
                  </div>
               </div>
            </article>
         </div>
      </>
   );
}

export default GridAS;