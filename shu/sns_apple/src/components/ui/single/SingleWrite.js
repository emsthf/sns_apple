import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import axios from 'axios';


function SingleWrite() {

   const { id } = useParams()
   const url = `http://localhost:3005/post/${id}`
   const [postData, setPostData] = useState({})
   const [tagList, setTagList] = useState([])
   
   useEffect(()=>{
      
      axios.get(url)
      .then(Response => {
         setPostData(Response.data)
         setTagList(Response.data.tags)
         // console.log(Response)
      }).catch( Response => {
         // console.log(Response)
      })
   },[url])
   
    return ( 

      <article className=" post post--single type-post status-publish format-standard has-post-thumbnail">
         <div className="single-body__wrap">
            <div className="single-body__inner">
               <div className="single-body-top">
               </div>
               <div className="single-body-bottom"></div>
               <a href="category-1.html" className="single__cat">{postData.postTitle}</a>
               <div className="single__comments-follow-View-share">
                  <div className="comments-follow-View">
                     <ul className="top-single-socials">
                        <li className="item-top-single-socials"><i className="mdicon mdicon-visibility"></i><span> 590 view</span></li>
                        <li className="item-top-single-socials">
                           <i className="mdicon mdicon-comments-o"></i> <span> 590 comments</span>
                        </li>
                        <li className="item-top-single-socials entry-tags hidden-xs">
                           <ul>
                              <li><i className="mdicon mdicon-local_offer"></i></li>
                              {
                                    tagList.map(item=>(
                                       <li key={item.id}>{item.tagName}</li>
                                    ))
                                 }
                           </ul>
                        </li>
                     </ul>
                  </div>
                  <div className="share"><a href="index.html"><i className="mdicon mdicon-share"></i> share</a></div>
               </div>
               <div className="single-body entry-content typography-copy "  >
               <p>{postData.text}</p>
                  <footer className="single-footer entry-footer " >
                     <div className="entry-info">
                        <div className="entry-tags entry-tags-left">
                           <ul>
                              <li><i className="mdicon mdicon-local_offer"></i></li>
                                 {
                                    tagList.map(item=>(
                                       <li key={item.id}>{item.tagName}</li>
                                    ))
                                 }
                           </ul>
                        </div>
                        <div className="entry-share entry-tags-right  ">
                           <div className="share"><a href="index.html"><i className="mdicon mdicon-share"></i> share</a></div>
                        </div>
                     </div>
                  </footer>
               </div>
            </div>
         </div>
      </article>
     );
}

export default SingleWrite;