import React from 'react';
import { Link } from 'react-router-dom';



function StickyMiddlePost({post}) {
 
   // 받아온 포스트 정보 {post}
    return ( 
      
   <li className="widget-post-horizontal">
        <article className="post post--horizontal  post--horizontal-xxs post--horizontal-middle cat-1">
           <div className="post__thumb">
              <Link to={`/single/${post.userId}`}>
              <img src={`../.${post.titleImage}`} alt={post.postTitle}/>
              </Link>
           </div>
           <div className="post__text">
              <div className="post__meta">
                 <time className="time published" title="August 20, 2016 at 08:53 am">{post.updated}</time>
              </div>
              <h3 className="post__title typescale-1 "><Link to={`/single/${post.userId}`}>{post.postTitle}</Link></h3>
           </div>
        </article>
   </li>

     );
}

export default StickyMiddlePost;