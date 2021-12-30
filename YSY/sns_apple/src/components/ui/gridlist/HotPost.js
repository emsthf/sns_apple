import React, {useState,useEffect} from 'react';
import { Link } from 'react-router-dom';
import AuthorDetail from '../grid/AuthorDetail';
import axios from 'axios';

function HotPost({postId}) {

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


    return ( 
        <div className="post-vertical__item post-nothumbnail col-md-3 col-sm-12">
            <article className="post post--vertical">
                <div className="post-text__wrap">
                    {
                        userId ? 
                        <AuthorDetail 
                            userId = {userId}
                        />
                        :
                        ""
                    }
                    
                    <div className="post__text">
                        <h3 className="post__title takei-title typescale-3">
                        <Link to= {`/single/${postId}`}>{postData.postTitle}</Link>
                        </h3>
                    </div>
                </div>
            </article>
        </div>
     );
}

export default HotPost;