import React from 'react';


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
                                <li><a href="tags.html">video</a>
                                </li>
                                <li><a href="tags.html">travel</a>
                                </li>
                                <li><a href="tags.html">fashion</a>
                                </li>
                             </ul>
                          </div>
                       </div>



     );
}

export default PostMeta ;