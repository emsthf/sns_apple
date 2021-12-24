import React from 'react';
import PostText from '../ui/grid/PostText';
import Title from '../ui/grid/Title';
import GridADumb from '../ui/grida/GridADumb';
import TextDay from '../ui/gridc/TextDay';

function GridC() {
    return ( 
<>
        <div className="atbs-block atbs-block--fullwidth atbs-post-grid-c">
        <div className="container">
           <div className="post-grid-c__inner">
             <Title />
              <div className="row post-grid-c__wrap">
                 <div className="col-lg-3 col-md-4 col-sm-5">
                    <div className="post-vertical-grid-c">
                       <article className="post post--vertical">
                          <GridADumb />
                          <PostText />
                       </article>
                    </div>
                 </div>
                 <div className="col-lg-9 col-md-8 col-sm-7">
                    <div className="post-main-grid-c">
                       <article className="post post-main">
                          <div className="post__text clearfix">
                             <div className="post__text--left">
                                <a href="category-1.html" className="post__cat takei-cat">Travel</a>
                                <h3 className="post__title typescale-3 takei-title">
                                   <a href="single-1.html">A Loving Heart Is the Truest Wisdom</a>
                                </h3>
                             </div>
                             <div className="post__text--right">
                                <div className="post__excerpt">
                                   Quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore.
                                </div>
                             </div>
                          </div>
                          <GridADumb />
                       </article>
                    </div>
                    <div className="post-horizontal-list-c">
                       <div className="row post-horizontal-list-nothumbnail">
                            <TextDay />
                            <TextDay />
                            <TextDay />
                        </div>
                    </div>
                 </div>
              </div>
           </div>
        </div>
     </div>


</>
     );
}

export default GridC;