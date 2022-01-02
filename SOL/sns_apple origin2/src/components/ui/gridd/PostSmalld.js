import React from 'react';
import { Link } from 'react-router-dom';

function PostSmalld() {
   return (
      <div className="small-post-grid-d">
         <article className="post post--horizontal flexbox flexbox--middle">
            <div className="post__thumb">
               <div className="background-img" ></div>
               <Link className="link-overlay" to="single-1.html"></Link>
            </div>
            <div className="post__text flexbox__item">
               <h3 className="post__title takei-title typescale-2"><Link to="single-1.html">A Harmful Truth is Better Than a Useful Lie</Link></h3>
               <div className="post__excerpt">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiumod tempor incididunt ut labore.</div>
            </div>
         </article>
      </div>
   );
}

export default PostSmalld;