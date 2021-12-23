import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router';
import axios from 'axios';
import StickyUserProfile from './StickyUserProfile';



function StickyAboutMe() {

   const { id } = useParams();
   const [postData, setPostData] = useState({})

   useEffect(()=>{

      const url = `http://localhost:3005/post/${id}`
      
      axios.get(url)
      .then(Response=>{
         console.log(Response)
         setPostData(Response.data)
         
      })
      
   },[id])

   return ( 
      <div className="atbs-widget widget widget-about-me">
         <div className="about-me__inner">
            <div className="about__thumb">
               <div className="background-img" style={{ background: `url('../.${postData.titleImage}')`}}></div>
               <Link className="link-overlay" to={`/single/${postData.id}`}></Link>
            </div>
            <div className="about__text-wrap ">
               <StickyUserProfile 
                  id = {postData.userId}
               />
               <div className="about__text text-center">
                  <div className="about__excerpt">
                   
                  </div>
                  <ul className="social-list social-list--sm list-horizontal social-list-header">
                     <li>
                        <a href="#"><i className="mdicon mdicon-facebook"></i></a>
                     </li>
                     <li>
                        <a href="#"><i className="mdicon mdicon-twitter"></i></a>
                     </li>
                     <li>
                        <a href="#"><i className="mdicon mdicon-linkedin"></i></a>
                     </li>
                  </ul>
               </div>
            </div>
         </div>
      </div>

   );
}

export default StickyAboutMe;