import React from 'react';
import AuthorDetail from '../grid/AuthorDetail';
import FullDumb from './FullDumb';
import FullText from './FullText';
import Tags from './Tags';


function PostList() {
    return (  

<div className="post-vertical-style-a post-list-takei">
    <article className="post post--vertical">
        <div className="post-top clearfix flexbox flexbox--middle">
            <AuthorDetail />            
            <Tags />
        </div>
         <FullDumb />
         <FullText />
    </article>
</div>



    );
}

export default PostList ;