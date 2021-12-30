import React, { useEffect, useState } from 'react';
import PostExcerpt from '../ui/grid/PostExcerpt';
import PostText from '../ui/grid/PostText';
import Title from '../ui/grid/Title';
import GridADumb from '../ui/grida/GridADumb';
import GridBsp from '../ui/gridb/GridBsp';


function GridB() {

   const[ smallPost, setSmallPost ] = useState([])

   useEffect(()=>{
      fetch("http://localhost:3005/userlist")
      .then (res=>{
         return res.json()
      })
      .then(data=>{
         setSmallPost(data)
         console.log(data)
      })
   },[])

    return ( 
      
      <div className="atbs-block atbs-block--fullwidth atbs-post-grid-b">
            <div className="container">
               <div className="post-grid-b__inner">
                  <Title />
                  <div className="row post-grid-b__wrap">
                     <div className="col-md-8">
                        <div className="post-horizontal-grid-b">
                           <article className="post post--horizontal  post--horizontal-reverse ">
                              <GridADumb />
                              <div className="post__text-wrap">
                                 <div className="post__text">
                                    <PostText />
                                    <PostExcerpt />
                                 </div>
                              </div>
                           </article>
                        </div>
                     </div>
                     <div className="col-md-4">
                        <div className="post-horizontal-list-b">
                           <ul className="post-horizontal-list clearfix">
                           
                                                            
                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
     );
}

export default GridB ;