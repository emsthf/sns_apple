import React, { useEffect, useState } from 'react';

function PostListInMain({postData}) {
    const [post, setPost] = useState(postData)

    useEffect(()=>{
        
        console.log(post)
    })
    
    return (  

        <div className="post__thumb">
            
            <div className="background-img" style ={{  }} ></div>
            <a className="link-overlay" href="single-1.html"></a>
        </div>

    );
}

export default PostListInMain;