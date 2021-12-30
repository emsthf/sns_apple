import React from 'react';
import Title from '../ui/grid/Title';
import GridListDumb from '../ui/gridlist/GridListDumb';
import PostText from '../ui/grid/PostText';
import GridAM from '../ui/grida/GridAM';
import GridAS from '../ui/grida/GridAS';


function GridA() {
    return ( 
        
      <div className="atbs-block atbs-block--fullwidth atbs-post-grid-a">
         <div className="container">
            <div className="post-grid-a__inner">
               <Title />
               <div className="post-grid-a__wrap">
                  <div className="post-horizontal-grid-a">
                     <article className="post post--horizontal">
                        <GridListDumb />
                        <PostText />
                     </article>
                  </div>
                  <GridAM />
                  <GridAS/>
               </div>
            </div>
         </div>
      </div>


   );
}

export default GridA;