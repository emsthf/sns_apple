import React from 'react';
import { Link } from 'react-router-dom';

function PostTextDay() {
   return ( 
      <div className="post__text">
         <div className="post-meta">
            <time className="time published" title="August 20, 2016 at 08:53 am">jun 26, 2018</time>
         </div>
         <h3 className="post__title typescale-1">
            <Link to="single-1.html">The Wisest Men Follow Their Own Direction</Link>
         </h3>
      </div>
   );
}

export default PostTextDay;