import React from 'react';
import { Link } from 'react-router-dom';


function GridAM() {
    return ( 

        <div className="post-overlay-grid-a">
        <article className="post post--overlay">
           <div className="post__thumb">
              <div className="background-img" ></div>
              <Link className="link-overlay" href="single-1.html"></Link>
           </div>
           <div className="post__text">
              <h3 className="post__title typescale-1">
                 <Link href="single-1.html">A Loving Heart is The Truest Wisdom</Link>
              </h3>
           </div>
        </article>
     </div>

     );
}

export default GridAM;