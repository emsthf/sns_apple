import React from 'react';
import { Link } from 'react-router-dom';

function PostMeta() {
   return ( 
      <div className="post-meta">
         <div className="meta__item">
            <p className="title">Date</p>
            <time className="time published"  title="August 20, 2016 at 08:53 am">jun 26, 2018</time>
         </div>
         <div className="meta__item entry-tags ">
            <p className="title">Tags</p>
            <ul className="social-list social-list--md list-horizontal">
               <li><Link to="tags.html">video</Link>
               </li>
               <li><Link to="tags.html">travel</Link>
               </li>
               <li><Link to="tags.html">fashion</Link>
               </li>
            </ul>
         </div>
      </div>
   );
}

export default PostMeta ;