import React from 'react';
import Title from '../ui/grid/Title';
import PostDumb from '../ui/gridd/PostDumb';
import PostMeta from '../ui/gridd/PostMeta';
import PostSmalld from '../ui/gridd/PostSmalld';
import PostTextd from '../ui/gridd/PostTextd';


function GridD() {
    return ( 

 <>       
        <div className="atbs-block atbs-block--fullwidth atbs-post-grid-d">
        <div className="container">
           <div className="post-grid-d__inner">
               <Title />
              <div className="post-grid-d__wrap">
                 <div className="big-post-grid-d">
                    <article className="post post--horizontal post--horizontal-sm">
                       <PostMeta />
                       <PostDumb />
                        <PostTextd />
                    </article>
                 </div>
                  <PostSmalld />
              </div>
           </div>
        </div>
     </div>
</>

     );
}

export default GridD;