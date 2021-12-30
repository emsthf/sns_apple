import React from 'react';
import Title from '../ui/grid/Title';
import NextPage from '../ui/gridfull/NextPage';
import PostList from '../ui/gridfull/PostList';
import StickyBar from '../ui/gridfull/StickyBar';

function GridFull() {
    return ( 
<>
<div className="atbs-block atbs-block--fullwidth">
<div className="container">
   <div className="row">
      <div className="atbs-main-col">
         <div className="atbs-block atbs-posts-lists">
            <div className="posts-lists__inner">
              <Title />
               <div className="posts-lists__wrap">
                  <div className="post-vertical-lists-a">
                     <PostList />
                     <PostList />
                     <PostList />
                     <PostList />
                     <PostList />
                     <PostList />

                  </div>
               </div>
               <NextPage />
            </div>
         </div>
      </div>
      <StickyBar />
   </div>
</div>
</div>
</>
     );
}

export default GridFull;