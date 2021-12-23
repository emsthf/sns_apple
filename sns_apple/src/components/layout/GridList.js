import React, { useState,useEffect } from 'react';
import axios from 'axios';

import Title from '../ui/grid/Title';
import GridListVt from '../ui/gridlist/GridListVt';
import HotPost from '../ui/gridlist/HotPost';

function GridList({id, categoryName}) {

   const [postByCategory, setPostByCategory] = useState([])
   const [hotPosts, setHotPosts] = useState([])
   const [evenNumber, setEvenNumber] = useState(false)
   
   useEffect(()=>{
      const url = `http://localhost:3006/postList?categoryId=${id}`
      axios.get(url)
      .then(Response=>{
         //  console.log(Response.data)
          setPostByCategory(Response.data)
          setHotPosts(Response.data.filter(item => item.hotPost === true))
      })

      if(id%2===0){
         setEvenNumber(true)
      }
  },[id])

  

   if(evenNumber) {
      return (
         <div className="atbs-block atbs-block--fullwidth atbs-post-vertical-lists">
         <div className="container">
            <div className="post-vertical-lists__inner">
            <Title title={categoryName} evenNumber={evenNumber}/>
               <div className="post-vertical-lists__wrap">
                  <div className="row">
                     
                     {
                        postByCategory.map(
                          
                           post=>(
                           <GridListVt 
                              key = {post.id}
                              postId = {post.postId}
                           />

                           
                        )).slice(1,4)
                     }
                     {
                        hotPosts.map(item=>(
                           <HotPost 
                              key = {item.id}
                              postId = {item.postId}
                           />
                        )).slice(0,1)
                     }
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
      );
   }
   


    return (

      <div className="atbs-block atbs-block--fullwidth atbs-post-vertical-lists">
         <div className="container">
            <div className="post-vertical-lists__inner">
            <Title title={categoryName} evenNumber={evenNumber}/>
               <div className="post-vertical-lists__wrap">
                  <div className="row">
                     {
                        hotPosts.map(item=>(
                           <HotPost 
                              key = {item.id}
                              postId = {item.postId}
                           />
                        )).slice(0,1)
                     }
                     {
                        postByCategory.map(post=>(
                           <GridListVt 
                              key = {post.id}
                              postId = {post.postId}
                           />
                        )).slice(1,4)
                     }
                  </div>
               </div>
            </div>
         </div>
      </div>
   );
}

export default GridList;


