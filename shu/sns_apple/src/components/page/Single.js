import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

import Comment from '../ui/single/Comment';
import StickyBar from '../ui/gridfull/StickyBar';
import SinglePostLarge from '../ui/single/SinglePostLarge';
import SinglePostSmall from '../ui/single/SinglePostSmall';
import SingleWrite from '../ui/single/SingleWrite';
import AuthorDetail from '../ui/grid/AuthorDetail';




function Single() {

   const { id } = useParams()
   const url = `http://localhost:3005/post/${id}`

   const [postData, setPostData] = useState({})
  
   
   useEffect(()=>{
      
      axios.get(url)
      .then(Response => {
         setPostData(Response.data)
         console.log(Response)
      }).catch( Response => {
         // console.log(Response)
      })
      
   },[id])

    return (

      <div className="site-content">
         <div className=" atbs-block atbs-block--fullwidth single-block-top">
            <div className="single__thumb">
               <div className="background-img" style={{ background: `url('../.${postData.titleImage}')`}}></div>
            </div>
            <div className="single__text">
               <div className="single__text-inner">
                  <AuthorDetail 
                     userId = {postData.userId}
                  />
                  <div className="single-title">
                     <h1>{postData.postTitle}</h1>
                  </div>
               </div>
            </div>
         </div>
         
         <div className="atbs-block atbs-block--fullwidth">
            <div className="container">
               <div className="row">
                  <div className="atbs-main-col post-single--left">
                     <div className="atbs-block post post-single">
                        <div className="post-single__inner">
                           <SingleWrite />
                           <Comment userId={postData.userId}/>   
                           <SinglePostSmall id = {id}/>
                           <SinglePostLarge /> 
                        </div>
                     </div>
                  </div>
                  <StickyBar userId = {postData.userId}/>
               </div>
            </div>
         </div>
      </div>

      );
}

export default Single ;





