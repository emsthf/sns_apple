import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router';
import axios from 'axios';

import RespondCommnet from './RespondComment';

function Comment() {

    const { id } = useParams()
    const url = `http://localhost:3007/comment?postid=${id}`
    const [comments,setComments]=useState([])
    
    useEffect(()=>{
       
       axios.get(url)
       .then(Response => {
        setComments(Response.data)
          // console.log(Response)
       }).catch( Response => {
          // console.log(Response)
       })
    },[])

    return ( 

    <div className="comments-section ">
        <div id="comments" className="comments-area">
            <h2 className="comments-title">03 Comments</h2>
            <ol className="comment-list">
                {
                    comments.map(comment=>(
                        <li id="comment-4" className="comment even thread-even depth-1 parent">
                            <div id="div-comment-4" className="comment-body">
                                <footer className="comment-meta">
                                    <div className="comment-author vcard">
                                        <img src={`../../img/${comment.profilePicture}`} className="avatar photo" alt="avatar"/><b className="fn">{comment.username}</b><span className="says">says:</span>
                                    </div>                    
                                    <div className="comment-metadata">
                                        <a href="index.thml">
                                        <time >{comment.updated}</time>
                                        </a>
                                    </div>
                                </footer>                    
                                <div className="comment-content">
                                <p>{comment.text}</p>
                                </div>
                            </div>
                        </li>
                    ))
                }
                
            </ol>
              <RespondCommnet />
         </div>       
    </div>
     );
}

export default Comment;