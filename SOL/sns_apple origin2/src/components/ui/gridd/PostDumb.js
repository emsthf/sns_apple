import React from 'react';
import { Link } from 'react-router-dom';

function PostDumb () {
    return ( 
        <div className="post__thumb">
            <div className="background-img" ></div>
            <Link className="link-overlay" to="single-1.html"></Link>
        </div>
    );
}

export default PostDumb ;