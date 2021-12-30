import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

import AuthorDetail from '../grid/AuthorDetail';


function GridListVt({postId}) {

    const [postData, setPost] = useState({})
    const [userId, setUserId] = useState(0)


    useEffect(()=>{

        const url = `http://localhost:3005/post/${postId}`
        axios.get(url)
        .then(Response=>{
            // console.log(Response.data)
            setPost(Response.data)
            setUserId(Response.data.userId)
        }) 
    },[postId])

    const imgUrl = {
        "backgroundImage" : "url('" +  postData.titleImage  + "')"
    }
    

    return ( 
        <div className="post-vertical__item col-md-3 col-sm-4">
            <article className="post post--vertical">
                {
                    userId ? 
                    <AuthorDetail 
                        userId = {userId}
                    />   
                    :
                    ""
                }
                                                                           
                <div className="post__thumb">
                    <div className="background-img" style={imgUrl}>
                    </div>
                    <Link to={`/single/${postId}`} className="link-overlay"></Link>
                </div>                         
                <div className="post__text">
                    <div className="post-meta">
                    <time className="time published" title="August 20, 2016 at 08:53 am">{postData.updated}</time>
                    </div>
                    <h3 className="post__title typescale-1">
                    <Link to={`/single/${postId}`}>{postData.postTitle}</Link>
                    </h3>
                </div>
            </article>
        </div>
     );
}

export default GridListVt;