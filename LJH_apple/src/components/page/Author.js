import React from 'react';
import GridD from '../layout/GridD';
import AuthorBox from '../ui/author/AuthorBox';
import NextPage from '../ui/gridfull/NextPage';
import PostList from '../ui/gridfull/PostList';
import StickyBar from '../ui/gridfull/StickyBar';

function Author() {
    return ( 
    
        <div className="site-content module-author">
            
            <div className="atbs-block atbs-block--fullwidth">
               <div className="container">
                  <div className="row">
                     <div className="atbs-main-col">
                        <AuthorBox />
                        <div className="atbs-block atbs-posts-lists">
                           <div className="posts-lists__inner">
                              <div className="posts-lists__wrap">
                                 <div className="post-vertical-lists-a">
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
           <GridD />
         </div>
        
     );
}

export default Author;